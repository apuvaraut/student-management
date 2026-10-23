package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    // READ - list all
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    // CREATE - show empty form
    @GetMapping("/students/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("title", "Add Student");
        return "student-form";
    }

    // UPDATE - show form filled with existing data
    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        model.addAttribute("title", "Edit Student");
        return "student-form";
    }

    // CREATE + UPDATE - save the form
    @PostMapping("/students/save")
    public String saveStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", student.getId() == null ? "Add Student" : "Edit Student");
            return "student-form";
        }
        service.saveStudent(student);
        return "redirect:/students";
    }

    // DELETE
    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
