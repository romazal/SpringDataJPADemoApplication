package com.romazal.jpa;

import com.github.javafaker.Faker;
import com.romazal.jpa.models.Author;
import com.romazal.jpa.models.Video;
import com.romazal.jpa.repositories.AuthorRepository;
import com.romazal.jpa.repositories.VideoRepository;
import com.romazal.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	) {
		return args -> {

			//authorRepository.updateByNamedQuery(42);

			/*authorRepository.updateAgeById(1220, 2);
			authorRepository.updateAgeById(120, 3);
			authorRepository.updateAgeById(12330, 22);
			authorRepository.updateAllAges(33);
			authorRepository.findByNamedQuery(34)
					.forEach(System.out::println);*/


			/*for(int i = 0; i < 50; i++){

				Faker faker = new Faker();

				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20, 50))
						.email(faker.internet().emailAddress())
						.build();

				authorRepository.save(author);
			}*/


			/*var video = Video.builder()
					.name("vid1")
					.length(300)
					.build();

			videoRepository.save(video);*/
			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(40))
					.or(AuthorSpecification.fistNameLike("An"));

			authorRepository.findAll(spec).forEach(System.out::println);
		};



	}
}
