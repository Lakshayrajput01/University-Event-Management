package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.module.Student;
import com.example.University.Event.Management.module.StudentDep;
import com.example.University.Event.Management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
        @Autowired
    StudentService studentService;

        @PostMapping(value = "/students")
    public String AddStudents(@Valid @RequestBody List<Student> Student){
            return studentService.InsertStudent(Student);
        }

        @GetMapping(value = "/students")
    public Iterable<Student> GetStudent(){
            return studentService.FetchData();
        }

        //get StudentById
    @GetMapping(value = "/students/Id/{StudentId}")
    public Optional<Student> GetStudentById(@PathVariable Integer StudentId){
            return studentService.ById(StudentId);
    }

    @DeleteMapping(value = "/students/name/{name}")
    public void DeleteByStudentName(@PathVariable String name){
        studentService.DeleteName(name);
    }
    @PutMapping(value = "/students/Id/{ID}/Department{Department}")
    public void UpdateStudentByDepartment(@PathVariable Integer ID,@PathVariable StudentDep Department){
        studentService.UpdateStudentByDepartment(ID,Department);
    }


}
