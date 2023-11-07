package by.nenartovich.spring_app.ui;

import com.ptc.cipjava.jxthrowable;

public interface MessageDialog {
    void showMessageTypeQuestion(String massage) throws jxthrowable;
    void showMessageTypeInfo(String massage) throws jxthrowable;
    void showMessageTypeWarning(String massage) throws jxthrowable;
}
