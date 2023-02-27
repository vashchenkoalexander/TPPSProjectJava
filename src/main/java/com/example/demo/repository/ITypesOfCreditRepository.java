package com.example.demo.repository;

import com.example.demo.entity.TypeOfCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypesOfCreditRepository extends JpaRepository<TypeOfCredit, Long> {
}
