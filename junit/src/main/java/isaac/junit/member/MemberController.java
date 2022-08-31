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

            join.put("id", "id_is_null");
            return join;
        }

        join = memberService.memberJoin(member);

        return join;
    }

    @GetMapping("/find")
    public JSONObject memberFind(@RequestBody Member member) throws Exception {

        JSONObject find = new JSONObject();

        if (member.getName().equals("exception")) {
            find.put("name", member.getName());
        }

        find = memberService.memberFind(member);

        return find;
    }
}
