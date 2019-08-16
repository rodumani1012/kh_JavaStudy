<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE HTML>
<!--
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>

<title>Striped by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Titlebar -->
	<div id="titleBar">
		<a href="#sidebar" class="toggle"></a> <span class="title"><a
			href="#">STRIPED</a></span>
	</div>

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<article class="box post post-excerpt">
				<section class="box recent-posts" style="width:900px;">
					<header>
						<h3>작성글 보기</h3>
					</header>
					<table>
						<tbody>
							<tr>
								<th>번호</th>
								<td>${normal_board_dto.normal_num }</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${normal_board_dto.normal_date_create }</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${normal_board_dto.user_nickname }</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${normal_board_dto.normal_title }</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${normal_board_dto.normal_content }</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td><c:if
										test="${user_info_dto.user_num eq normal_board_dto.user_num }">
										<input type="button" class="small" value="수정"
											onclick="location.href='home.do?command=board_updateform&normal_num=${normal_board_dto.normal_num}'">
										<input type="button" class="small" value="삭제"
											onclick="location.href='home.do?command=board_delete&normal_num=${normal_board_dto.normal_num}&normal_category=${normal_board_dto.normal_category }'">
										<c:if test="${normal_board_dto.normal_category eq crew }">
										<input type="button" class="small" id="pay" value="프리미엄 등록" />
										</c:if>										
									</c:if> <input type="button" class="small" value="목록"
									onclick="location.href='home.do?command=board_list&normal_category=${normal_board_dto.normal_category}'">
									<input type="hidden" id="normal_num"
									value="${normal_board_dto.normal_num }"></td>
								
							</tr>
						</tfoot>


					</table>

					<table>
						<tr>
							<th colspan="2">
								<h3>댓글</h3>
							</th>
						</tr>
						<c:forEach items="${comment_board_dto }" var="item">
							<form action="home.do"
								onsubmit="comment_chk(${empty user_info_dto.user_num})">
								<input type="hidden" name="command" value="comment_comment">
								<input type="hidden" name="comment_num"
									value="${item.comment_num}"> <input type="hidden"
									name="normal_num" value="${normal_board_dto.normal_num}">
								<tr>
									<th><c:forEach begin="1" end="${item.comment_titletab }">
											RE:
										</c:forEach> ${item.user_nickname }</th>
									<td>${item.comment_content }</td>
									<td><a class="comment">&gt;&gt;답글</a> <textarea
											name="comment_comment" id="" cols="10" rows="3"
											style="display: none"></textarea> <input type="submit"
										value="작성" class="small" style="display: none"> <c:if
											test="${user_info_dto.user_num eq item.user_num}">
											<input type="button" class="small" value="삭제"
												onclick="location.href='home.do?command=comment_delete&comment_num=${item.comment_num}&normal_num=${normal_board_dto.normal_num}'">
										</c:if></td>
								</tr>
							</form>
						</c:forEach>
					</table>


					<form action="home.do">
						<input type="hidden" name="command" value="comment_insert">
						<input type="hidden" name="normal_num"
							value="${normal_board_dto.normal_num}">
						<table>
							<tr>
								<th colspan="2">
									<h3>댓글쓰기</h3>
								</th>
							</tr>
							<tr>
								<th>nickname</th>
								<td>${user_info_dto.user_nickname}</td>
							</tr>
							<tr>
								<th>content</th>
								<td><textarea name="comment_content" cols="30" rows="10"></textarea></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" class="small"
									value="댓글쓰기"></td>
							</tr>
						</table>
					</form>
				</section>
			</article>

		</div>
	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js">

	</script>
	<script src="assets/js/main.js?ver=1"></script>
	<script type="text/javascript">
	
	
		function comment_chk(bool) {
			if (bool) {
				alert("로그인을 해주세요")
				return false
			} else {
				return true
			}
		}
	</script>

	<!-- kakaopay -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>
	var normal_num = document.getElementById('normal_num').value;
        var IMP = window.IMP; 
        IMP.init('imp14806872'); 
        $("#pay").click(function() {
            IMP.request_pay({
            pg : 'kakaopay', 
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '프리미엄',
            amount : 1,
            buyer_email : 'test@naver.com',
            buyer_name : 'kh',
            buyer_tel : '010-1234-5678',
            buyer_addr : '서울특별시 강남구 역삼동',
            buyer_postcode : '123-456'
            
            /* 
            m_redirect_url : 'https://www.yourdomain.com/payments/complete' */
        }, function(rsp) {
        	
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "home.do?command=kakaopay", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'text',
                    data: {
                    	"normal_num" : normal_num,
                    	"normal_premium":"Y"
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                        
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
                alert("결제에 성공하였습니다!");
               	alert(normal_num);
               	location.href = "home.do?command=insertform&normal_category=CREW"
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
               
                alert(msg);
                
            }
        });
        
    });//
          
</script>
</body>

</html>