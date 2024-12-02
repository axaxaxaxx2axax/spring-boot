package com.example.springBootDemo.service;

import com.example.springBootDemo.model.Note;
import com.example.springBootDemo.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note getById(Integer id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Note with Id " + id + " not found."));
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Integer id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException("Note with Id " + id + " does not exist.");
        }
        noteRepository.deleteById(id);
    }

    public Note update(Integer id, Note updateNote) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Note with id " + id + " not found."));

        existingNote.setTitle(updateNote.getTitle());
        existingNote.setContent(updateNote.getContent());
        return noteRepository.save(existingNote);
    }
}
