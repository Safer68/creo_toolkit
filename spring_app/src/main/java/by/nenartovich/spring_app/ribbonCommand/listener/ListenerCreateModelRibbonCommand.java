package by.nenartovich.spring_app.ribbonCommand.listener;


import by.nenartovich.spring_app.ui.MessageDialogInfo;
import by.nenartovich.spring_app.usecasses.ModelService;
import by.nenartovich.spring_app.usecasses.dto.ModelDto;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.DefaultUICommandActionListener;
import com.ptc.pfc.pfcSession.BaseSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListenerCreateModelRibbonCommand extends DefaultUICommandActionListener implements CommandActionListener {
    private final MessageDialogInfo messageDialog;
    private final ModelService modelService;
    private final CreoSession creoSession;

    @Override
    public void OnCommand() throws jxthrowable {
        BaseSession baseSession = creoSession.getSession();
        String s = baseSession.GetCurrentDirectory();
        messageDialog.show(s);
        List<ModelDto> modelDtos = modelService.getAll();
        modelDtos.size();
        if (modelDtos.size() != 0) {
            ModelDto modelDto = modelDtos.get(1);
            String s2 = modelDto.name();
            messageDialog.show(s2);
        }
    }
}
