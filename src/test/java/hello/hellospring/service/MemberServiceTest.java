package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void validateDuplicateMember() {

    }

    @Test
    void 회원가입() {
        // given (주어진 것)
        Member member = new Member();
        member.setName("test1");

        // when (이걸 실행했을 때)
        Long saveId = memberService.join(member);

        // then (결과가 이게 나와야해)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("test1");

        Member member2 = new Member();
        member1.setName("test1");

        // when
        memberService.join(member1);
        // IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // 이미 존재하는 회원 예외처리


        // then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}