package aCms.admin.boardCss.domain;

import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "TB_board_css")
public class BoardCss extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "css_id")
    private long id;

    @Column(name = "css_name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
