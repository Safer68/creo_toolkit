package by.nenartovich.spring_app.creo_service.impl;

import by.nenartovich.spring_app.creo_service.ComponentFeatService;
import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcComponentFeat.ComponentConstraint;
import com.ptc.pfc.pfcComponentFeat.ComponentConstraintType;
import com.ptc.pfc.pfcComponentFeat.ComponentConstraints;
import com.ptc.pfc.pfcComponentFeat.ComponentFeat;
import com.ptc.pfc.pfcComponentFeat.pfcComponentFeat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComponentFeatServiceImpl implements ComponentFeatService {
    @Override
    public void ComponentFeatConstraint(ComponentFeat componentFeat, ComponentConstraintType constraintType) throws jxthrowable {
        ComponentConstraint componentConstraint = pfcComponentFeat.ComponentConstraint_Create(constraintType);
        ComponentConstraints componentConstraints = ComponentConstraints.create();
        componentConstraints.append(componentConstraint);
        componentFeat.SetConstraints(componentConstraints, null);
    }
}
