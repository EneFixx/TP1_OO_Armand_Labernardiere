
package com.example.TP1.repository;

import com.example.TP1.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findByCarPlateNumberAndActiveTrue(String plateNumber);

    List<Contract> findByActiveTrue();

    List<Contract> findByClientId(Long clientId);
}