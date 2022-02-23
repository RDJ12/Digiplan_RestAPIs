package com.digiplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiplan.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
