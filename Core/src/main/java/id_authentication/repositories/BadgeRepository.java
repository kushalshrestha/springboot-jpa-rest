package id_authentication.repositories;

import id_authentication.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

    @Query(value = "select b.* from badge b where b.member_id= :memberId", nativeQuery = true)
    List<Badge> findBadgesByMemberId(long memberId);
}
