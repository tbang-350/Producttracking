package com.example.Producttracking.controller;

import com.example.Producttracking.dto.MetadataDto;
import com.example.Producttracking.entity.Metadata;
import com.example.Producttracking.services.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    @Autowired
    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
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
