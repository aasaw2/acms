package aCms.admin.board.domain;

import aCms.admin.account.domain.Account;
import aCms.admin.boardContents.BoardContents;
import aCms.admin.boardCss.domain.BoardCss;
import aCms.admin.boardHtml.BoardHtml;
import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.division.domain.Division;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TB_board")
public class Board extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_css", foreignKey = @ForeignKey(name = "FK_board_css"))
    private BoardCss css;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_html", foreignKey = @ForeignKey(name = "FK_board_html"))
    private BoardHtml html;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_writer", foreignKey = @ForeignKey(name ="FK_board_writer"))
    private Account writer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_division", foreignKey = @ForeignKey(name = "FK_board_division"))
    private Division division;

    @OneToMany(mappedBy = "board")
    private List<BoardContents> contents;

    @Column(name = "board_js")
    private String js;

    public Board(String dirName) {
        this.name = dirName;
        this.js = dirName + ".js";
    }

    public Board(BoardDto.create boardDto, Account account, BoardHtml boardHtml) {
        this.name = boardDto.getName();
        this.writer = account;
        this.html = boardHtml;
        this.division = account.getDivision();
    }

    public void update(BoardDto.create boardDto, Account account, BoardHtml boardHtml) {
        this.name = boardDto.getName();
        this.writer = account;
        this.html = boardHtml;
    }
}
