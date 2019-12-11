package aCms.admin.authority.dao;


import aCms.admin.authority.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorityDao extends JpaRepository<Authority, Long> {
    Authority findByName(@Param("name") String name);


//    @Query("select a from Authority a join fetch ")
//    Authority findAuthorityWithRestriction(Long id);
}
