package com.example.springBootDemo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {
    private Long id;
    private String title;
    private String content;

}
