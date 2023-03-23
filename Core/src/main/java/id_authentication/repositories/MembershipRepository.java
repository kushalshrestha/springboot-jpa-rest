package id_authentication.repositories;

import id_authentication.domain.Membership;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.MemberShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Modifying
    @Query(value = "update membership set member_id=:memberId where id=:id", nativeQuery = true)
    void updateMemberId(long id, long memberId);
}
