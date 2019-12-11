/*
 * CreateDay : 18. 10. 17 오후 7:13
 * fileName : Division.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */
package aCms.admin.division.Dao;

import aCms.admin.division.domain.Division;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DivisionDao extends JpaRepository<Division, Long> {
    //@EntityGraph(attributePaths = "mdaas")
    Division findById(Long id);

    @EntityGraph(attributePaths = {"mdaas", "account"})
    @Query("select a from Division a")
    List<Division> findAllDivision();

  /*  @Query("select d from Division d join fetch d.mdaas")
    List<Division> findByIdWithMdaa(Long id);*/


}


