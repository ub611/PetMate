package controller.adopt;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.RegisterMemberController;
import controller.member.UserSessionUtils;
import model.*;
import model.dao.*;
import model.service.*;

public class RegisterAdoptController implements Controller{
   private static final Logger log = LoggerFactory.getLogger(RegisterAdoptController.class);
   private AdoptDAO adoptDAO = new AdoptDAO();
   
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String curUserId = UserSessionUtils.getUserFromSession(request.getSession());    //���� ������ user_id
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Calendar cal = Calendar.getInstance();
       String today = sdf.format(cal.getTime());
  
       AdoptDTO adopt = new AdoptDTO(
            curUserId,
            1,
            Integer.parseInt(request.getParameter("adopt_price")),
            Integer.parseInt(request.getParameter("adopt_age")),
            request.getParameter("adopt_kind"),
            request.getParameter("adopt_gender"),
            0,
            today);
         
       
           log.debug("Create Adopt : {}", adopt);
          
            adoptDAO.create(adopt);
            request.setAttribute("kind", request.getParameter("adopt_kind"));
            
            return "/adopt/listAdopt";      // ���� �� �Ծ�/�о� ����Ʈ ȭ������ redirect
    }          //list page!!!
}
