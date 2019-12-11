package aCms.admin.board.dao;

import aCms.admin.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDao extends JpaRepository<Board, Long> {


//    @Query("select a from Board a join fetch a.division")
    Page<Board> findByDivisionId(Pageable pageable, Long id);

    List<Board> findByDivisionId(Long id);
    Board findByContentsId(long id);
}
