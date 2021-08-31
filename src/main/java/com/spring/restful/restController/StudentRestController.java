package com.spring.restful.restController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.spring.restful.entity.Student;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {

		students = new ArrayList<>();

		students.add(new Student("Porrima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}


	/**
	 * http://localhost:8082/api/students
	 */
	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	/**
	 * http://localhost:8082/api/students/(id)
	 */
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if ( (studentId >= students.size()) || (studentId < 0) ) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return students.get(studentId);

	}

	/**
	 * http://localhost:8082/api/studentId?id=(id)
	 */
	@GetMapping("/studentId")
	public Student getStudentId(@RequestParam int id) {
		if ( (id >= students.size()) || (id < 0) ) {
			throw new StudentNotFoundException("Student id not found - " + id);
		}

		return students.get(id);
	}

}









