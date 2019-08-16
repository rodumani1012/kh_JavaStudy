var email_chk = false;
var nick_chk = false;
	
$(function(){ // 새 비밀번호와 다시 입력한 새 비밀번호가 같은지 검사, 6자리 검사
		$("#pw_success").hide();
		$("#pw_fail").hide();
        $("input").keyup(function(){
        	var pw1=$("#now_pw").val();
            var pw2=$("#new_pw").val();
            var pw3=$("#new_pw_chk").val();
            
            if(pw1.length >=6 && pw2.length >= 6 && pw3.length >= 6){
                $("#pass_check").hide();
            } else {
            	$("#pass_check").show();
    			$("#pass_check").html("비밀번호 6자리이상 입력해 주세요");
            }
            if(pw2 != "" || pw3 != ""){
                if(pw2 == pw3){
                    $("#pw_success").show();
                    $("#pw_fail").hide();
                    $("#pw_change_btn").removeAttr("disabled");
                }else{
                    $("#pw_success").hide();
                    $("#pw_fail").show();
                    $("#pw_change_btn").attr("disabled", "disabled");
                }    
            }
        });

    	// 이메일 입력방식 선택
    	$("#select_email").change(function(){
    		$("#select_email option:selected").each(function(){
    			
    			if($(this).val() == "1") { // 직접입력인 경우
    				$("#email2").val(""); // 값 초기화
    				$("#email2").prop("readonly", false); //활성화
    			} else { // 직접입력이 아닌 경우
    				$("#email2").val($(this).text()); // 선택된 값으로 입력
    				$("#email2").prop("readonly", true); //비활성화
    			}
    		});
    	});
	});
	
	function pw_change() { // 기존 비밀번호와 새 비밀번호가 같은지 체크
		var now_pw = $("#now_pw").val();
		var new_pw = $("#new_pw").val();
		var new_pw_chk = $("#new_pw_chk").val();
		if(now_pw != "" && new_pw_chk != "" && now_pw != null && new_pw_chk != null) {
			if(now_pw == new_pw_chk) {
				alert("기존 비밀번호와 같습니다.");
			} else { // 기존 비밀번호와 새 비밀번호가 다르면 업데이트하는 db로 submit한다.
				if(new_pw_chk.length >=6 && new_pw_chk.length >= 6) {
					$("#pw_change_btn").prop("disabled", false);
					$("form").prop("action","../../login.do?command=pw_change&pw="+new_pw_chk);
					$("form").prop("onsubmit", true);
					$("form").submit();
				} else {
					alert("암호가 6자리 이하인 곳이 있습니다.");
				}
			}
		} else {
			alert("빈칸이 있습니다.");
		}
	}
	
	function nick_check(){
		var user_nick = $("input[name=nickname]").val();
		if(user_nick == null || user_nick == ""){
			alert("닉네임을 입력하세요");
		}else{
			$.ajax({
				url:"../../login.do?command=nick_check&nickname="+user_nick,
				type:"POST",
				success:function(res){
					if(res != user_nick){
						$("div[id=nick_confirm]").html('사용가능한 닉네임 입니다.');
						nick_chk = true;
					}else{
						$("div[id=nick_confirm]").html('이미 사용중인 닉네임 입니다.');
						$("div[id=nick_confirm]").val("");
					}
				},
				error:function(){
					
				}
			});
		}
	}
	
	function withdraw() {
		var user_id = $("input[name=id]").val();
		var result = confirm("탈퇴하시겠습니까?"); 
		if(result) { 
			$("form").prop("action","../../login.do?command=member_withdraw&user_id="+user_id);
			$("form").submit();
		} else { 
			
		}
	}
	
	function formsubmit(){
		if((email_chk != null && email_chk == true) || (nick_chk != null && nick_chk == true)){
			return true;
		} else if (nick_chk == false) {
			alsert("닉네임이 입력되지 않았습니다.")
			return false;
		} 
	}
	
	