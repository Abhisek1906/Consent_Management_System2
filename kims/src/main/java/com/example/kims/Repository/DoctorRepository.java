package com.example.kims.Repository;

import com.example.kims.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findDoctorByDoctorId(int id);
}
