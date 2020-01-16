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


public class MyPageViewController implements Controller {
   private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);
      
   @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String curUserId = UserSessionUtils.getUserFromSession(request.getSession());    //현재 접속한 user_id
   
      MemberDTO memdto = new MemberDTO();
   
        log.debug("View Mypage Member : {}", memdto);

        if (!UserSessionUtils.isLogined(request.getSession())) {
            request.setAttribute("NotLogin", true);
             request.setAttribute("msg", "로그인 후 이용해주세요!");
            return "/member/registerSucc/form";
         }
        
         MemberManager manager = MemberManager.getInstance();
         memdto = manager.findUser(curUserId);
         
         System.out.println(curUserId);
         
         if(memdto != null) {
            request.setAttribute("memberDTO", memdto);                             
            return "/member/myPage.jsp";     
         }
         else
            return "/main/form";
         
       }

}