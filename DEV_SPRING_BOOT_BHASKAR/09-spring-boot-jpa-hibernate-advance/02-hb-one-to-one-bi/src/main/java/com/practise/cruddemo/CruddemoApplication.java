package com.practise.cruddemo;

import com.practise.cruddemo.dao.AppDAO;
import com.practise.cruddemo.entity.Instructor;
import com.practise.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AppDAO dao){
		return  runner->{
			//createInstructor(dao);
			//findInstructorById(dao);
			//deleteInstructor(dao);
			//findInstructorDetailById(dao);
			deleteInstructorDetailById(dao);
		};
	}

	private void deleteInstructorDetailById(AppDAO dao) {
		dao.deleteInstructorDetailById(1);
		System.out.println("Deleting done !!");
	}

	private void findInstructorDetailById(AppDAO dao) {
		int id=1;
		InstructorDetails details=dao.instructorDetailById(id);
		System.out.println("Details" + details);
		System.out.println("Instructor" + details.getInstructor());
	}

	private void deleteInstructor(AppDAO dao) {

		int id=3;
		dao.delete(id);
		System.out.println("Done !!");
	}

	private void findInstructorById(AppDAO dao) {

		int id=3;
		Instructor instructor=dao.findById(3);
		System.out.println("Instructor" + instructor);
		System.out.println("Instructor" + instructor.getDetails());
	}

	private void createInstructor(AppDAO dao) {

		Instructor instructor=new Instructor("bhaskar","mudaliyar","mudaliyarbhaksar29@gmail.com");
		InstructorDetails details=new InstructorDetails("www.bhaskar.com/yputube","cricket");

		instructor.setDetails(details);
		System.out.println("Saving the instructor");
		dao.save(instructor);
		System.out.println("done !!");
	}

}
