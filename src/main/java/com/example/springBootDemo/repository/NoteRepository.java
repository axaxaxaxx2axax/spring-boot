package com.example.springBootDemo.repository;

import com.example.springBootDemo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
