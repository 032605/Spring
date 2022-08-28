package inflearn.spring.repository;

import inflearn.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRespository extends JpaRepository<Member, Long>, MemberRepository {

    // 규칙에 맞게 메소드 작성 > select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
