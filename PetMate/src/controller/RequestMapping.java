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
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/", new ForwardController("/main.jsp"));	
    	mappings.put("/member/login",new LoginController());      //[succ] main, [fail] loginForm
        mappings.put("/member/registerMember", new RegisterMemberController());     //[succ] loginForm, [fail]registerFrom
        mappings.put("/main/form", new ForwardController("/main.jsp"));       
        mappings.put("/member/registerMember/form", new ForwardController("/member/registerForm.jsp"));          
        mappings.put("/member/registerSucc/form", new ForwardController("/member/loginForm.jsp"));   
        
//        mappings.put("/member/registerPet/form", new ForwardController("/member/registerPet.jsp"));		//로그인 여부 확인(펫등록)
        mappings.put("/member/registerPet/form", new CheckPetFormController());
        
        mappings.put("/member/registerPet", new RegisterPetController());	//pet 등록
        mappings.put("/member/listPet", new ListPetController());	//pet list 출력
        mappings.put("/member/myPage/form", new ForwardController("/member/myPage.jsp"));	//마이페이지 이동
        mappings.put("/member/myPage/form", new MyPageViewController());   //myPage보기
        mappings.put("/member/myPage/update/form", new UpdateMemberFormController());   //update로 가는 formController
        mappings.put("/member/myPage/update", new UpdateMemberController());   //updateController
        
        /*** 병원 ***/
        mappings.put("/member/registerHospital/form", new ForwardController("/hospital/searchHospital.jsp"));	//병원 추가
        mappings.put("/hospital/list/form", new ForwardController("/hospital/searchHospital_list.jsp")); 
        mappings.put("/hospital/HospitalList", new searchHospitalController());	//병원 검색
        
        /*** pet 수정, 삭제 ***/
        mappings.put("/member/deletePet", new DeletePetController()); //pet 삭제
        mappings.put("/member/updatePet", new UpdatePetController()); //pet 수정
        mappings.put("/member/updatePetForm", new UpdatePetFormController()); //pet 수정 화면
        
        /*** 입양***/
        mappings.put("/adopt/checkLoginAdopt", new CheckLoginAdoptFormController()); //session 확인
        mappings.put("/adopt/listAdopt", new ListAdoptController());	//입양 리스트
        mappings.put("/member/registerAdopt/form", new ForwardController("/adopt/mainAdopt.jsp"));	
        mappings.put("/adopt/addAdopt/form" , new ForwardController("/adopt/AddAdopt.jsp"));
        mappings.put("/adopt/registerAdopt", new RegisterAdoptController());
        mappings.put("/adopt/viewAdopt", new ViewAdoptController());	//입양 상세보기      
        mappings.put("/adopt/updateAdoptForm", new UpdateAdoptFormController());	//정보 업데이트 화면 연결
        mappings.put("/adopt/updateAdopt", new UpdateAdoptController());	//입양 정보 업데이트
        mappings.put("/adopt/deleteAdopt", new DeleteAdoptController());	//입양 정보 삭제
       
        mappings.put("/comment/adoptRegister", new commentAdoptController()); //입양게시판 댓글 등록
        mappings.put("/comment/adoptlist", new commentListAdoptController()); //댓글 리스트보기
        
        /***물품거래***/
        mappings.put("/transaction/checkLogin", new CheckLoginTranController()); //session 확인
        mappings.put("/transaction/registerTransaction/form", new ForwardController("/transaction/writeTransaction.jsp")); //물품거래 게시글 작성폼
        mappings.put("/member/registerSell/form", new ListTransactionController()); //물품거래 리스트보기
        mappings.put("/transaction/registerTransaction", new registerTransactionController()); //물품거래 등록 컨트롤러
        mappings.put("/transaction/view", new viewTransactionController()); //물품거래 상세보기
        mappings.put("/transaction/updateForm", new updateTransactionController()); //물품거래 수정
        mappings.put("/transaction/updateForm/form", new updateTransactionformController()); //물품거래 수정폼
        mappings.put("/transaction/delete", new deleteTransactionController()); //물품거래 삭제
        mappings.put("/transaction/view/price", new priceTransactionController()); //오름차순
        mappings.put("/transaction/view/highprice", new highpriceTransactionController()); //내림차순
        
        /***물품거래 댓글***/
        mappings.put("/comment/register", new commentController()); //댓글 등록
        mappings.put("/comment/list", new ListcommentController()); //댓글 리스트보기
        
        /*** 축제 ***/
        mappings.put("/member/registerFestival/form", new ForwardController("/festival/searchFestival.jsp"));	
        mappings.put("/festival/list/form", new ForwardController("/festival/searchFestival_list.jsp")); 
        mappings.put("/festival/FestivalList", new SearchFestivalController());	
        
        /*** 로그인, 로그아웃 ***/
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp"));   
        mappings.put("/member/logout", new LogoutController());

        logger.info("Initialized Request Mapping!");
        
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
