package by.nenartovich.spring_app.ui;

import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcUI.MessageDialogOptions;
import com.ptc.pfc.pfcUI.MessageDialogType;
import com.ptc.pfc.pfcUI.pfcUI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageDialogInfo implements MessageDialog {
    private final CreoSession creoSession;

    @Override
    public void show(String massage) throws jxthrowable {
        MessageDialogOptions messageDialogOptions = getMessageDialogOptions();
        messageDialogOptions.SetDialogLabel("Info");
        messageDialogOptions.SetMessageDialogType(MessageDialogType.MESSAGE_QUESTION);
        creoSession.getSession().UIShowMessageDialog(massage, messageDialogOptions);
    }

    private MessageDialogOptions getMessageDialogOptions() throws jxthrowable {
        return pfcUI.MessageDialogOptions_Create();
    }
}
