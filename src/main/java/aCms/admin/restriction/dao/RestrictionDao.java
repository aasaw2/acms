package aCms.admin.restriction.dao;

import aCms.admin.restriction.domain.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionDao extends JpaRepository<Restriction, Long> {
}
