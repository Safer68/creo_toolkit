package by.nenartovich.spring_app.ribbonCommand.listener;


import by.nenartovich.spring_app.creo_service.AssemblyService;
import by.nenartovich.spring_app.creo_service.ComponentFeatService;
import by.nenartovich.spring_app.creo_service.DrawingService;
import by.nenartovich.spring_app.creo_service.ModelService;
import by.nenartovich.spring_app.ui.ImplMessageDialog;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcAssembly.Assembly;
import com.ptc.pfc.pfcCommand.DefaultUICommandActionListener;
import com.ptc.pfc.pfcComponentFeat.ComponentConstraintType;
import com.ptc.pfc.pfcComponentFeat.ComponentFeat;
import com.ptc.pfc.pfcDrawing.Drawing;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcModel.ModelType;
import com.ptc.pfc.pfcSolid.Solid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ListenerCreateModelRibbonCommand extends DefaultUICommandActionListener {
    private final ImplMessageDialog messageDialog;
    private final CreoSession creoSession;
    private final AssemblyService assemblyService;
    private final ModelService modelService;
    private final ComponentFeatService componentFeatService;
    private final DrawingService drawingService;

    @Override
    public void OnCommand() throws jxthrowable {
        Assembly assembly;
        Model modelCurrentSession = creoSession.getSession().GetCurrentModel();
        if (null == modelCurrentSession) {
            messageDialog.showMessageTypeQuestion("Сборка не открыта!");
            return;
        }
        if (modelCurrentSession.GetType() != ModelType.MDL_ASSEMBLY) {
            messageDialog.showMessageTypeQuestion("Должна быть открыта сборка");
            return;
        }
        assembly = (Assembly) modelCurrentSession;
        String assemblyName = assembly.GetFileName().replaceAll(".asm", "");
        Model modelMg = modelService.create(assemblyName + "mg");
        ComponentFeat componentFeatMg = (ComponentFeat) assemblyService.addComponent(assembly, (Solid) modelMg);
        componentFeatService.ComponentFeatConstraint(componentFeatMg, ComponentConstraintType.ASM_CONSTRAINT_DEF_PLACEMENT);
        Assembly assemblyRg = assemblyService.create(assemblyName + "rg");
        Drawing drawing = drawingService.create(assemblyName, assembly);
        drawing.AddModel(assemblyRg);
        drawing.AddModel(modelMg);
        drawing.Save();
    }
}
