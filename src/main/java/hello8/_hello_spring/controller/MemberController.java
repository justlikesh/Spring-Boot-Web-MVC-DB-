package hello8._hello_spring.controller;

import hello8._hello_spring.domain.Member;
import hello8._hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")                   // 주로 조회할때 슨다
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")             // 주로 데이터를 등록할때 쓴다
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("Member = " + member.getName());

        memberService.join(member);

        return "redirect:/";     // 홈화면으로
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
