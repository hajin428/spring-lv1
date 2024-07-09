package com.sparta.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private LocalDate createDate;
}
