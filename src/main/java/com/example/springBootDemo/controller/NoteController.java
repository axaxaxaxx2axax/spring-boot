package com.example.springBootDemo.controller;

import com.example.springBootDemo.model.Note;
import com.example.springBootDemo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("action", "notesList");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id) {
        try {
            noteService.deleteById(id);
            return new ModelAndView(new RedirectView("/note/list", true))
                    .addObject("successMessage", "Note deleted");
        } catch (NoSuchElementException e) {
            return new ModelAndView("list")
                    .addObject("errorMessage", "Not found");
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        try {
            Note note = noteService.getById(id);
            modelAndView.addObject("note", note);
            return modelAndView;
        } catch (NoSuchElementException e) {
            return new ModelAndView("list")
                    .addObject("errorMessage", "Note not found");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("note") Note note) {
        noteService.update(note.getId(), note);
        return new ModelAndView(new RedirectView("/note/list", true))
                .addObject("successMessage", "Note updated successfully");
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return new ModelAndView(new RedirectView("/note/list", true))
                .addObject("successMessage", "Note added successfully");
    }

}
