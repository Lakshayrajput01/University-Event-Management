package com.example.University.Event.Management.service;

import com.example.University.Event.Management.module.Student;
import com.example.University.Event.Management.module.StudentDep;
import com.example.University.Event.Management.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String InsertStudent(List<Student> student) {
        Iterable<Student> Added = iStudentRepo.saveAll(student);
        if(Added !=null){
            return "Added Successfully";
        }
        return "Failed to Add..!!";
    }

    public Iterable<Student> FetchData() {
       return iStudentRepo.findAll();
    }

    public Optional<Student> ById(Integer studentId) {
        return iStudentRepo.findById(studentId);
    }

    public void DeleteName(String name) {
        iStudentRepo.deleteByLastName(name);
    }

    @Transactional
    public void UpdateStudentByDepartment(Integer StudentId, StudentDep department){
        iStudentRepo.updateDepartmentById(StudentId,department);
    }
}
