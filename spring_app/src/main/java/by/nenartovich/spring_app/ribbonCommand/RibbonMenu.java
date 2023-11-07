package by.nenartovich.spring_app.ribbonCommand;


import com.ptc.cipjava.jxthrowable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RibbonMenu {

    private final List<RibbonCommand> ribbonCommands = new ArrayList<>();

    public void setupRibbonCommands() throws jxthrowable {
        for (RibbonCommand ribbonCommand : ribbonCommands) {
            ribbonCommand.getCommand();
        }
    }

    public void register(RibbonCommand ribbonCommand) {
        ribbonCommands.add(ribbonCommand);
    }
}
