package by.nenartovich.spring_app.creo_service;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcModel.Model;

public interface ModelService {
    Model create(String name) throws jxthrowable;
}
