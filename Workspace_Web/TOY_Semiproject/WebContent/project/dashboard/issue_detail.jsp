<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<div class='layer'></div>
<article class="box post post-excerpt" id="pop">
	<section class="box recent-posts">
		<table>
			<thead>
				<tr>
					<th colspan="2">
						<h3>이슈 보기</h3>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>중요도</th>
					<td><input type="text" id="priority" class="2click" readonly></td>
				</tr>
				<tr>
					<th>이슈 제목</th>
					<td><input type="text" id="title" class="2click" readonly></td>
				</tr>
				<tr>
					<th>이슈 내용</th>
					<td><input type="text" id="text" class="2click" readonly></td>
				</tr>
				<tr>
					<th>참여인원</th>
					<td><input type="text" id="require" readonly></td>
				</tr>
				<tr>
					<th>책임자</th>
					<td><input type="text" id="charger" class="2click" readonly></td>
				</tr>
				<tr>
					<th>마감기한</th>
					<td><input type="text" id="deadline" class="2click" readonly></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button id="detail_back">돌아가기</button>
						<button id="issue_del">삭제</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</section>
</article>
