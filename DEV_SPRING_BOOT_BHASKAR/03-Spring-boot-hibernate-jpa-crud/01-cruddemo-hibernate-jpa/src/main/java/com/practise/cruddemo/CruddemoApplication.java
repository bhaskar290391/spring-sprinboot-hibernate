package com.practise.cruddemo;

import com.practise.cruddemo.dao.StudentDao;
import com.practise.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner(StudentDao studentDao){
		return  runner ->{
			//createStudent(studentDao);

			createMultipleStudent(studentDao);

			//readStudentById(studentDao);

			//readAllStundents(studentDao);

			//readByLastName(studentDao);

			//updateStudnetData(studentDao);

			//deleteStudent(studentDao);

			//deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		studentDao.deleteAllStudent();
	}

	private void deleteStudent(StudentDao studentDao) {
		Student student=studentDao.readStudent(2);
		studentDao.deleteStudentById(student);
	}

	private void updateStudnetData(StudentDao studentDao) {
		Student student=studentDao.readStudent(2);
		student.setFirstName("kanishk");
		studentDao.updateStudent(student);
	}

	private void readByLastName(StudentDao studentDao) {
		List<Student> students = studentDao.readStudentByLastName("Mudaliyar2");

		for (Student theStudnet:
				students) {
			System.out.println("The student are --->"+theStudnet);
		}
	}



	private void readAllStundents(StudentDao studentDao) {

		List<Student> students = studentDao.readAllStudents();

		for (Student theStudnet:
			 students) {
			System.out.println("The student are --->"+theStudnet);
		}
	}




	private void readStudentById(StudentDao studentDao) {

		Student theStudent=studentDao.readStudent(2);

		System.out.println("The Student with Id :2 is -->"+theStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		Student s=new Student("Bhaskar","Mudaliyar","bhaskar@test.com");
		Student s1=new Student("Bhaskar1","Mudaliyar1","bhaskar1@test.com");
		Student s2=new Student("Bhaskar2","Mudaliyar2","bhaskar2@test.com");

		studentDao.saveStudent(s);
		studentDao.saveStudent(s1);
		studentDao.saveStudent(s2);

	}

	private void createStudent(StudentDao studentDao) {

		Student s=new Student("Bhaskar","Mudaliyar","bhaskar@test.com");

		studentDao.saveStudent(s);

		System.out.println("Student is save with Id "+s.getId());
	}
}
