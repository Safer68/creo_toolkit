package by.nenartovich.spring_app.creo_service;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcModelItem.Parameter;

public interface ParameterService {
    Parameter createStringParamValue(Model model, String name, String value) throws jxthrowable;
}
