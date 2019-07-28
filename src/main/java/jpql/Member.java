package jpql;

import lombok.Data;

import javax.persistence.*;

/**
 * Member 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-27
 */
@Data
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String username;

    private int age;
}
