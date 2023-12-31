package com.example.helloservlet.web.springmvc.v3;

import com.example.helloservlet.domain.member.Member;
import com.example.helloservlet.domain.member.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 아래 두 표현은 같은 표현, 후자가 더 업그레이드된 버전
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("new-form")
    public String newForm() {
        return "new-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("username") String username, @RequestParam("age") int age,
        Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}