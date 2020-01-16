package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MemberManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String userId = request.getParameter("userID");
      String password = request.getParameter("pwd");
      
      try {
         // �𵨿� �α��� ó���� ����
         MemberManager manager = MemberManager.getInstance();
         manager.login(userId, password);
   
         // ���ǿ� ����� ���̵� ����
         HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
            
            return "redirect:/main/form";         
      } catch (Exception e) {
         /* UserNotFoundException�̳� PasswordMismatchException �߻� ��
          * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
          */
         request.setAttribute("loginFailed", true);
         request.setAttribute("exception", e);
         
         return "/member/loginForm.jsp";         
      }   
      
        /*UserDao userDao = new UserDao();
        User user = userDao.findByUserId(userId);
        if (user == null) {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }
        if (user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            return "redirect:/";
        } else {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }*/
    }
}