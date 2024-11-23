package com.example.springBootDemo.controller;

import com.example.springBootDemo.model.Note;
import com.example.springBootDemo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

}
