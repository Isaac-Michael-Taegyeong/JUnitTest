package isaac.junit.member;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberControllerTest {

    private MemberController memberController;

    @Mock
    private MemberService memberService;

    @BeforeEach
    public void initTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        memberController = new MemberController(memberService);
    }

    @AfterEach
    public void endTest() throws Exception {

    }

    @Test
    @Order(1)
    public void 회원가입성공() throws Exception {
        // given
        Member member = new Member();
        member.setId(1L);

        JSONObject join = new JSONObject();
        given(memberService.memberJoin(member)).willReturn(join);

        // when
        JSONObject joinMember = memberController.memberJoin(member);

        // then
        assertThat(joinMember, is(join));
    }

    @Test
    @Order(2)
    public void 회원가입실패() throws Exception {
        // given
        Member member = new Member();
        JSONObject join = new JSONObject();
        join.put("id", "id_is_null");

        // when
        JSONObject joinMember = memberController.memberJoin(member);

        // then
        assertThat(joinMember, is(join));

    }

}