package aCms.admin.boardContents;

import aCms.admin.account.domain.Account;
import aCms.admin.board.domain.Board;
import aCms.admin.boardContents.contentsAnswer.ContentAnswer;
import aCms.admin.boardHtml.BoardHtml;
import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "TB_board_contents")
public class BoardContents extends BaseEntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_contents_id")
    private long id;

    @Column(name = "board_contents_name")
    private String name;

    @Column(name = "board_contents_comment")
    private String comment;

    //write 생성 파일 이름 넣기
//    @Column(name = "board_contents_file_name")
//    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_contents_board", foreignKey = @ForeignKey(name = "FK_board_contents_board"))
    private Board board;

    //QnA 답변
    @OneToMany(mappedBy = "boardContent", fetch = FetchType.EAGER)
    private List<ContentAnswer> answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_contents_writer", foreignKey = @ForeignKey(name = "FK_board_contents_writer"))
    private Account writer;

    public BoardContents() {
    }

    public BoardContents(BoardContentsDto.list boardContentsDto, Board board) {
        this.name = boardContentsDto.getName();
        this.comment = boardContentsDto.getComment();
        this.board = board;
    }

    public void update(BoardContentsDto.list boardContentDto) {
        this.name = boardContentDto.getName();
        this.comment = boardContentDto.getComment();
    }
}
