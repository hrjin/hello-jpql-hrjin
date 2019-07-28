package jpql;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * 임베디드 타입 객체 Address 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-27
 */
@Data
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipCode;
}
