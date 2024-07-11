
package com.sparta.board.service;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 작성
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return convertToResponseDto(board);
    }

    // 게시판 전체 조회
    public List<BoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAllByOrderByCreateDateDesc();
        List<BoardResponseDto> responseDto = new ArrayList<>();
        for (Board board : boards) {
            responseDto.add(convertToResponseDto(board));
        }
        return responseDto;
    }

    // 게시글 선택 조회
    public BoardResponseDto getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return convertToResponseDto(board);
    }

    // 게시글 수정
    @Transactional
    public Long updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        if (!board.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        board.update(requestDto);
        boardRepository.save(board);
        return board.getId();
    }

    // 게시글 삭제
    @Transactional
    public Long deleteBoard(Long id, String password) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        if (!board.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        boardRepository.delete(board);
        return id;
    }

    private BoardResponseDto convertToResponseDto(Board board) {
        BoardResponseDto responseDto = new BoardResponseDto();
        responseDto.setId(board.getId());
        responseDto.setTitle(board.getTitle());
        responseDto.setUsername(board.getUsername());
        responseDto.setContents(board.getContents());
        responseDto.setCreateDate(board.getCreateDate());
        return responseDto;
    }
}
