package jpql;

import lombok.Data;

import javax.persistence.*;

/**
 * Order 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-27
 */
@Data
@Entity
@Table(name = "Orders") // Order 는 예약어이므로 관례상 Orders 로 테이블 이름 지정.
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    private Address address;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
