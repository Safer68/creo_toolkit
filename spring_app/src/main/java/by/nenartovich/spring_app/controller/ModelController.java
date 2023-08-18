package by.nenartovich.spring_app.controller;

import by.nenartovich.spring_app.usecasses.ModelService;
import by.nenartovich.spring_app.usecasses.dto.ModelDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping("/models")
    @Operation(summary = "get all mode")
    public ResponseEntity<List<ModelDto>> getProductClient() {
        List<ModelDto> modelDtos = modelService.getAll();
        return ResponseEntity.ok(modelDtos);
    }

    @PostMapping("/model")
    @Operation(summary = "Save model")
    public ResponseEntity<ModelDto> getQueryResult(@RequestBody ModelDto modelDto) {
        ModelDto savedModelDto = modelService.save(modelDto);
        return ResponseEntity.ok(savedModelDto);
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<ModelDto> getClient(@PathVariable("id") int id) {
        ModelDto modelDto = modelService.getById(id);
        return ResponseEntity.ok(modelDto);
    }
}
