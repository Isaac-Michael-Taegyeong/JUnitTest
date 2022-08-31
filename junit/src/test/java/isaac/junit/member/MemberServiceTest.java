package isaac.junit.member;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@TestMethodOrder(OrderAnnotation.class)
class MemberServiceTest {

    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    public void initTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void endTest() throws Exception {

    }

    @Test
    @Order(1)
    public void shouldReturnMemberJoinSuccess() throws Exception {
        // given
        Member member = new Member();

        //
        given(memberRepository.findById(member.getId())).willReturn(null);

        //
        Member joinMember = new Member();
        given(memberRepository.save(member)).willReturn(joinMember);

        //
        JSONObject join = new JSONObject();
        join.put(joinMember.getId(), joinMember);

        // when
        JSONObject successJoin = memberService.memberJoin(member);

        // then
        assertThat(successJoin, is(join));

    }

    @Test
    @Order(2)
    public void shouldReturnMemberJoinFailed() throws Exception {
        // given
        Member member = new Member();

        //
        Member findMember = new Member();
        given(memberRepository.findById(member.getId())).willReturn(findMember);

        //
        JSONObject join = new JSONObject();
        join.put("error", "ID already registered");

        // when
        JSONObject successJoin = memberService.memberJoin(member);

        // then
        assertThat(successJoin, is(join));

    }

}