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

//	@Bean
//	public CommandLineRunner demo(NoteService noteService) {
//		return args -> {
//			Note note1 = new Note();
//			note1.setTitle("Work");
//			note1.setContent("work");
//			Note addNote = noteService.add(note1);
//
//			Note note2 = new Note();
//			note2.setTitle("Study");
//			note2.setContent("study");
//			Note addNote2 = noteService.add(note2);
//
//			System.out.println("List: ");
//			noteService.listAll().forEach(System.out::println);
//
//		};
//	}

}
