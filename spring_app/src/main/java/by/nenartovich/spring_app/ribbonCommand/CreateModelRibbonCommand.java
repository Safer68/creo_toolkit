package by.nenartovich.spring_app.ribbonCommand;

import by.nenartovich.spring_app.ribbonCommand.listener.ListenerCreateModelRibbonCommand;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.UICommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateModelRibbonCommand implements RibbonCommand {
    private final CreoSession session;
    private final ListenerCreateModelRibbonCommand listenerCreateModelRibbonCommand;
    @Value("${creo.msgFile}")
    private String msgFile;

    @Override
    public void getCommand() throws jxthrowable {
        UICommand newSkell = session.getSession().UICreateCommand("newSkell", listenerCreateModelRibbonCommand);
        newSkell.Designate(msgFile, "newSkell", null, null);
    }
}
