<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type = "text/javascript">


    var tr = $(
        "<table><tr>"
        );

    for(var i = 1; i < 7; i++) {
        var td = "<td>" + i + "</td> </tr></table>"
        tr.append(td);
    }
        
        function yeon(){
            // .html을 쓰게되면 해당 엘리멘탈 대신 쓰여짐
            // $("#blank").html(tr);
            // .append를 쓰게되면 해당 엘리멘탈 뒤에 쓰여짐
            $("#blank").append(tr);
        }

        // 요래 쓰게되면 해당 엘리멘탈 태그안에 추가됨.
        $(function(){
            $("span").click(function(){
                var test = $(this).html();
                $("#abcd").text(test);
            })
        })

</script>
<body>
    
    <div id="blank" onclick="yeon()">
        Test!!!
    </div>

    <span>abc <button id="abcd">alalalalalal</button> amqjdheycbwjdywvsv</span>

</body>
</html>