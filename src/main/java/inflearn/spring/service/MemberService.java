package inflearn.spring.service;

import inflearn.spring.domain.Member;
import inflearn.spring.repository.MemeberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemeberRepository memeberRepository;

    public MemberService(MemeberRepository memeberRepository) {
        this.memeberRepository = memeberRepository;
    }

    /* 회원 가입 */
    public Long join(Member member){
        validateDuplicateMember(member);    //중복 회원 검증
        memeberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memeberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMember(){
        return memeberRepository.findAll();
    }

    /* 회원 조회 */
    public Optional<Member> findOne(Long memberId){
        return memeberRepository.findById(memberId);
    }
}
