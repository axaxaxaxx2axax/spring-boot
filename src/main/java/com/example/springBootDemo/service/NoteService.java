package com.example.springBootDemo.service;

import com.example.springBootDemo.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idCount = new AtomicLong(1);

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new NoSuchElementException("Note with Id " + id + " not found.");
        }
        return note;
    }

    public Note add(Note note) {
        long id = idCount.getAndIncrement();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(Long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with Id " + id + " not found.");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new NoSuchElementException("Note with Id " + note.getId() + " not found.");
        }
        notes.put(note.getId(), note);
    }

}
