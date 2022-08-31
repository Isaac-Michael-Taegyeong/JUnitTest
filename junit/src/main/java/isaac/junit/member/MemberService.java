package isaac.junit.member;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public JSONObject memberJoin(Member member) {

        JSONObject join = new JSONObject();

        Member findMember = memberRepository.findById(member.getId());
        if (findMember != null) {

            join.put("error", "ID already registered");
            return join;
        }

        Member joinMember = memberRepository.save(member);
        join.put(joinMember.getId(), joinMember);

        return join;
    }

    public JSONObject memberFind(Member member) {

        JSONObject find = new JSONObject();

        Member findMember = memberRepository.findById(member.getId());
        if (findMember == null) {

            find.put("error", "member not found");
            return find;
        }

        find.put(findMember.getId(), findMember);

        return find;
    }

}
