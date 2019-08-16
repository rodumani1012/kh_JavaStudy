package com.toy.home.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.toy.home.biz.login_biz;
import com.toy.home.biz.login_bizimpl;
import com.toy.home.dto.user_info_dto;
import com.toy.home.email.SendEmailPassword;
import com.toy.home.email.find_id_email;
import com.toy.home.email.find_pw_email;
import com.toy.project.email.send_email_link;

@WebServlet("/login_controller")
public class login_controller extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static String ranpass = "";

   public login_controller() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");

      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");

      String command = request.getParameter("command");
      System.out.println("[command : "+command+"]");

      login_biz biz = new login_bizimpl();
      PrintWriter out = response.getWriter();

      if (command.equals("login_chk")) {

         user_info_dto dto = biz.login_chk(request.getParameter("id"), request.getParameter("pw"));
         
         if (dto != null){
            request.getSession().setMaxInactiveInterval(60*60);
            request.getSession().setAttribute("user_info_dto", dto);

            if (dto.getUser_grade().equals("ADMIN")) { // 관리자 페이지로(※ 미구현)
               dispatch(request, response, "home.jsp"); 
            } else if (dto.getUser_grade().equals("USER")) { // 유저 페이지로
               dispatch(request, response, "home.jsp"); 
            }
         } else {
            jsResponse("아이디 또는 비밀번호가 틀렸습니다.", "home/member/member_login.jsp", response);
         }

      }else if(command.equals("send_email")) {
         String useremail = request.getParameter("email");
         ranpass = SendEmailPassword.getRandomPassword();
         System.out.println(ranpass);
         SendEmailPassword.sendPassward(useremail, ranpass);
         
         response.getWriter().write(ranpass);
      }else if(command.equals("complete")) {
         String name = request.getParameter("name");
         String id = request.getParameter("id");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         
         System.out.println(name+" "+id+" "+password+" "+email);
      }else if(command.equals("regist")) {
         String name = request.getParameter("name");
         String id = request.getParameter("id");
         String password = request.getParameter("password");
         String nickname = request.getParameter("nickname");
         String email = request.getParameter("email");
            
         user_info_dto dto = new user_info_dto();
         dto.setUser_name(name);
         dto.setUser_id(id);
         dto.setUser_pw(password);
         dto.setUser_nickname(nickname);
         dto.setUser_email(email);
         
         int res = biz.insert(dto);
         
         if(res > 0) {
            jsResponse("회원가입 되었습니다.", "home.jsp", response);
         }
         
      }else if(command.equals("id_check")) {
         String userid = request.getParameter("id");
         if(biz.id_check(userid)!=null) {
            System.out.println("아이디가 이미 존재합니다.");
            response.getWriter().write(userid);
         }else {
            System.out.println("아이디 사용 가능");
         }
      }else if(command.equals("nick_check")) {
         String nickname = request.getParameter("nickname");
         if(biz.nick_check(nickname)!=null) {
            System.out.println("닉네임이 이미 존재합니다.");
            response.getWriter().write(nickname);
         }else {
            System.out.println("닉네임 사용 가능");
         }
      }else if (command.equals("logout")) {
         request.getSession().invalidate();
         System.out.println("로그아웃 되었습니다!");
         response.sendRedirect("home.jsp");
      } else if (command.equals("naver")) { // 네이버 콜백 페이지로 이동
         dispatch(request, response, "home/member/naver_callback.jsp");
      } else if (command.equals("naver_two")) { // 네이버 콜백 페이지에서 리턴 받은 후
         HttpSession session = request.getSession();

         String token = (String) session.getAttribute("access_token"); // 네이버 로그인 접근 토큰
         String header = "Bearer " + token;
         try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
               br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { // 에러 발생
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response_buffer = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
               response_buffer.append(inputLine);
            }
            br.close();

            System.out.println(response_buffer.toString());

            JSONParser parser = new JSONParser();

            JSONObject result = (JSONObject) parser.parse(response_buffer.toString());

            String id = (String) ((JSONObject) result.get("response")).get("id");
            String name = (String) ((JSONObject) result.get("response")).get("name");
            
            boolean regist_dto = biz.regist_chk(id);
            
            if(regist_dto == true) { // db에 sns id가 존재하지 않는다면 추가정보입력 화면으로.
               request.setAttribute("id", id);
               System.out.println("회원추가정보 입력 페이지 이동!");
               dispatch(request, response, "home/member/registry_sns.jsp");
            } else { // db에 sns id가 존재하면 홈페이지로
               System.out.println("sns 아이디가 db에 존재, 홈페이지로 이동");
               // sns 아이디 체크해서 sns아이디 객체 넘기기
               user_info_dto dto = biz.login_chk_sns(id);
               
               request.getSession().setAttribute("user_info_dto", dto);

               response.sendRedirect("home.jsp");
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else if (command.equals("kakao")) {
         String id = request.getParameter("id");
         String name = request.getParameter("name");
         System.out.println("카카오 id는 " + id);
         System.out.println("카카오 name은 " + name);   
         
         boolean regist_dto = biz.regist_chk(id);
         
         if(regist_dto == true) { // db에 sns id가 존재하지 않는다면 추가정보입력 화면으로.
            request.setAttribute("id", id);
            System.out.println("회원추가정보 입력 페이지 이동!");
            dispatch(request, response, "home/member/registry_sns.jsp");
         } else { // db에 sns id가 존재하면 홈페이지로
            System.out.println("sns 아이디가 db에 존재, 홈페이지로 이동");
            // sns 아이디 체크해서 sns아이디 객체 넘기기
            user_info_dto dto = biz.login_chk_sns(id);
            
            request.getSession().setAttribute("user_info_dto", dto);

            response.sendRedirect("home.jsp");
         }
      } else if (command.equals("facebook")) {
         String id = request.getParameter("id");
         String name = request.getParameter("name");
         System.out.println("페이스북 id는 " + id);
         System.out.println("페이스북 name는 " + name);
         
         boolean regist_dto = biz.regist_chk(id);
         
         if(regist_dto == true) { // db에 sns id가 존재하지 않는다면 추가정보입력 화면으로.
            request.setAttribute("id", id);
            System.out.println("회원추가정보 입력 페이지 이동!");
            dispatch(request, response, "home/member/registry_sns.jsp");
         } else { // db에 sns id가 존재하면 홈페이지로
            System.out.println("sns 아이디가 db에 존재, 홈페이지로 이동");
            // sns 아이디 체크해서 sns아이디 객체 넘기기
            user_info_dto dto = biz.login_chk_sns(id);
            
            request.getSession().setAttribute("user_info_dto", dto);

            response.sendRedirect("home.jsp");
         }
      } else if (command.equals("registry_sns")) {
         String id = request.getParameter("id");
         String name = request.getParameter("name");
         String nickname = request.getParameter("nickname");
         String email = request.getParameter("email");
         
         user_info_dto dto = new user_info_dto();
         dto.setUser_id(id);
         dto.setUser_name(name);
         dto.setUser_nickname(nickname);
         dto.setUser_email(email);
         
         int res = biz.regist_sns(dto);
         
         if(res > 0) {
            System.out.println("추가정보가 입력되었습니다.");

            dto = biz.login_chk_sns(id); // 추가정보 입력된 id를 세션에 담아서 홈페이지 이동
            
            request.getSession().setAttribute("user_info_dto", dto);
            response.sendRedirect("home.jsp");
         } else {
            jsAlert("추가정보 입력에 실패하였습니다.", response);
            System.out.println("추가정보 입력에 실패하였습니다.");
            out.println("<script> history.back(); </script>");
         }
      } else if (command.equals("mypage")) { // 비밀번호 검사 후 내 정보 보기로 이동.
         user_info_dto dto = (user_info_dto)request.getSession().getAttribute("user_info_dto");
         String mypage_access_pw = request.getParameter("mypage_access_pw"); // 마이페이지 접근 전 비밀번호 입력 여부
         String user_pw = dto.getUser_pw(); // pw 값이 null(sns유저)인지 아닌지(일반유저)에 따라 이동할 페이지를 결정해줄 변수 
         
         if(mypage_access_pw.equals("") && user_pw != null) { // 아직 비밀번호를 입력한 적 없음
            jsResponse("암호입력으로 이동", "home/member/mypage_pw_check.jsp", response);
         } else if (user_pw == null) { // sns 유저가 이동할 마이페이지
            jsResponse("회원정보설정으로 이동", "home/member/member_info_sns.jsp", response);
         } else if(mypage_access_pw.equals("true")) { // 세션이 있는 동안 비밀번호를 입력한 적이 있음
            
            String id = dto.getUser_id();
            String pw = request.getParameter("pw"); // 비밀번호 입력창에서 가져온 값
            if(pw == null) {
               pw = dto.getUser_pw(); // 그 다음부터는 dto객체의 pw를 가져옴
               dto = biz.login_chk(id, pw);
            } else {
               dto = biz.login_chk(id, pw);
            }
            
            if(dto != null) { // 세션 만료 후 다시 로그인 시켜서 정보 업데이트된 화면 보여주기
               request.getSession().invalidate();
               dto = biz.login_chk(id, pw);
               request.getSession().setAttribute("user_info_dto", dto);
               request.getSession().setAttribute("test", mypage_access_pw);
               response.sendRedirect("home/member/member_info.jsp");
            } else {
               jsAlert("잘못된 비밀번호 입니다.", response);
               System.out.println("잘못된 비밀번호 입니다.");
               out.println("<script> history.back(); </script>");
            }

         }
      } else if (command.equals("update_user_info")) { // 회원정보 수정 처리
         String id = request.getParameter("id");
         String nickname = request.getParameter("nickname");
         String email = request.getParameter("email1") + "@" + request.getParameter("email2");
         user_info_dto dto = new user_info_dto();
         dto.setUser_id(id);
         dto.setUser_nickname(nickname);
         dto.setUser_email(email);
         
         int res = biz.update_user_info(dto);
         
         if(res > 0) {
            request.getSession().invalidate();
            dto = biz.login_chk_sns(id);
            request.getSession().setAttribute("user_info_dto", dto);
            if (dto.getUser_pw() != null){
               jsResponse("회원정보가 수정되었습니다.", "home/member/member_info.jsp", response);
            } else {
               jsResponse("회원정보가 수정되었습니다.", "home/member/member_info_sns.jsp", response);
            }
         } else {
            jsAlert("회원정보 수정을 실패하였습니다.", response);
            System.out.println("회원정보 수정을 실패하였습니다.");
            out.println("<script> history.back(); </script>");
         }
      } else if (command.equals("pw_change")) { // 비밀번호 변경
         user_info_dto dto = (user_info_dto)request.getSession().getAttribute("user_info_dto");
         String id = dto.getUser_id();
         String pw = request.getParameter("pw");
         
         dto.setUser_id(id);
         dto.setUser_pw(pw);
         
         int res = biz.update_user_pw(dto);
         
         if(res > 0) {
            request.getSession().invalidate();
            jsResponse("비밀번호가 수정되었습니다. 다시 로그인 해주세요.", "home.jsp", response);
         } else {
            jsAlert("비밀번호 수정에 실패하였습니다.", response);
            System.out.println("비밀번호 수정에 실패하였습니다.");
            out.println("<script> history.back(); </script>");
         }
      } else if (command.equals("member_withdraw")) { // 회원 탈퇴
         String id = request.getParameter("user_id");
         
         user_info_dto dto = new user_info_dto();
         dto.setUser_id(id);
         
         int res = biz.member_withdraw(dto);
         
         if (res > 0) {
            System.out.println("성공적으로 탈퇴되었습니다.");
            request.getSession().invalidate();
            jsResponse("탈퇴되었습니다. 이용해주셔서 감사합니다.", "home.jsp", response);
         } else {
            System.out.println("탈퇴 오류!!");
            out.println("<script> history.back(); </script>");
         }
      } else if(command.equals("find_id")) {
    	  try {
			String name = request.getParameter("id_name");
			  String nickname = request.getParameter("find_nickname");
			  
			  String find_email = biz.find_id(name, nickname).getUser_email();
			  System.out.println(find_email);
			  String find_id = biz.find_id(name, nickname).getUser_id();
			  System.out.println(find_id);
			  
			  find_id_email.send_find_email(find_email, find_id);
			  jsResponse("가입시 입력하신 메일로 전송되었습니다.", "home.jsp", response);
		} catch (Exception e) {
			jsResponse("입력이 올바르지 않습니다. 다시 입력해 주세요", "login.do?command=find_error", response);
		}
      } else if(command.equals("find_pw")) {
    	try {
			String name = request.getParameter("pw_name");
			String id = request.getParameter("pw_id");
			String randompass = find_pw_email.getRandomPassword();
			find_pw_email.findPassward(biz.find_pw(name, id).getUser_email(), randompass);
			if(biz.change_pw(randompass, id)>0) {
				System.out.println("비밀번호 변경 성공");
			}else {
				System.out.println("비밀번호 변경 실패");
			}
			jsResponse("가입시 입력하신 메일로 전송되었습니다.", "home.jsp", response);
		} catch (Exception e) {
			jsResponse("입력이 올바르지 않습니다. 다시 입력해 주세요", "login.do?command=find_error", response);
		}
      } else if(command.equals("find_error")) {
    	  response.sendRedirect("home/member/find_id_pw.jsp");
      }

   }

   public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
      String res = "<script type=\"text/javascript\">" + "alert('" + msg + "');"
            + "location.href ='" + url + "'</script>";

      PrintWriter out = response.getWriter();
      out.println(res);

   }

   public void dispatch(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
      RequestDispatcher dispatch = request.getRequestDispatcher(url);
      dispatch.forward(request, response);
   }
   
   public void jsAlert(String msg, HttpServletResponse response) throws IOException {
      String res = "<script type='text/javascript'>alert('" + msg + "'); </script>";

      PrintWriter out = response.getWriter();
      out.print(res);
   }
}