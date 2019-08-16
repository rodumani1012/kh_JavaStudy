<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.IDIV"%>
<%@page import="com.login.dao.LoginDao"%>
<%@page import="com.login.dto.LoginDto"%>
<%@page import="com.login.biz.LoginBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String command = request.getParameter("command");
	System.out.println("command : " + command);
	
	LoginBiz biz = new LoginBiz();
	
	if(command.equals("login")) {
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		LoginDto dto = biz.login(myid, mypw);
		
		if (dto.getMyid() != null) {			
			
			//session은 sendRedirect해도 만료되기 전까지 정보를 담고 있다.
			session.setAttribute("dto", dto);
			// default : 30분.  (30분 후에 세션이 만료됩니다. ∴ 세션의 데이터가 사라짐.)
			session.setMaxInactiveInterval(10*60);
			// 600초 = 10분동안 활동이 없으면 session 만료.
			// 음수로 넣으면 무제한.(세션만료 없음)
			
			if(dto.getMyrole().equals("ADMIN")) {
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")) {
				response.sendRedirect("usermain.jsp");
			}
		} else {
%>
	<script type="text/javascript">
		alert("login 실패!");
		location.href="index.html";
	</script>
<%		
		// SELECT * FROM MYMEMBER WHERE MYID = ? AND MYPW = ?;
		// 를 리턴받아서 logincontroller.jsp까지 가져오자.
		}
	} else if(command.equals("logout")) {
		
		//세션 정보 삭제
		session.invalidate();
		response.sendRedirect("index.html");
	} else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
	} else if(command.equals("idchk")) {
		String myid = request.getParameter("id");
		
		LoginDto dto = biz.idChk(myid);
		boolean idnotused = true;
		if(dto.getMyid() != null) {
			idnotused = false;
		}
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	} else if(command.equals("insertuser")) {
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		LoginDto dto = new LoginDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.regist(dto);
		
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("가입 성공!!");
			location.href="index.html";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("가입 실패 ㅠㅠ");
			history.back();
		</script>
<%
		}
		
	} else if(command.equals("userlist_en")) {
		List<LoginDto> list = biz.selectEnabled();
		request.setAttribute("list", list);
		pageContext.forward("userlist_en.jsp");
	} else if(command.equals("myinfo")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		LoginDto dto = biz.selectOne(myno);
		request.setAttribute("dto", dto);
		pageContext.forward("myinfo.jsp");
	} else if(command.equals("updateroleform")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		LoginDto dto = biz.selectOne(myno);
		request.setAttribute("dto", dto);
		pageContext.forward("updateroleform.jsp");
	} else if(command.equals("updaterole")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("role"); //select 된 role
		
		int res = biz.updateRole(myno, myrole);
		
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("등급 변경 성공!");
			location.href="logincontroller.jsp?command=userlist_en"
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("등급 변경 실패");
			location.href="logincontroller.jsp?command=userlist_en";
		</script>
<%			
		}
	} else if(command.equals("delete")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		int res = biz.delete(myno);
		
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("탈퇴되었습니다.");
			location.href="index.html";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("탈퇴 실패!!");
			location.href="logincontroller.jsp?command=usermain";
		</script>
<%
		}
	} else if (command.equals("myupdate")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		LoginDto dto = biz.selectOne(myno);
		request.setAttribute("dto", dto);
		pageContext.forward("myupdate.jsp");
	} else if (command.equals("myupdate_res")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		LoginDto dto = new LoginDto();
		dto.setMyno(myno);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.update(dto);
		
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("정보가 수정되었습니다.");
			location.href="logincontroller.jsp?command=myinfo&myno="+<%=myno%>;
		</script>
<%			
		} else {
%>
		<script type="text/javascript">
			alert("정보 수정 실패 ㅠㅠ");
			history.back();
		</script>
<%			
		}
	}
%>


<h1>이거 보이면 안됨!</h1>
</body>
</html>