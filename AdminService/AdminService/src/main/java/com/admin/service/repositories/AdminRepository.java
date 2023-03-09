package com.admin.service.repositories;

import com.admin.service.entities.Admin;
import com.admin.service.entities.Doctor;
import com.admin.service.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
//custom finder methods



}
