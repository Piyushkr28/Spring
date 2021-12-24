package com.crud.springbootcrud;

import com.crud.springbootcrud.model.Student;
import com.crud.springbootcrud.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {

//	public SpringbootCrudApplication(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) {
		Student s = new Student();
		s.setStudentNo(200970119);
		s.setStudentName("Piyush Kumar");
		s.setStudentDob("28-09-1998");
		s.setStudentDoj("21-09-2021");
		studentRepository.save(s);

		Student s1 = new Student();
		s1.setStudentNo(200970120);
		s1.setStudentName("Sanat Kumar");
		s1.setStudentDob("23-07-1998");
		s1.setStudentDoj("21-09-2021");
		studentRepository.save(s1);



	}
}
