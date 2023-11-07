package by.nenartovich.spring_app.creo_service.impl;

import by.nenartovich.spring_app.creo_service.ParameterService;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcModelItem.ParamValue;
import com.ptc.pfc.pfcModelItem.Parameter;
import com.ptc.pfc.pfcModelItem.pfcModelItem;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {
    @Override
    public Parameter createStringParamValue(Model model, String name, String value) throws jxthrowable {
        ParamValue paramValue = pfcModelItem.CreateStringParamValue(value);
        return model.CreateParam(name, paramValue);
    }
}
