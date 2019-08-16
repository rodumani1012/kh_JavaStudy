<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html>

<head>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
	<script type="text/javascript" src="../../assets/js/signup.js?ver=1"></script>
	<title>Striped by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../../assets/css/main.css" />
<style type="text/css">
	#user_info_table input {
		display: inline;
	}
	
	#user_info_table span {
		width: 5em;
	}
</style>
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="${pageContext.request.contextPath}/login.do" onsubmit="return formsubmit();">
					<input type="hidden" name="command" value="regist"/>
					<header>
						<h3>회원가입</h3>
					</header>
					<table>
						<tr>
							<th>이름</th>
							<td>
								<input type="text" class="text" name="name" placeholder="이름" required />
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" class="text" name="id" placeholder="아이디" required />
								<div id="id_confirm"></div>
								<input type="button" id="btn_idcheck" value="중복확인" onclick="id_check()"/><p></p>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<input type="password" class="text" name="password" placeholder="비밀번호" onchange="pass_check()" required />
								<div id="pass_check"></div>
								<input type="password" class="text" name="password02" placeholder="비밀번호 확인" onchange="pass_confirm()" required />
								<div id="pass_confirm"></div>
							</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>
								<input type="text" class="text" name="nickname" placeholder="닉네임" required />
								<div id="nick_confirm"></div>
								<input type="button" name="btn_nickcheck" value="중복확인" onclick="nick_check()"/><p></p>
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" class="text" name="email" placeholder="이메일" required/>
								<input type="button" id="btn_sendemail" value="인증번호발송" onclick="send_email()"/><p></p>
							</td>
						</tr>
						<tr>
							<th>이메일 인증번호</th>
							<td>
								<input type="text" class="text" name="code" placeholder="인증번호" required/>
								<div id="confirm"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div id="example1" style="margin-left: 18em;"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2" >
								<input type="submit" value="회원가입" style="margin-left: 10em;"/>
							</td>
						</tr>
					</table>
				</form>
			</section>

		</div>
	</div>
	
	<%@ include file="../../sidebar.jsp" %>
	
</body>

</html>