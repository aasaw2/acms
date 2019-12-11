package aCms.admin.boardContents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardContentsDao extends JpaRepository<BoardContents, Long> {

    Page<BoardContents> findByBoardId(long id, Pageable pageable);
    List<BoardContents> findByBoardId(long id);
}
