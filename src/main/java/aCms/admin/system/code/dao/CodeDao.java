package aCms.admin.system.code.dao;

import aCms.admin.system.code.domain.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDao extends JpaRepository<Code, Long> {
}
