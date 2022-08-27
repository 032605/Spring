package inflearn.spring;

import inflearn.spring.repository.MemberRepository;
import inflearn.spring.repository.MemoryMemberRepository;
import inflearn.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //new 키워드 뒤에 인터페이스 구현 클래스
        return new MemoryMemberRepository();
    }
}
