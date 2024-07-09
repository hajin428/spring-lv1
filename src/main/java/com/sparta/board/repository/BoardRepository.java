package com.sparta.board.repository;

import com.sparta.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreateDateDesc();
}


//package com.sparta.board.repository;
//
//import com.sparta.board.entity.Board;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface BoardRepository extends JpaRepository<Board, Long> {
//
//    List<Board> findAllByOrderByCreateDateDesc();
//
//    Optional<Board> findById(Long id);
//
//    void save(Board board);
//
//    void delete(Board board);
//}


