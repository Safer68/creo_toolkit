package by.nenartovich.spring_app.ribbonCommand;

import by.nenartovich.spring_app.ribbonCommand.listener.ListenerCreateModelRibbonCommand;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.UICommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateModelRibbonCommand implements RibbonCommand {
    private final CreoSession session;
    private final ListenerCreateModelRibbonCommand listenerCreateModelRibbonCommand;
    private final String msgFile = "ribbon_button_configuration.txt";

    @Override
    public void getCommand() throws jxthrowable {
        UICommand newSkell = session.getSession().UICreateCommand("newSkell", listenerCreateModelRibbonCommand);
        newSkell.Designate(msgFile, "newSkell", (String) null, (String) null);
    }
}
