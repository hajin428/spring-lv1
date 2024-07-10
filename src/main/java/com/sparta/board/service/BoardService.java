
package com.sparta.board.service;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    BoardResponseDto createBoard(BoardRequestDto requestDto);
    List<BoardResponseDto> getBoards();
    Long updateBoard(Long id, BoardRequestDto requestDto);
    Long deleteBoard(Long id, String password);
    BoardResponseDto getBoardById(Long id);
}

