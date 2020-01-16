package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.*;
import model.dao.*;
import model.service.*;

public class RegisterMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);
   private MemberDAO memberDAO = new MemberDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       MemberDTO member = new MemberDTO(
         request.getParameter("userId"),
         request.getParameter("pwd"),
         request.getParameter("name"),
         request.getParameter("region"));
      
        log.debug("Create Member : {}", member);

      try {
         //MemberManager manager = MemberManager.getInstance();
         //manager.create(Member);
         
         if (memberDAO.existingMember(member.getUserID()) == true) {
            System.out.println("memberDAO.existing error");
            throw new ExistingMemberException(member.getUserID() + "는 존재하는 아이디입니다.");
         }
         memberDAO.create(member);
         return "redirect:/member/registerSucc/form";      // 성공 시 회원가입한 내용 보여주는곳으로 redirect작성 필요
         
         
      } catch (ExistingMemberException e) {      // 예외 발생 시 회원가입 form으로 forwarding, Exeption은 model.Service에 새로 정의 필요
         request.setAttribute("registerFailed", true);
         request.setAttribute("exception", e);
         request.setAttribute("member", member);
         return "/member/registerForm.jsp";
      }
    }
}