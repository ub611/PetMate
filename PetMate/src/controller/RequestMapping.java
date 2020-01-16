package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.adopt.*;
import controller.hospital.*;
import controller.member.*;
import controller.pet.*;
import controller.transaction.*;
import controller.festival.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // �� ��û uri�� ���� controller ��ü�� ������ HashMap ����
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// �� uri�� �����Ǵ� controller ��ü�� ���� �� ����
    	mappings.put("/", new ForwardController("/main.jsp"));	
    	mappings.put("/member/login",new LoginController());      //[succ] main, [fail] loginForm
        mappings.put("/member/registerMember", new RegisterMemberController());     //[succ] loginForm, [fail]registerFrom
        mappings.put("/main/form", new ForwardController("/main.jsp"));       
        mappings.put("/member/registerMember/form", new ForwardController("/member/registerForm.jsp"));          
        mappings.put("/member/registerSucc/form", new ForwardController("/member/loginForm.jsp"));   
        
//        mappings.put("/member/registerPet/form", new ForwardController("/member/registerPet.jsp"));		//�α��� ���� Ȯ��(����)
        mappings.put("/member/registerPet/form", new CheckPetFormController());
        
        mappings.put("/member/registerPet", new RegisterPetController());	//pet ���
        mappings.put("/member/listPet", new ListPetController());	//pet list ���
        mappings.put("/member/myPage/form", new ForwardController("/member/myPage.jsp"));	//���������� �̵�
        mappings.put("/member/myPage/form", new MyPageViewController());   //myPage����
        mappings.put("/member/myPage/update/form", new UpdateMemberFormController());   //update�� ���� formController
        mappings.put("/member/myPage/update", new UpdateMemberController());   //updateController
        
        /*** ���� ***/
        mappings.put("/member/registerHospital/form", new ForwardController("/hospital/searchHospital.jsp"));	//���� �߰�
        mappings.put("/hospital/list/form", new ForwardController("/hospital/searchHospital_list.jsp")); 
        mappings.put("/hospital/HospitalList", new searchHospitalController());	//���� �˻�
        
        /*** pet ����, ���� ***/
        mappings.put("/member/deletePet", new DeletePetController()); //pet ����
        mappings.put("/member/updatePet", new UpdatePetController()); //pet ����
        mappings.put("/member/updatePetForm", new UpdatePetFormController()); //pet ���� ȭ��
        
        /*** �Ծ�***/
        mappings.put("/adopt/checkLoginAdopt", new CheckLoginAdoptFormController()); //session Ȯ��
        mappings.put("/adopt/listAdopt", new ListAdoptController());	//�Ծ� ����Ʈ
        mappings.put("/member/registerAdopt/form", new ForwardController("/adopt/mainAdopt.jsp"));	
        mappings.put("/adopt/addAdopt/form" , new ForwardController("/adopt/AddAdopt.jsp"));
        mappings.put("/adopt/registerAdopt", new RegisterAdoptController());
        mappings.put("/adopt/viewAdopt", new ViewAdoptController());	//�Ծ� �󼼺���      
        mappings.put("/adopt/updateAdoptForm", new UpdateAdoptFormController());	//���� ������Ʈ ȭ�� ����
        mappings.put("/adopt/updateAdopt", new UpdateAdoptController());	//�Ծ� ���� ������Ʈ
        mappings.put("/adopt/deleteAdopt", new DeleteAdoptController());	//�Ծ� ���� ����
       
        mappings.put("/comment/adoptRegister", new commentAdoptController()); //�Ծ�Խ��� ��� ���
        mappings.put("/comment/adoptlist", new commentListAdoptController()); //��� ����Ʈ����
        
        /***��ǰ�ŷ�***/
        mappings.put("/transaction/checkLogin", new CheckLoginTranController()); //session Ȯ��
        mappings.put("/transaction/registerTransaction/form", new ForwardController("/transaction/writeTransaction.jsp")); //��ǰ�ŷ� �Խñ� �ۼ���
        mappings.put("/member/registerSell/form", new ListTransactionController()); //��ǰ�ŷ� ����Ʈ����
        mappings.put("/transaction/registerTransaction", new registerTransactionController()); //��ǰ�ŷ� ��� ��Ʈ�ѷ�
        mappings.put("/transaction/view", new viewTransactionController()); //��ǰ�ŷ� �󼼺���
        mappings.put("/transaction/updateForm", new updateTransactionController()); //��ǰ�ŷ� ����
        mappings.put("/transaction/updateForm/form", new updateTransactionformController()); //��ǰ�ŷ� ������
        mappings.put("/transaction/delete", new deleteTransactionController()); //��ǰ�ŷ� ����
        mappings.put("/transaction/view/price", new priceTransactionController()); //��������
        mappings.put("/transaction/view/highprice", new highpriceTransactionController()); //��������
        
        /***��ǰ�ŷ� ���***/
        mappings.put("/comment/register", new commentController()); //��� ���
        mappings.put("/comment/list", new ListcommentController()); //��� ����Ʈ����
        
        /*** ���� ***/
        mappings.put("/member/registerFestival/form", new ForwardController("/festival/searchFestival.jsp"));	
        mappings.put("/festival/list/form", new ForwardController("/festival/searchFestival_list.jsp")); 
        mappings.put("/festival/FestivalList", new SearchFestivalController());	
        
        /*** �α���, �α׾ƿ� ***/
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp"));   
        mappings.put("/member/logout", new LogoutController());

        logger.info("Initialized Request Mapping!");
        
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
