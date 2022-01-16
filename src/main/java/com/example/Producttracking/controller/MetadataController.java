package com.example.Producttracking.controller;

import com.example.Producttracking.entity.Metadata;
import com.example.Producttracking.services.MetadataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping
    public List<Metadata> getMetadata(){
        return metadataService.getMetadata();
    }
}
