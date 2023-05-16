package _1.privacy.controller;

import _1.privacy.entity.Member;
import _1.privacy.entity.MemberLoginVO;
import _1.privacy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public Long login(@RequestBody MemberLoginVO memberLoginVO) {
        String email = memberLoginVO.getEmail();
        String password = memberLoginVO.getPassword();

        Member member = memberService.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            // 로그인 성공
            return member.getId();
        } else {
            // 로그인 실패
            return null;
        }
}


    @PostMapping("/join")
    public Long create(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping("/member/{id}")
    public Member read(@PathVariable Long id) {

        return memberService.findById(id);
    }

    @PostMapping("/user/{id}/update")
    public Long update(@PathVariable Long id, @RequestBody Member member) {
        return memberService.update(id, member);
    }

    @PostMapping("/user/{id}/delete")
    public Long delete(@PathVariable Long id) {
        memberService.delete(id);
        return id;
    }
}
