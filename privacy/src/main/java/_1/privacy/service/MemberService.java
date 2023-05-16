package _1.privacy.service;

import _1.privacy.entity.Member;
import _1.privacy.repository.MemberJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public Long save(Member member) {
        return memberJpaRepository.save(member).getId();
    }

    @Transactional
    public Long update(Long id, Member member) {
        Member currentMember = findById(id);
        currentMember.update(member.getEmail(), member.getName(), member.getPassword());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Member member = findById(id);
        memberJpaRepository.delete(member);
    }

    public Member findById(Long id) {
        return memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }

    @Transactional
    public Member findByEmail(String email) {
        return (Member) memberJpaRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }
}