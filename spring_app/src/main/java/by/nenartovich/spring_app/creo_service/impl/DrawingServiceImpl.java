package by.nenartovich.spring_app.creo_service.impl;

import by.nenartovich.spring_app.creo_service.DrawingService;
import by.nenartovich.spring_app.util.CreoSession;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcDrawing.Drawing;
import com.ptc.pfc.pfcDrawing.DrawingCreateOption;
import com.ptc.pfc.pfcDrawing.DrawingCreateOptions;
import com.ptc.pfc.pfcModel.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrawingServiceImpl implements DrawingService {
    @Value("${creo.templateDrw}")
    private String template;
    private final CreoSession session;

    @Override
    public Drawing create(String name, Model model) throws jxthrowable {
        DrawingCreateOptions drawingCreateOptions = DrawingCreateOptions.create();
        drawingCreateOptions.append(DrawingCreateOption.DRAWINGCREATE_PROMPT_UNKNOWN_PARAMS);
        return session.getSession().CreateDrawingFromTemplate(name, template, model.GetDescr(), drawingCreateOptions);
    }
}
