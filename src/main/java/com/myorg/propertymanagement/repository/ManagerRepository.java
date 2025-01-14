package com.myorg.propertymanagement.repository;

import com.myorg.propertymanagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByEmailAndPassword(String email, String password);
}
