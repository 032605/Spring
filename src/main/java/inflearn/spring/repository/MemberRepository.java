package inflearn.spring.repository;

import inflearn.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);   //Optional : null 처리
    List<Member> findAll();
}
