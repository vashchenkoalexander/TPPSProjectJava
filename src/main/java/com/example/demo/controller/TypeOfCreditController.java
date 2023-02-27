package com.example.demo.controller;

import com.example.demo.entity.TypeOfCredit;
import com.example.demo.service.TypeOfCreditService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tpps/v1/typeofcredit/")
public class TypeOfCreditController {

    private TypeOfCreditService typeOfCreditService;

    public TypeOfCreditController(TypeOfCreditService typeOfCreditService){
        this.typeOfCreditService = typeOfCreditService;
    }

    @GetMapping("credits")
    public List<TypeOfCredit> getAllTypeOfCredit(){
        return typeOfCreditService.getAllTypesOfCredit();
    }

    @GetMapping("{id}")
    public TypeOfCredit getTypeOfCreditById(@PathVariable Long id){
        return typeOfCreditService.findById(id);
    }

    @PostMapping("new")
    public TypeOfCredit createTypeOfCredit (@RequestBody TypeOfCredit typeOfCredit){
        return typeOfCreditService.createTypeOfCredit(typeOfCredit);
    }

    @DeleteMapping("deleteby{id}")
    public void deleteTypeOfCreditById(@PathVariable Long id){
        typeOfCreditService.deleteById(id);
    }

}
