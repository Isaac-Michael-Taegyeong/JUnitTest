package isaac.junit.member;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public JSONObject memberJoin(@RequestBody Member member) {
        log.info("memberJoin() : " + member.getId() + ", " + member.getName());

        JSONObject join = new JSONObject();

        if (member.getId() == null) {

            join.put("error", "ID is null");
            return join;
        }

        join = memberService.memberJoin(member);

        return join;
    }

    @GetMapping("/find")
    public JSONObject memberFind(@RequestBody Member member) {
        log.info("memberFind() : " + member.getId() + ", " + member.getName());

        JSONObject find = new JSONObject();

        if (member.getId() == null) {

            find.put("error", "ID is null");
            return find;
        }

        find = memberService.memberFind(member);

        return find;
    }
}
