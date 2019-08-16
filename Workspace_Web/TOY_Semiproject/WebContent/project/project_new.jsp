<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../assets/css/main.css" />
	<script type="text/javascript" src="../assets/js/invite_email.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51191c741f7e20835fa12c73414cc9e6&libraries=services"></script>

	<style type="text/css">
		.inner {
			float: left;
			width: 40%;
		}

		.map_wrap {
			width: 53%;
			margin-left: 40%;
			z-index: -1;
		}

		#asd {
			width: 90px;
			height: 50px;
		}

		#map {
			width: 100%;
			height: 320px;
			display: none;
			border: 2px solid #42d9f7;
		}
	</style>
</head>

<body class="is-preload">

	<!-- Content -->
	<div id="content">
		<div class="inner">

			<!-- Post -->
			<section class="box search">
				<form method="post" action="../project.do">
					<header>
						<h3>프로젝트 생성</h3>
					</header>
					<input type="hidden" value="project_new" name="command">
					<input type="hidden" value="${user_info_dto.user_num}" name="user_num">
					<input type="text" class="text" name="user_nickname" value="${user_info_dto.user_nickname }"
						readonly="readonly" />
					<input type="text" class="text" name="prj_name" placeholder="프로젝트 이름" onchange="prj_name_check()"
						required />
					<input type="text" class="text" name="prj_invite_nick01" placeholder="초대할 사람 닉네임"
						onchange="nick_check01()" />
					<div id="nick_confirm01"></div>
					<input type="text" class="text" name="prj_invite_nick02" placeholder="초대할 사람 닉네임"
						onchange="nick_check02()" />
					<div id="nick_confirm02"></div>
					<input type="text" class="text" name="prj_invite_nick03" placeholder="초대할 사람 닉네임"
						onchange="nick_check03()" />
					<div id="nick_confirm03"></div>
					<input type="text" class="text" name="prj_invite_nick04" placeholder="초대할 사람 닉네임"
						onchange="nick_check04()" />
					<div id="nick_confirm04"></div>
					<input type="text" class="text" name="prj_invite_nick05" placeholder="초대할 사람 닉네임"
						onchange="nick_check05()" />
					<div id="nick_confirm05"></div>
					<input type="text" class="text" name="prj_loc" id="address" placeholder="도로명 주소" readonly="readonly"
						required />
					<input type="submit" value="프로젝트 생성">
				</form>
			</section>

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
					center: new daum.maps.LatLng(37.567175382020054, 126.97752590717556), // 지도의 중심좌표
					level: 1
					// 지도의 확대 레벨
				};

			//지도를 미리 생성
			var map = new daum.maps.Map(mapContainer, mapOption);
			//주소-좌표 변환 객체를 생성
			var geocoder = new daum.maps.services.Geocoder();

			// 마커를 담을 배열입니다
			var markers = [];

			var marker = new daum.maps.Marker({
				position: new daum.maps.LatLng(37.56683096014424, 126.97865225689458),
				map: map
			}), // 클릭한 위치를 표시할 마커입니다
				infowindow = new daum.maps.InfoWindow({
					zindex: 1
				});

			// 지도를 보여준다.
			mapContainer.style.display = "block";
			map.relayout();

			function execDaumPostcode() {
				new daum.Postcode({
					oncomplete: function (data) {
						var addr = data.roadAddress; // 도로명 주소 변수
						var j_addr = data.jibunAddress;//지번 주소 변수

						// 주소 정보를 해당 필드에 넣는다.
						document.getElementById("address").value = addr;
						// 주소로 상세 정보를 검색
						geocoder.addressSearch(data.address, function (results,
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


								var detailAddr = '<div>도로명주소 : ' + addr + '</div>';
								detailAddr += '<div>지번 주소 : ' + j_addr + '</div>';

								var content = '<div class="bAddr">'
									+ '<span class="title">주소정보</span>' + detailAddr
									+ '</div>';


								// 인포윈도우에 위치에 대한 상세 주소정보를 표시합니다
								infowindow.setContent(content);
								infowindow.open(map, marker);
							}
						});
					}
				}).open();
			}

			// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
			daum.maps.event.addListener(map, 'click', function (mouseEvent) {
				searchDetailAddrFromCoords(mouseEvent.latLng, function (result,
					status) {

					// 지도에 표시되고 있는 마커를 제거합니다
					removeMarker();

					// 인포윈도우에 클릭한 위치에 대한 상세 주소정보
					if (status === daum.maps.services.Status.OK) {
						var detailAddr = !!result[0].road_address ? '<div>도로명주소 : '
							+ result[0].road_address.address_name + '</div>'
							: '';
						detailAddr += '<div>지번 주소 : '
							+ result[0].address.address_name + '</div>';

						var content = '<div class="bAddr">'
							+ '<span class="title">주소정보</span>' + detailAddr
							+ '</div>';


						// 마커를 클릭한 위치에 표시합니다 
						marker.setPosition(mouseEvent.latLng);
						marker.setMap(map);

						// 인포윈도우에 클릭한 위치에 대한 상세 주소정보를 표시합니다
						infowindow.setContent(content);
						infowindow.open(map, marker);


						// 주소 정보를 해당 필드에 넣는다.
						var input = document.getElementById('address');

						input.value = result[0].road_address.address_name;
					}
				});
			});

			function searchDetailAddrFromCoords(coords, callback) {
				// 좌표로 상세 주소 정보를 요청합니다
				geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
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
	<%@ include file="../../sidebar.jsp" %>


</body>

</html>