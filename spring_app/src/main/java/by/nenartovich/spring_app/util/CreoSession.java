package by.nenartovich.spring_app.util;


import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcSession.CreoCompatibility;
import com.ptc.pfc.pfcSession.Session;
import com.ptc.pfc.pfcSession.pfcSession;
import org.springframework.stereotype.Component;


@Component
public class CreoSession {
    private final Session session = createSession();

    public Session getSession() {
        return session;
    }

    private Session createSession() {
        try {
            return pfcSession.GetCurrentSessionWithCompatibility(CreoCompatibility.C4Compatible);
        } catch (jxthrowable e) {
            throw new RuntimeException(e);
        }
    }
}
