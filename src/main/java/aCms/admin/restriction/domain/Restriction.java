package aCms.admin.restriction.domain;

import aCms.admin.authority.domain.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_restriction")
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restriction_id")
    private long id;

    @Column(name = "restriction_name")
    private String name;

    @Column(name = "restriction_url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id", foreignKey = @ForeignKey(name = "FK_RESTRICTION_AUTHORITY_ID"))
    private Authority authority;
}
