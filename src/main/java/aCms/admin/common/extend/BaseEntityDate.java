package aCms.admin.common.extend;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntityDate  {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    protected Date regDate;
    @Column(name = "reg_name")
    protected String regName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mod_date")
    protected Date modDate;

    @Column(name = "modName")
    protected String mogName;

    @Transient
    protected String cmd; // 등록 수정 상태 값
}
