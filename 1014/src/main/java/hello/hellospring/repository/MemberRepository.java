package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save , 회원을 저장 하면 저장된 회원이 반환

    Optional<Member> findById(Long id); // id로 회원 찾기
    Optional<Member> findByName(String name); // 이름 으로 회원 찾기
    List<Member> findAll(); // 모든 회원 반환
}
