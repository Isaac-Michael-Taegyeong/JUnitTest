package isaac.junit.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    private Map<Long, Member> storage = new HashMap<>();

    public Member save(Member member) {

        storage.put(member.getId(), member);

        return storage.get(member.getId());
    }

    public Member findById(Long memberId) {
        return storage.get(memberId);
    }

}
