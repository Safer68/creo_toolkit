package by.nenartovich.spring_app.creo_service.impl;

import by.nenartovich.spring_app.creo_service.AssemblyService;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcAssembly.Assembly;
import com.ptc.pfc.pfcFeature.Feature;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcModel.ModelDescriptor;
import com.ptc.pfc.pfcModel.pfcModel;
import com.ptc.pfc.pfcSession.pfcSession;
import com.ptc.pfc.pfcSolid.Solid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssemblyServiceImpl implements AssemblyService {
    @Value("${creo.templateAsm}")
    private String template;
    private final CreoSession session;

    @Override
    public Assembly create(String name) throws jxthrowable {
        String startModelDir = session.getSession().GetConfigOption("start_model_dir");
        ModelDescriptor desc = pfcModel.ModelDescriptor_CreateFromFileName(template);
        desc.SetPath(startModelDir);
        Model model = session.getSession().RetrieveModelWithOpts(desc, pfcSession.RetrieveModelOptions_Create());
        Assembly assembly = (Assembly) model.CopyAndRetrieve(name, null);
        model.Erase();
        return assembly;
    }

    @Override
    public Assembly open(String name) throws jxthrowable {
        return (Assembly) session.getSession().RetrieveModel(pfcModel.ModelDescriptor_CreateFromFileName(name + ".asm"));
    }

    @Override
    public Feature addComponent(Assembly assembly, Solid solid) {
        try {
            Feature feature = assembly.AssembleComponent(solid, null);
            return feature;
        } catch (jxthrowable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Feature> addComponentList(Assembly assembly, List<Solid> solidList) {
        List<Feature> featureList;
        featureList = solidList.stream().map(solid -> addComponent(assembly, solid)).toList();
        return featureList;
    }
}
