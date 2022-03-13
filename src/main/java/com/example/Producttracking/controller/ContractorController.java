package com.example.Producttracking.controller;

import com.example.Producttracking.entity.Contractors;
import com.example.Producttracking.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/contractor")
public class ContractorController {

    private final ContractorService contractorService;

    @Autowired
    public ContractorController(ContractorService contractorService) {

        this.contractorService = contractorService;
    }

    @GetMapping
    public List<Contractors> getContractors(){

        return contractorService.getContractors();
    }

    @PostMapping
    public void registerContractor(@RequestBody Contractors contractors){
        contractorService.registerContractor(contractors);
    }

    @DeleteMapping(path = "{contractor_id}")
    public void deleteContractor(@PathVariable("contractor_id") Long contractor_id){
        contractorService.deleteContractor(contractor_id);
    }

    @PutMapping(path = "{contractor_id}")
    public void updateContractor(
            @PathVariable("contractor_id") Long contractor_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phonenumber,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password
    ){
        contractorService.updateContractor(contractor_id, name, email, phonenumber, username, password);
    }
}
