package id_authentication.repositories;

import id_authentication.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long>{

    @Query(value = "select ms.* " +
            "from member m left join membership ms on m.id = ms.member_id where ms.member_id= :memberId", nativeQuery = true)
    List<Membership> findMembershipsByMemberNumber(@Param("memberId") long memberId);
}
