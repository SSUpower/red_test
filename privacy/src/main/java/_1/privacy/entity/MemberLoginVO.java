package _1.privacy.entity;
import _1.privacy.entity.Member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class MemberLoginVO {
    public MemberLoginVO() {

    }

    public MemberLoginVO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    private String email;

    private String password;
}
