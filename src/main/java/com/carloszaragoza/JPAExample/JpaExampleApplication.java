package com.carloszaragoza.JPAExample;

import com.carloszaragoza.JPAExample.model.*;
import com.carloszaragoza.JPAExample.repository.StudentIdCardRepository;
import com.carloszaragoza.JPAExample.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository studentRepository,
			StudentIdCardRepository studentIdCardRepository){
		return args -> {
			String firstName = "Carlos";
			String lastName = "Zaragoza";
			String email = "carloszaragoza@gmail.es";
			int age = 23;
			Student student = new Student(
					firstName,
					lastName,
					email,
					age);
			student.addBook(
					new Book("Book1", LocalDateTime.now().minusDays(2)));


			student.addBook(
					new Book("Book2", LocalDateTime.now().minusYears(1)));

			StudentIdCard studentIdCard = new StudentIdCard(
					"123456789",
					student);

			student.setStudentIdCard(studentIdCard);

			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 1L),
					student,
					new Course("Computer Science", "IT"),
					LocalDateTime.now()
			));
			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 2L),
					student,
					new Course("Amigoscode Spring Data JPA", "IT"),
					LocalDateTime.now().minusDays(18)
			));

			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 2L),
					student,
					new Course("Amigoscode Spring Data JPA", "IT"),
					LocalDateTime.now().minusDays(18)
			));

			studentRepository.save(student);

			studentRepository.findById(1L)
					.ifPresent(s -> {
						List<Book> books = student.getBooks();
						books.forEach(book -> {
							System.out.println(
									s.getFirstName() + " Pidio Prestado " + book.getBookName());
						});
					});

		};
	}


}
