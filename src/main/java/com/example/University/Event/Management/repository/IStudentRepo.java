package com.example.University.Event.Management.repository;

import com.example.University.Event.Management.module.Student;
import com.example.University.Event.Management.module.StudentDep;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer>{

    //Custom Finders
    public void deleteByLastName(String last_name);

    //CustomQuery
    @Modifying
    @Query(value = "update student set department = :department where student_id = :StudentId", nativeQuery = true)
    public void updateDepartmentById(Integer StudentId, StudentDep department);

}
