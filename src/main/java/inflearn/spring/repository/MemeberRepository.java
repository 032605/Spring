package inflearn.spring.repository;

import inflearn.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemeberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);   //Optional : null 처리
    List<Member> findAll();
}
