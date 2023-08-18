package by.nenartovich.spring_app.usecasses;

import by.nenartovich.spring_app.usecasses.dto.ModelDto;

import java.util.List;

public interface ModelService {

    ModelDto save(ModelDto modelDto);
    List <ModelDto> getAll();
    ModelDto getById(long id);
}


