package id_authentication.repositories;

import id_authentication.domain.Membership;
import id_authentication.dto.MemberShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query(value = "select ms.* " +
            "from member m left join membership ms on m.id = ms.member_id where ms.member_id= :memberId", nativeQuery = true)
    List<Membership> findMembershipsByMemberId(@Param("memberId") long memberId);

    @Modifying
    @Query(value = "update membership set member_id=:memberId where id=:id", nativeQuery = true)
    void updateMemberId(long id, long memberId);
}
