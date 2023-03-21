package id_authentication.repositories;

import id_authentication.domain.Badge;
import id_authentication.domain.Member;
import id_authentication.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findMemberByMemberNumber(String memberNumber);

    public Member findMemberByUserName(String userName);

    @Query("select b.transactions from Badge b join b.transactions where b.member.id=:memberId")
    List<Transaction> findTransactionsByMemberId(Long memberId);
}
