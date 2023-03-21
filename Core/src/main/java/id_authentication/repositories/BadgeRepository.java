package id_authentication.repositories;

import id_authentication.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    // public void getBadgeByBadgeId(Long BadgeId);

   // public void deleteByBadgeId(Long badgeId);

    @Modifying
    @Query(value = "update badge set member_id=:memberId where id=:id", nativeQuery = true)
    void updateMemberId(long id, long memberId);


}
