package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
    }

    public Student saveStudent(Student student) {
        return repository.save(student);   // insert if id is null, update otherwise
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
