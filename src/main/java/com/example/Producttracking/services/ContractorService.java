package com.example.Producttracking.services;

import com.example.Producttracking.entity.Contractors;
import com.example.Producttracking.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public List<Contractors> getContractors() {

        return contractorRepository.findAll();
    }

    public void registerContractor(Contractors contractors) {
        Optional<Contractors> contractorOptional = contractorRepository.findContractorByUsername(contractors.getUsername());

        if (contractorOptional.isPresent()){
            throw new IllegalStateException("contractor exists");
        }

        contractorRepository.save(contractors);

    }

    public void deleteContractor(Long contractor_id) {
        boolean exists = contractorRepository.existsById(contractor_id);

        if (!exists){
            throw new IllegalStateException("contractor with id "+contractor_id+" does not exist");
        }
        contractorRepository.deleteById(contractor_id);
    }

    public void updateContractor(Long contractor_id, String name, String email, String phonenumber, String username, String password) {
        Contractors contractors = contractorRepository.findById(contractor_id)
                .orElseThrow(() -> new IllegalStateException("contractor with id "+contractor_id+" does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(contractors.getName(), name)){
            contractors.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(contractors.getEmail(), email)){
            contractors.setEmail(email);
        }

        if (phonenumber != null && phonenumber.length() > 0 && !Objects.equals(contractors.getPhonenumber(), phonenumber)){
            contractors.setPhonenumber(phonenumber);
        }

        if (username != null && username.length() > 0 && !Objects.equals(contractors.getUsername(), username)){
            Optional<Contractors> contractorsOptional = contractorRepository.findContractorByUsername(username);

            if (contractorsOptional.isPresent()){
                throw new IllegalStateException("username exists");
            }

            contractors.setUsername(username);
        }

        if (password != null && password.length() > 0 && !Objects.equals(contractors.getPassword(), password)){
            contractors.setPassword(password);
        }
    }
}
