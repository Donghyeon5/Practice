package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member(); // 새로운 맴버
        member.setName("spring"); // 이름은 spring
        repository.save(member); // MemberRepository 의 객체인 repository 에 저장
        Member result = repository.findById(member.getId()).get(); // optional 에서 값을 꺼내기

        System.out.println("result =" + (result == member));

        // Assertions.assertEquals(result, member); // result 와 멤버 값이 같은지 비교
        Assertions.assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); // spring1 회원 가입 완료

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);     // spring2 회원 가입 완료

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); // spring1 회원 가입 완료

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);     // spring2 회원 가입 완료

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
