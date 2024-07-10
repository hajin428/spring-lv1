package com.sparta.board.controller;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시글 작성
    @PostMapping
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    //게시글 전체 조회
    @GetMapping
    public List<BoardResponseDto> findAll() {
        return boardService.getBoards();
    }

    //게시글 선택 조회
    @GetMapping("/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    //게시글 수정
    @PutMapping("/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }

    //삭제
    @DeleteMapping("/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestParam String password) {
        return boardService.deleteBoard(id, password);
    }
}
