package com.example.Producttracking.controller;

import com.example.Producttracking.dto.MetadataDto;
import com.example.Producttracking.entity.Metadata;
import com.example.Producttracking.services.MetadataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/metadata")
public class MetadataController {

    private final MetadataService metadataService;
    private final ModelMapper modelMapper;

    @Autowired
    public MetadataController(MetadataService metadataService, ModelMapper modelMapper) {
        this.metadataService = metadataService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Metadata> getMetadata(){

        return metadataService.getMetadata();
    }

    @PostMapping
    public void registerMetadata (@RequestBody MetadataDto metadataDto){

        metadataService.registerMetadata(metadataDto);
    }

    
}
