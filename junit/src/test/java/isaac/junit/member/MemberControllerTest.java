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
    public void shouldReturnMemberJoinSuccess() throws Exception {
        // given
        Member member = new Member();
        member.setId(1L);

        //
        JSONObject join = new JSONObject();
        given(memberService.memberJoin(member)).willReturn(join);

        // when
        JSONObject successJoin = memberController.memberJoin(member);

        // then
        assertThat(successJoin, is(join));

    }

    @Test
    @Order(2)
    public void shouldReturnMemberJoinFailed() throws Exception {
        // given
        Member member = new Member();

        //
        JSONObject join = new JSONObject();
        join.put("error", "ID is null");

        // when
        JSONObject failedJoin = memberController.memberJoin(member);

        // then
        assertThat(failedJoin, is(join));

    }

    @Test
    @Order(3)
    public void shouldReturnMemberFindSuccess() throws Exception {
        // given
        Member member = new Member();
        member.setId(1L);

        //
        JSONObject find = new JSONObject();
        given(memberService.memberFind(member)).willReturn(find);

        // when
        JSONObject successFind = memberController.memberFind(member);

        // then
        assertThat(successFind, is(find));

    }

    @Test
    @Order(4)
    public void shouldReturnMemberFindFailed() throws Exception {
        // given
        Member member = new Member();

        //
        JSONObject find = new JSONObject();
        find.put("error", "ID is null");

        // when
        JSONObject failedFind = memberController.memberJoin(member);

        // then
        assertThat(failedFind, is(find));

    }

}