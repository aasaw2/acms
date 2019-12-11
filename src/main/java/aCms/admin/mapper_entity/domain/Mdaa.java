/*
 * CreateDay : 18. 10. 18 오후 6:00
 * fileName : Mdaa.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.mapper_entity.domain;

import aCms.admin.authority.domain.Authority;
import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.division.domain.Division;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_mdaa")
@NoArgsConstructor
@Getter
@Setter
public class Mdaa extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mdaa_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "division_id", foreignKey = @ForeignKey(name = "FK_MDAA_Division"))
    private Division division;

    @ManyToOne
    @JoinColumn(name = "authority_id", foreignKey = @ForeignKey(name = "FK_MDAA_Authority"))
    private Authority authority;

    @Builder
    public Mdaa(Division division, Authority authority) {
        this.division = division;
        this.authority = authority;
    }

    public void updateDivision(Division division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Mdaa{" +
                "id=" + id +
               ", divisionId=" + division.getId() +
                ", authority=" + authority.getId() +
                //", authority=" + authority.getAuthorityCode() +
                //", authority=" + authority.getAuthorityName() +
                '}';
    }
}
