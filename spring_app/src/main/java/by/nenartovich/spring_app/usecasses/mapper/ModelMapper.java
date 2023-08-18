package by.nenartovich.spring_app.usecasses.mapper;


import by.nenartovich.spring_app.persistence.model.Model;
import by.nenartovich.spring_app.usecasses.dto.ModelDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {
    Model toEntity(ModelDto modelDto);

    ModelDto toDto(Model model);
    List<ModelDto> toDtoAll(List<Model> models);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Model partialUpdate(ModelDto modelDto, @MappingTarget Model model);
}