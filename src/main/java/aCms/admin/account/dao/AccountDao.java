package aCms.admin.account.dao;


import aCms.admin.account.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    /* @EntityGraph(attributePaths = "division")
     @Query("select a from Account a")*/
    //@Query("select a from Account a where a.email = :email")
    //@Query("select a from Account a join fetch a.division where a.email= :email")
    //@EntityGraph(attributePaths = {"mdaas","mdaas.authority"})
    //@EntityGraph(attributePaths = "division")
//    @EntityGraph(attributePaths = {"division", "authority"})


    @EntityGraph(attributePaths = "division")
    @Query("select a from Account a ")
    Account findByEmailWithDivision(String email);

    @EntityGraph(attributePaths = "division")
    @Query("select a from Account a")
    List<Account> findAllEntityGraph();

    @Query("select a from Account a join fetch a.division")
    List<Account> findAllJoinFetch();

    List<Account> findByDivisionId(@Param("id") Long id);

    @EntityGraph(attributePaths = {"division", "authority"})
    @Query("select a from Account a")
    Page<Account> findAllAccount(Pageable pageable);

    Account findByEmail(String username);

    /*@PersistenceContext
    EntityManager em;)

    public void save(Account account){
        account.setEmail("test@test.com");
        em.persist(account);
        System.out.println("email:::::"+account.getEmail());
    }*/

}
