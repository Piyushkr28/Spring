package com.crud.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;

    @Column(name = "student_no")
    private Integer studentNo;
    @Column(name="student_name")
    private String studentName;
    @Column(name="student_dob")
    private String studentDob;
    @Column(name="student_doj")
    private String studentDoj;
}
