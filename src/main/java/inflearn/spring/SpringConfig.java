package inflearn.spring;

import inflearn.spring.repository.JdbcMemberRepostiory;
import inflearn.spring.repository.JdbcTemplateMemberRepository;
import inflearn.spring.repository.MemberRepository;
import inflearn.spring.repository.MemoryMemberRepository;
import inflearn.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //new 키워드 뒤에 인터페이스 구현 클래스
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepostiory(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
