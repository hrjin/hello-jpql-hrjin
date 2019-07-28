package jpql;

import javax.persistence.*;
import java.util.List;

/**
 * JPQL Main Class
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-27
 */
public class JpqlMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpql");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("hrjin");
            member.setAge(20);
            em.persist(member);

            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);

            Query query2 = em.createQuery("select m.username, m.age from Member m");

            // getResultList() : 결과가 없으면 빈 리스트 반환
            // 참고 >> getSingleResult() : 결과가 여러개거나 아예 없으면 둘다 Exception 남.
            // Spring data jpa 에서는 값 없으면 Exception 안 나고 null 이나 Optional 을 반환하도록 돼있음.
            // 소스 들어가보면 표준 스펙에 try-catch 해놓은 것...
            List<Member> members = query1.getResultList();
            for (Member member1 : members) {
                System.out.println("member1 = " + member1);
            }

//            TypedQuery<Member> query3 = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query3.setParameter("username", "hrjin");
//            Member memberOne = query3.getSingleResult();
//            System.out.println("single result = " + memberOne.getUsername());

            Member memberOne = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "hrjin")
                    .getSingleResult();
            System.out.println("single result = " + memberOne.getUsername());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
