package com.practise.cruddemo;

import com.practise.cruddemo.dao.AppDAO;
import com.practise.cruddemo.entity.Course;
import com.practise.cruddemo.entity.Instructor;
import com.practise.cruddemo.entity.InstructorDetails;
import com.practise.cruddemo.entity.Review;
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
	public CommandLineRunner runner(AppDAO dao){
		return  runner->{

			//createCourseAndReview(dao);

			//fetchCourseAndReviewByCourseid(dao);

			deleteCourseById(dao);
		};
	}

	private void fetchCourseAndReviewByCourseid(AppDAO dao) {

		Course data=dao.fetchCourseAndReviewByCourseid(10);

		System.out.println("The Course ==> "+data);
		System.out.println("The Reviews ==> "+data.getReviews());

	}

	private void createCourseAndReview(AppDAO dao) {

		Course course=new Course("Bhaskar===> great");

		course.addReview(new Review("awseome"));
		course.addReview(new Review("awseome must read"));
		course.addReview(new Review("awseome must by read"));

		dao.save(course);

	}


	private void deleteCourseById(AppDAO dao) {
		int id=10;
		dao.deleteCourseById(id);
	}



	private void updateCourseById(AppDAO dao) {
		int id=1;
		Course theCourse=dao.findCourseById(id);
		System.out.println("The Course ===>"+theCourse);
		theCourse.setTitle("Bhaskar Test 111");

		dao.UpdateCourse(theCourse);

	}

	private void updateInstructorById(AppDAO dao) {

		int id=1;
		Instructor instructor=dao.findById(id);
		instructor.setLastname("maddy");
		instructor.setEmail("maddy@test.com");
		dao.UpdateInstructor(instructor);
	}

	private void fetchInstructorWithCourseUsingJoinFetch(AppDAO dao) {
		int id=1;
		Instructor instructor =dao.fetchInstructorWithCourseUsingJoinFetch(id);
		System.out.println("Instructor ====>"+instructor);
		System.out.println("Details ====>"+instructor.getDetails());
		System.out.println("courses ====>"+instructor.getCourses());
	}

	private void fetchCourseByInstructorId(AppDAO dao) {

		int id=1;
		Instructor instructor=dao.findById(1);

		List<Course> courses=dao.fetchCourseByInstructorId(id);
		instructor.setCourses(courses);
		System.out.println("The Instructor ==> "+instructor);
		System.out.println("The Courses ==> "+courses);
	}

	private void findInstructorByIdWithCourses(AppDAO dao) {
		int id=1;
		Instructor instructor=dao.findById(1);
		System.out.println("The instructor -->" +instructor);
		System.out.println("The associated Course is --> "+ instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO dao) {

		Instructor instructor=new Instructor("bhaskar","mudaliyar","mudaliyarbhaksar29@gmail.com");
		InstructorDetails details=new InstructorDetails("www.bhaskar.com/yputube","cricket");

		instructor.setDetails(details);

		Course tempCourse=new Course("Couser 1");
		Course tempCourse2=new Course("Couser 2");

		instructor.add(tempCourse);
		instructor.add(tempCourse2);

		System.out.println("Saving the instructor");
		dao.save(instructor);
		System.out.println("done !!");
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

		int id=1;
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
