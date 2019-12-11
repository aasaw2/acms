/*
 * CreateDay : 18. 11. 6 오후 5:17
 * fileName : CodeDetail.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.system.code.domain;

import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.system.code.domain.dto.CodeDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_code_detail")
public class CodeDetail extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_detail_id")
    private Long id;

    @Column(name = "code_detail_name")
    private String codeDetailName;

    @Column(name = "code_detail_use")
    private int codeDetailUse;

    @Column(name = "code_detail_order")
    private String codeDetailOrder;

    @ManyToOne
    @JoinColumn(name = "code_id", foreignKey = @ForeignKey(name = "FK_CODE_ID"))
    private Code code;


    public void create(CodeDetailDto.Create codeDetailDto, Code code) {
        this.codeDetailName = codeDetailDto.getCodeDetailName();
        this.codeDetailOrder = codeDetailDto.getCodeDetailOrder();
        this.codeDetailUse = 1;
        this.cmd = "update";
        this.code = code;
    }

    public void update(CodeDetailDto.Create codeDetailDto) {
        this.codeDetailName = codeDetailDto.getCodeDetailName();
        this.codeDetailOrder = codeDetailDto.getCodeDetailOrder();
        this.codeDetailUse = 1;
    }

    public void updateCmd() {
        this.cmd = "update";
    }
}
