package com.example.server.AllocateEmp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocateRepository extends JpaRepository<Allocate, Long> {

}
