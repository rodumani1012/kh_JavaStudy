<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<c:catch var="err">		<%-- 에러메시지가 포함될 변수명 err. 에러가 발생하지않으면 null 값을 가진다. --%>
	<c:set var="weatherURL"  <%-- c:set : value(값)를 저장할 변수 var --%>
		value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code }"></c:set>
	<c:import url="${weatherURL }" var="weather"></c:import> <%-- c:set에서 설정한 값을 weather라는 이름으로 가져오자  --%>
	<x:parse var="wrss" xml="${weather }"></x:parse> <%-- xml파일을 파싱해준다.(파일 안의 값을 가져올 수 있게 된다.)
															파싱한 내용을 wrss라는 변수에 저장. --%>
	<%-- x:out == c:out // wrss파일 안에 rss 안에 channel 안에 pubDate를 출력함. --%>														
	{"pubDate":"<x:out select="$wrss/rss/channel/pubDate"/>", 
	"temp":"<x:out select="$wrss/rss/channel/item/description/body/data/temp"/>",
	"reh":"<x:out select="$wrss/rss/channel/item/description/body/data/reh"/>",
	"pop":"<x:out select="$wrss/rss/channel/item/description/body/data/pop"/>",
	"x":"<x:out select="$wrss/rss/channel/item/description/header/x"/>",
	"y":"<x:out select="$wrss/rss/channel/item/description/header/y"/>",
	"wfKor":"<x:out select="$wrss/rss/channel/item/description/body/data/wfKor"/>"}
</c:catch>
<c:if test="${err != null }">
	${err } <%-- err이 null이 아니라면 err을 반환하자 --%>
</c:if>
