package by.nenartovich.spring_app.creo_service;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcComponentFeat.ComponentConstraintType;
import com.ptc.pfc.pfcComponentFeat.ComponentFeat;

public interface ComponentFeatService {
    void ComponentFeatConstraint(ComponentFeat componentFeat, ComponentConstraintType constraintType) throws jxthrowable;
}
