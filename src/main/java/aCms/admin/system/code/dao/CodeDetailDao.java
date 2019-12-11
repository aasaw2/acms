package aCms.admin.system.code.dao;

import aCms.admin.system.code.domain.CodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeDetailDao extends JpaRepository<CodeDetail, Long> {
    List<CodeDetail> findByCodeId(long id);
}
