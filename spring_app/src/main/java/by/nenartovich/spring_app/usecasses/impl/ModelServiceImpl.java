package by.nenartovich.spring_app.usecasses.impl;


import by.nenartovich.spring_app.persistence.repository.ModelRepository;
import by.nenartovich.spring_app.usecasses.ModelService;
import by.nenartovich.spring_app.usecasses.dto.ModelDto;
import by.nenartovich.spring_app.usecasses.mapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Override
    public ModelDto save(ModelDto modelDto) {
        return modelMapper.toDto(modelRepository.save(modelMapper.toEntity(modelDto)));
    }

    @Override
    public List<ModelDto> getAll() {
        return modelMapper.toDtoAll(modelRepository.findAll());
    }

    @Override
    public ModelDto getById(long id) {
        return modelMapper.toDto(modelRepository.getReferenceById(id));
    }
}