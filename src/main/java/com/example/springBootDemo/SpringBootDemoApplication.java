package com.example.springBootDemo;

import com.example.springBootDemo.model.Note;
import com.example.springBootDemo.service.NoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(NoteService noteService) {
		return args -> {
			Note firstNote = new Note();
			firstNote.setTitle("First note");
			firstNote.setContent("Lalalala");
			Note addedFirstNote = noteService.add(firstNote);
			System.out.println("Added note: " + addedFirstNote);

			System.out.println("List: ");
			noteService.listAll().forEach(System.out::println);

			try {
				Note noteById = noteService.getById(addedFirstNote.getId());
				System.out.println("Found note: " + noteById);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			Note noteToUpdate = new Note(addedFirstNote.getId(), "Updated note", "Updated content");
			noteService.update(noteToUpdate);
			System.out.println("Updated note: " + noteService.getById(noteToUpdate.getId()));

			noteService.deleteById(addedFirstNote.getId());
			System.out.println("Deleted");
			noteService.listAll().forEach(System.out::println);
		};
	}

}
