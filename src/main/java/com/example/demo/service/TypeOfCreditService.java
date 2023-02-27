package com.example.demo.service;

import com.example.demo.entity.TypeOfCredit;
import com.example.demo.repository.ITypesOfCreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfCreditService {

    private ITypesOfCreditRepository typesOfCreditRepository;

    public TypeOfCreditService(ITypesOfCreditRepository typesOfCreditRepository){
        this.typesOfCreditRepository = typesOfCreditRepository;
    }

    public List<TypeOfCredit> getAllTypesOfCredit(){
        return typesOfCreditRepository.findAll();
    }

    public TypeOfCredit findById(Long id){
        Optional<TypeOfCredit> creditOptional = typesOfCreditRepository.findById(id);
        return creditOptional.get();
    }

    public TypeOfCredit createTypeOfCredit(TypeOfCredit typeOfCredit){
        return typesOfCreditRepository.save(typeOfCredit);
    }

    public void deleteById(Long id){
        typesOfCreditRepository.deleteById(id);
    }

}
