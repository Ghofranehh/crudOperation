package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HomeController {
	@Autowired
    private StudentRepository studentRepository;
	 @GetMapping("/")
	public String index() {
		return "welcome to spring boot crud ";
	}
	 
	 //POST 
	 @PostMapping("/saveStudent")
	 public Student SaveData(@RequestBody Student student) {
		 studentRepository.save(student);
		 return student;
		 
	 }
	 
	 
	 //GET 
	 @GetMapping("/getStudent/{rollNo}")
	 public Student getStudentData(@PathVariable int rollNo) {
		 Optional<Student> student= studentRepository.findById(rollNo);
		 Student student1=student.get();
		 return student1;
	 }
	 
	 
	 //GET ALL
	  @GetMapping("/getAllStudent")
	  public List<Student> getALL(){
		  List<Student> studentList = studentRepository.findAll();
		  return studentList;
	  }
	  
	  //DELETE 
	  
	  @DeleteMapping("/deleteStudent/{rollNo}")
	  public String deleteStudent (@PathVariable int rollNo) {
	  Student student= studentRepository.findById(rollNo).get();
	  if (student!=null)
		  studentRepository.delete(student);
	  return "Deleted Successfully!!";
	  }
	  
	 
}
