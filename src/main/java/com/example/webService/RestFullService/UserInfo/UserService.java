package com.example.webService.RestFullService.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	static List<Student> students = new ArrayList<>();

	static List<Subject> subjects = new ArrayList<>();

	static int studentCount = 3;

	static {
		subjects.add(new Subject(1, "Maths", "REGA", new Date(), "100"));
		subjects.add(new Subject(2, "PHY", "Rav", new Date(), "100"));
		subjects.add(new Subject(3, "BIO", "RP Redy", new Date(), "100"));
		subjects.add(new Subject(4, "TEL", "NB Rao", new Date(), "100"));
		subjects.add(new Subject(5, "HINDI", "YS Yur", new Date(), "100"));
		students.add(new Student(1, "Ravinder", new Date(), "1000", subjects));
		students.add(new Student(2, "Raju", new Date(), "2000", subjects));
		students.add(new Student(3, "Ramu", new Date(), "3000", subjects));
		students.add(new Student(4, "Ramba", new Date(), "5000", subjects));
		students.add(new Student(5, "YUKU", new Date(), "7000", subjects));
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			student.setId(++studentCount);
		}
		students.add(student);
		return student;
	}

	public List<Student> getAllstudents() {
		return students;
	}

	public Student findById(int id) {
		for (Student student : students) {
			if (student.getId() == id)
				return student;
		}
		return null;
	}

	public Student deleteById(int id) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == id) {
				iterator.remove();
				return student;
			}

		}
		return null;
	}
	
	public Subject saveSubject(Subject subject){
		return subject;
		
	}
	
	public List<Subject> getAllSubjects(int studentId){
		return students.get(studentId).getSubjects();
	}
	
	public Subject findBySubjectId(int studentId,int subjectid){
		Student student=students.get(studentId);
		return student.getSubjects().get(subjectid);
	}
	
	public Subject deleteBySubjectId(){
		return null;
	}
	
	public List<Student> findBySubjectName(String name){
		return null;
	}
}
