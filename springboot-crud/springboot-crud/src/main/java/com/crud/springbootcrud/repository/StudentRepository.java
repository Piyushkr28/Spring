package com.crud.springbootcrud.repository;

import com.crud.springbootcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

///import javax.persistence.Id;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //all crud database methods

}
