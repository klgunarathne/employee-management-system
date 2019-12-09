package com.example.server.AllocateEmp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AllocateRepository extends JpaRepository<Allocate, Long> {

    @Query(value = "SELECT * FROM Allocates a where a.e_no = ?1 and a.to_date >= ?2", nativeQuery = true)
    public List<Allocates> GetAllocationsByEmployeeNo(String e_no, LocalDate today);
}
