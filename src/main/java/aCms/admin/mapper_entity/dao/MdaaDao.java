package aCms.admin.mapper_entity.dao;

import aCms.admin.mapper_entity.domain.Mdaa;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface MdaaDao extends JpaRepository<Mdaa, Long> {

    /*@Query("select a from Mdaa a join fetch a.division")*/
    @EntityGraph(attributePaths = {"division","authority"})
    List<Mdaa> findByDivisionId(Long id);

  /*  @Modifying
    @Query("delete from Mdaa c where c.id = :id")
    void deleteByDivisionId(@Param("id") Long id);*/


    @Transactional
    void deleteById(Long id);

    @Modifying
    @Query("delete from Mdaa c where c.id in :divisionId")
    void deleteDivisionId(@Param("divisionId") Long divisionId);

    /*@Modifying
    @Query("delete from Mdaa c where c.id in :divisionId")
    void deleteByDivisionId(@Param("divisionId") List<Long> divisionId);*/

    //Mdaa findByDivisionId(Long id);

/*    @Query("select m from Mdaa where m.division_id in (:arrayAAuthorityId)")
    Mdaa findInAll(String[] arrayAAuthorityId);*/
}
