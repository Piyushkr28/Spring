package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.exception.ResourceNotFoundException;
import com.crud.springbootcrud.model.Student;
import com.crud.springbootcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }
    //code for creating Student RestAPI
    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    //code to get Student by id REST API
    @GetMapping("{s_id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long s_id)
    {
        Student student = studentRepository.findById(s_id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: "+s_id));
        return ResponseEntity.ok(student);
    }
    //code to update student by id
    @PutMapping("{s_id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long s_id,@RequestBody Student studentDetail)
    {
        Student updateStudent = studentRepository.findById(s_id).orElseThrow(() -> new ResourceNotFoundException("Student id not found: "+s_id));
        updateStudent.setStudentNo(studentDetail.getStudentNo());
        updateStudent.setStudentName(studentDetail.getStudentName());
        updateStudent.setStudentDob(studentDetail.getStudentDob());
        updateStudent.setStudentDoj(studentDetail.getStudentDoj());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }
    //code to delete by id
    @DeleteMapping("{s_id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long s_id)
    {
        Student student = studentRepository.findById(s_id).orElseThrow(() -> new ResourceNotFoundException("Student id not found: "+s_id));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
