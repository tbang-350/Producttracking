package com.example.Producttracking.services;

import com.example.Producttracking.entity.Metadata;
import com.example.Producttracking.repository.MetadataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {

    private final MetadataRepository metadataRepository;

    public MetadataService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public List<Metadata> getMetadata() {
        return metadataRepository.findAll();
    }
}
