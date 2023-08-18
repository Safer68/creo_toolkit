package by.nenartovich.spring_app.ribbonCommand;

import com.ptc.cipjava.jxthrowable;
import org.springframework.beans.factory.annotation.Autowired;

public interface RibbonCommand {
    void getCommand() throws jxthrowable;

    @Autowired
    default void registerCommand(RibbonMenu ribbonMenu) {
       ribbonMenu.register(this);
    }
}
