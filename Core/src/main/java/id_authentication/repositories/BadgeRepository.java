package id_authentication.repositories;

import id_authentication.domain.Badge;
import id_authentication.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    // public void getBadgeByBadgeId(Long BadgeId);

   // public void deleteByBadgeId(Long badgeId);

    @Query("Select b from Badge b")
    public List<Badge> findBadges();
    @Modifying
    @Query(value = "update badge set member_id=:memberId where id=:id", nativeQuery = true)
    void updateMemberId(long id, long memberId);

    @Query(value = "select b.* from badge b where b.member_id= :memberId", nativeQuery = true)
    List<Badge> findBadgesByMemberId(long memberId);

    @Query(value = "select b.* from badge b where b.member_id= :memberId and UPPER(status) = UPPER(:status)", nativeQuery = true)
    List<Badge> findMemberBadgesByStatus(@Param("memberId") long memberId, @Param("status") String status);

}
