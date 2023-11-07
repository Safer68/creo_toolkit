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
public class ImplMessageDialog implements MessageDialog {
    private final CreoSession creoSession;

    @Override
    public void showMessageTypeQuestion(String massage) throws jxthrowable {
        MessageDialogOptions messageDialogOptions = getMessageDialogOptions();
        messageDialogOptions.SetMessageDialogType(MessageDialogType.MESSAGE_QUESTION);
        ShowMessageDialog(massage, messageDialogOptions);
    }

    @Override
    public void showMessageTypeInfo(String massage) throws jxthrowable {
        MessageDialogOptions messageDialogOptions = getMessageDialogOptions();
        messageDialogOptions.SetMessageDialogType(MessageDialogType.MESSAGE_INFO);
        ShowMessageDialog(massage, messageDialogOptions);
    }

    @Override
    public void showMessageTypeWarning(String massage) throws jxthrowable {
        MessageDialogOptions messageDialogOptions = getMessageDialogOptions();
        messageDialogOptions.SetMessageDialogType(MessageDialogType.MESSAGE_WARNING);
        ShowMessageDialog(massage, messageDialogOptions);
    }

    private void ShowMessageDialog(String massage, MessageDialogOptions messageDialogOptions) throws jxthrowable {
        creoSession.getSession().UIShowMessageDialog(massage, messageDialogOptions);
    }

    private MessageDialogOptions getMessageDialogOptions() throws jxthrowable {
        return pfcUI.MessageDialogOptions_Create();
    }
}
