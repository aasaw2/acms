package aCms.admin.boardContents.contentsAnswer;

import aCms.admin.account.domain.Account;
import aCms.admin.boardContents.BoardContents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_board_content_answer")
public class ContentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contents_answer_id")
    private long id;

    @Column(name = "contents_answer_name")
    private String name;

    @Column(name = "contents_answer_comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "contents_answer_board_contents", foreignKey = @ForeignKey(name = "FK_contents_answer_board_contents"))
    private BoardContents boardContent;

    @ManyToOne
    @JoinColumn(name = "contents_answer_writer", foreignKey = @ForeignKey(name = "FK_contents_answer_writer"))
    private Account writer;

    public ContentAnswer(ContentAnswerDto.create answerDto, BoardContents boardContent, Account writer) {
        this.name = answerDto.getName();
        this.comment = answerDto.getComment();
        this.boardContent = boardContent;
        this.writer = writer;
    }

    public ContentAnswer(ContentAnswerDto.create answerDto, BoardContents boardContent) {
        this.name = answerDto.getName();
        this.comment = answerDto.getComment();
        this.boardContent = boardContent;
    }

    @Override
    public String toString() {
        return "ContentAnswer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public void update(ContentAnswerDto.create answerDto) {
        this.name = answerDto.getName();
        this.comment = answerDto.getComment();
    }
}
