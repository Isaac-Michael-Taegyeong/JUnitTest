package isaac.junit.member;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public JSONObject memberJoin(@RequestBody Member member) {

        JSONObject join = new JSONObject();

        if (member.getId() == null) {

            join.put("error", "ID is null");
            return join;
        }

        join = memberService.memberJoin(member);

        return join;
    }

    @GetMapping("/find")
    public JSONObject memberFind(@RequestBody Member member) throws Exception {

        JSONObject find = new JSONObject();

        if (member.getId() == null) {
            find.put("error", "ID is null");
        }

        find = memberService.memberFind(member);

        return find;
    }
}
