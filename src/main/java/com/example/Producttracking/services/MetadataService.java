package com.example.Producttracking.services;

import com.example.Producttracking.dto.MetadataDto;
import com.example.Producttracking.entity.Metadata;
import com.example.Producttracking.repository.MetadataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetadataService {

    private final MetadataRepository metadataRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MetadataService(MetadataRepository metadataRepository, ModelMapper modelMapper) {
        this.metadataRepository = metadataRepository;
        this.modelMapper = modelMapper;
    }

    public List<Metadata> getMetadata() {
        return metadataRepository.findAll();
    }

    public void registerMetadata(Metadata metadata1) {

        Metadata metadata = modelMapper.map(metadata1,Metadata.class);

        Optional<Metadata> metadataOptional = metadataRepository.findById(metadata.getMeta_id());

        if (metadataOptional.isPresent()){
            throw new IllegalStateException("metadata exist");
        }

        metadataRepository.save(metadata);
    }

    public void createSaveTest(final Long emp_id,
                               final Double lat,
                               final Double lon) {
        metadataRepository.createOrUpdate(emp_id, lat, lon);
    }


}
