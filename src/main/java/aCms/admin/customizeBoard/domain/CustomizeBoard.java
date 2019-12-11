package aCms.admin.customizeBoard.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CustomizeBoard {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long Id;

    @Column(name = "board_name")
    private String name;

    @Column(name = "board_css")
    private String css;

    @Column(name = "board_html")
    private String html;

    @Column(name = "board_js")
    private String js;

    public CustomizeBoard(String dirName) {
        this.name = dirName;
        this.css = dirName + ".css";
        this.html = dirName + ".jsp";
        this.js = dirName + ".js";
    }

}
