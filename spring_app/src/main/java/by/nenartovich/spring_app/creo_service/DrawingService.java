package by.nenartovich.spring_app.creo_service;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcDrawing.Drawing;
import com.ptc.pfc.pfcModel.Model;

public interface DrawingService {
    Drawing create(String name, Model model) throws jxthrowable;
}
