package by.nenartovich.spring_app.creo_service.impl;

import by.nenartovich.spring_app.creo_service.ModelService;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcModel.ModelDescriptor;
import com.ptc.pfc.pfcModel.pfcModel;
import com.ptc.pfc.pfcSession.pfcSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final CreoSession session;
    @Value("${creo.templatePrt}")
    private String temples;

    @Override
    public Model create(String name) throws jxthrowable {
        String startModelDir = session.getSession().GetConfigOption("start_model_dir");
        ModelDescriptor desc = pfcModel.ModelDescriptor_CreateFromFileName(temples);
        desc.SetPath(startModelDir);
        Model model = session.getSession().RetrieveModelWithOpts(desc, pfcSession.RetrieveModelOptions_Create());
        Model newModel = model.CopyAndRetrieve(name, null);
        model.Erase();
        return newModel;
    }
}
