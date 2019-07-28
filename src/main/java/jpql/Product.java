package jpql;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Product 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-27
 */
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;

    private int stockAmount;
}
