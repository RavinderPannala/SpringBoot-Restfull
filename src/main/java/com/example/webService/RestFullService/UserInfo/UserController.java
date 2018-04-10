package com.example.webService.RestFullService.UserInfo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.webService.RestFullService.Exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource messageSource;

	// retrieve all Students
	@GetMapping("/students")
	public List<Resource<Student>> retrieveAllStudents() {
		List<Student> students=userService.getAllstudents();
		List<Resource<Student>> resources=new ArrayList<>();
		for(Student s:students){
			Resource<Student> resource= new Resource<Student>(s);
			ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).findOne(s.getId()));
			ControllerLinkBuilder link1=linkTo(methodOn(this.getClass()).retrieveAllSubjects(s.getId()));
			ControllerLinkBuilder link2=linkTo(methodOn(this.getClass()).retrieveOneStudentSubject(s.getId(),s.getSubjects().get(0).getId()));
			resource.add(link.withRel("all-Students"));
			resource.add(link1.withRel("All-Subjects"));
			resource.add(link2.withRel("Subject"));
			resources.add(resource);
		}
		return resources;
	}

	// retrieve one Student
	@GetMapping("/students/{id}")
	public Resource<Student> findOne(@PathVariable int id) {
		Student student = userService.findById(id);
		if (student == null)
			throw new UserNotFoundException("id-:" + id);

		// Hateoas for Getting Links
		Resource<Student> resource = new Resource<Student>(student);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllStudents());
		ControllerLinkBuilder link1=linkTo(methodOn(this.getClass()).retrieveAllSubjects(student.getId()));
		ControllerLinkBuilder link2=linkTo(methodOn(this.getClass()).retrieveOneStudentSubject(student.getId(),student.getSubjects().get(id).getId()));
		resource.add(link.withRel("all-Students"));
		resource.add(link1.withRel("All-Subjects"));
		resource.add(link2.withRel("Subject"));
		resource.add();

		// linkTo(methodOn(this.getClass()).findById());
		return resource;
	}

	// create New Student
	@PostMapping("/createStudent")
	public ResponseEntity<Object> creatStudent(
			@Valid @RequestBody Student Student) {
		Student newStudent = userService.save(Student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newStudent.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	// Delete Student
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student deleteStudent = userService.deleteById(id);
		if (deleteStudent == null)
			throw new UserNotFoundException("Student Not available:" + id);
	}

	@GetMapping("/student/{id}/subjects")
	public List<Subject> retrieveAllSubjects(@PathVariable int id) {
		return userService.getAllSubjects(id);

	}
	
	@GetMapping("/student/{id}/subjects/{sub_id}")
	public Subject retrieveOneStudentSubject(@PathVariable int id,@PathVariable int sub_id) {
		return userService.findBySubjectId(id, sub_id);

	}
	
	/*@RequestHeader("Accept-Language") Locale locale*/
	@GetMapping("/locale")
	public String internationalization(){
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		
	}
}
