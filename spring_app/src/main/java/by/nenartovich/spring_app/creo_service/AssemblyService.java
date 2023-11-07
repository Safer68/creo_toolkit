package by.nenartovich.spring_app.creo_service;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcAssembly.Assembly;
import com.ptc.pfc.pfcFeature.Feature;
import com.ptc.pfc.pfcSolid.Solid;

import java.util.List;

public interface AssemblyService {
    Assembly create(String name) throws jxthrowable;

    Assembly open(String name) throws jxthrowable;

    Feature addComponent(Assembly assembly, Solid solid) throws jxthrowable;
    List<Feature> addComponentList(Assembly assembly, List<Solid> solidList) throws jxthrowable;
}
