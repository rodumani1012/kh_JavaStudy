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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51191c741f7e20835fa12c73414cc9e6&libraries=services"></script>
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
				<section class="box recent-posts">
					<header>
						<h3>프로젝트 수정 하기</h3>
					</header>

					<form action="project.do" method="post" onsubmit="se2()">
						<input type="hidden" name="command" value="project_update">
						<input type="hidden" name="prj_num"
							value="${prj_info_dto.prj_num }">
						<table>
							<thead>

								<tr>
									<th>작성자</th>
									<td>${prj_info_dto.user_nickname }</td>
								</tr>
								<tr>
									<th>번호</th>
									<td>${prj_info_dto.prj_num }</td>
								</tr>

								<tr>
									<th>프로젝트 이름</th>
									<td><input type="text" name="prj_name"
										value="${prj_info_dto.prj_name }"></td>
								</tr>
							
								<tr>
									<th>주소</th>
									<td><input type="text" class="text" name="prj_loc"
										id="address" placeholder="주소 검색 클릭" readonly="readonly"
										required /></td>
								</tr>


							</thead>
							<tfoot>
								<tr>

									<td><c:if
											test="${user_info_dto.user_nickname eq prj_info_dto.user_nickname }">
											<input type="submit" class="small" value="수정" />
											<input type="button" class="small" value="취소"
												onclick="location.href='project.do?command=project_show&prj_num=${prj_info_dto.prj_num}'">
										</c:if> <input type="button" class="small" value="프로젝트 목록"
										onclick="location.href='project.do?command=project_list&user_num=${user_info_dto.user_num}'">
									</td>
								</tr>
							</tfoot>
						</table>
					</form>
				</section>
			</article>



		</div>
		<div class="map_wrap">
			<div id="map"></div>
			<div id="asd">
				<input type="button" onclick="execDaumPostcode()" value="주소 검색"><br>
			</div>

		</div>




		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div
			mapOption = {
				center : new daum.maps.LatLng(37.567175382020054,
						126.97752590717556), // 지도의 중심좌표
				level : 1
			// 지도의 확대 레벨
			};

			//지도를 미리 생성
			var map = new daum.maps.Map(mapContainer, mapOption);
			//주소-좌표 변환 객체를 생성
			var geocoder = new daum.maps.services.Geocoder();

			// 마커를 담을 배열입니다
			var markers = [];

			var marker = new daum.maps.Marker({
				position : new daum.maps.LatLng(37.56683096014424,
						126.97865225689458),
				map : map
			}), // 클릭한 위치를 표시할 마커입니다
			infowindow = new daum.maps.InfoWindow({
				zindex : 1
			});

			// 지도를 보여준다.
			mapContainer.style.display = "block";
			map.relayout();

			function execDaumPostcode() {
				new daum.Postcode({
					oncomplete : function(data) {
						var addr = data.roadAddress; // 도로명 주소 변수
						var j_addr = data.jibunAddress;//지번 주소 변수

						// 주소 정보를 해당 필드에 넣는다.
						document.getElementById("address").value = addr;
						// 주소로 상세 정보를 검색
						geocoder.addressSearch(data.address, function(results,
								status) {
							// 정상적으로 검색이 완료됐으면
							if (status === daum.maps.services.Status.OK) {

								var result = results[0]; //첫번째 결과의 값을 활용

								// 해당 주소에 대한 좌표를 받아서
								var coords = new daum.maps.LatLng(result.y,
										result.x);

								// 지도 중심을 변경한다.
								map.setCenter(coords);
								// 마커를 결과값으로 받은 위치로 옮긴다.
								marker.setPosition(coords)

								var detailAddr = '<div>도로명주소 : ' + addr
										+ '</div>';
								detailAddr += '<div>지번 주소 : ' + j_addr
										+ '</div>';

								var content = '<div class="bAddr">'
										+ '<span class="title">주소정보</span>'
										+ detailAddr + '</div>';

								// 인포윈도우에 위치에 대한 상세 주소정보를 표시합니다
								infowindow.setContent(content);
								infowindow.open(map, marker);
							}
						});
					}
				}).open();
			}

			// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
			daum.maps.event
					.addListener(
							map,
							'click',
							function(mouseEvent) {
								searchDetailAddrFromCoords(
										mouseEvent.latLng,
										function(result, status) {

											// 지도에 표시되고 있는 마커를 제거합니다
											removeMarker();

											// 인포윈도우에 클릭한 위치에 대한 상세 주소정보
											if (status === daum.maps.services.Status.OK) {
												var detailAddr = !!result[0].road_address ? '<div>도로명주소 : '
														+ result[0].road_address.address_name
														+ '</div>'
														: '';
												detailAddr += '<div>지번 주소 : '
														+ result[0].address.address_name
														+ '</div>';

												var content = '<div class="bAddr">'
														+ '<span class="title">주소정보</span>'
														+ detailAddr + '</div>';

												// 마커를 클릭한 위치에 표시합니다 
												marker
														.setPosition(mouseEvent.latLng);
												marker.setMap(map);

												// 인포윈도우에 클릭한 위치에 대한 상세 주소정보를 표시합니다
												infowindow.setContent(content);
												infowindow.open(map, marker);

												// 주소 정보를 해당 필드에 넣는다.
												var input = document
														.getElementById('address');

												input.value = result[0].road_address.address_name;
											}
										});
							});

			function searchDetailAddrFromCoords(coords, callback) {
				// 좌표로 상세 주소 정보를 요청합니다
				geocoder.coord2Address(coords.getLng(), coords.getLat(),
						callback);
			}

			// 지도 위에 표시되고 있는 마커를 모두 제거합니다
			function removeMarker() {
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(null);
				}
				markers = [];
			}
		</script>

	</div>

	<!-- Sidebar -->
	<%@ include file="../../sidebar.jsp"%>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="assets/js/main.js"></script>
	<!-- Smart Editor2 -->
	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js"
		charset="utf-8"></script>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "ir1",
			sSkinURI : "se2/SmartEditor2Skin.html",
			htParams : {
				bUseVerticalResizer : false,
				bUseModeChanger : false
			},
			fOnAppLoad : function() {
				oEditors.getById["ir1"].exec("PASTE_HTML",
						[ "${normal_board_dto.normal_content }" ])
			},
			fCreator : "createSEditor2"
		})

		function se2() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", [])
		}
	</script>

</body>

</html>