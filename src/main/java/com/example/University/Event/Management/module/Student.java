package com.example.University.Event.Management.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name ="StudentId")
    private Integer studentId;

    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstName;

    private String lastName;

   @Min(value = 18, message = "Age should be Greater Than 18")
   @Max(value = 25, message = "Age should be Less Than 18")
    private Integer age;

   @Enumerated(EnumType.STRING)
    private StudentDep department;
}
