package id_authentication.repositories;

import id_authentication.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findMemberByMemberNumber(String memberNumber);

    @Query("select m from Member m  join fetch m.memberships" )
    public Member findByIdEagerFetchMembership(@Param("memberId") Long memberId);


    @Query("select m from Member m  join fetch m.badges" )
    public Member findByIdEagerFetchBadge(@Param("memberId") Long memberId);

    @Query("select m from Member m  join fetch m.checkInRecords" )
    public Member findByIdEagerFetchCheckInRecords(@Param("memberId") Long memberId);
}
