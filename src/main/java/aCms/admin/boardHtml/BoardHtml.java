package aCms.admin.boardHtml;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "TB_board_html")
public class BoardHtml {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "html_id")
    private long id;

    @Column(name = "html_name")
    private String name;

    @Column(name = "html_file_name")
    private String fileName;

    public BoardHtml(String originalFilename) {
        this.fileName = originalFilename;
        now(originalFilename);
    }

    private void now(String originalFilename) {
        LocalTime currentTime = LocalTime.now();    // 컴퓨터의 현재 시간 정보. 결과 : 16:24:02.408
        this.name = originalFilename + currentTime;
    }

    public void setName(String name) {
        this.name = name;
    }
}
