package id_authentication.repositories;

import id_authentication.domain.Badge;
import id_authentication.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

    @Query(value = "select b.* from badge b where b.member_id= :memberId", nativeQuery = true)
    List<Badge> findBadgesByMemberId(long memberId);

    @Query(value = "select b.* from badge b where b.member_id= :memberId and UPPER(status) = UPPER(:status)", nativeQuery = true)
    List<Membership> findMemberBadgesByStatus(@Param("memberId") long memberId, @Param("status") String status);
}
