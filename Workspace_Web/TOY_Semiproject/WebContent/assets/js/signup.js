	var email_chk = false;
	var id_chk = false;
	var pass_chk = false;
	var pass_cfm = false;
	var nick_chk = false;
	var widgetId1;
	
	var onloadCallback = function(){
		widgetId1 = grecaptcha.render('example1', {
	        'sitekey' : '6LenA6cUAAAAAPu-anBVg9EEUxfQ9cgVkFalKvwN',
	        'theme' : 'light'
	    });
	}
	
	function send_email(){
		var user_email = $("input[name=email]").val();
		if(user_email == null || user_email == ""){
			alert("이메일을 입력해 주세요");								
		}else{
			$.ajax({
				url:"../../login.do?command=send_email&email="+user_email,
				type:"POST",
				success:function(res){
					alert("이메일 전송 완료")
					$("input[name=code]").change(function(){
						if($("input[name=code]").val()==res){
							$("div[id=confirm]").html('');
							email_chk = true;
						}else{
							$("div[id=confirm]").html('');
							$("div[id=confirm]").html('인증실패 다시 쓰세요');
							$("div[id=confirm]").val("");
						}
					});
				},
				error:function(){
					
				}
			});
		}
		
	}
	
	function id_check(){
		var user_id = $("input[name=id]").val();
		if(user_id == null || user_id == ""){
			alert("아이디를 입력하세요");
		}else{
			$.ajax({
				url:"../../login.do?command=id_check&id="+user_id,
				type:"POST",
				success:function(res){
					if(res != user_id){
						$("div[id=id_confirm]").html('사용가능한 아이디 입니다.');
						id_chk = true;
					}else{
						$("div[id=id_confirm]").html('이미 사용중인 아이디 입니다.');
						$("div[id=id_confirm]").val("");
					}
				},
				error:function(){
					
				}
			});
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
	
	function pass_check(){
		var length = $("input[name=password]").val().length;
		if(length<6){
			$("div[id=pass_check]").html('비밀번호 6자리이상 입력해 주세요');
			$("div[id=pass_check]").val("");
		}else{
			$("div[id=pass_check]").html('');
			pass_chk = true;
		}
	}
	
	function pass_confirm(){
		var once = $("input[name=password]").val();
		var twice = $("input[name=password02]").val();
		if(once != twice){
			$("div[id=pass_confirm]").html('비밀번호 같지 않습니다.');
			$("div[id=pass_confirm]").val("");
		}else{
			$("div[id=pass_confirm]").html('비밀번호 같음 확인');
			pass_cfm = true;
		}
	}
	
	function formsubmit(){
		if(grecaptcha.getResponse(widgetId1) != null && grecaptcha.getResponse(widgetId1) != "" && email_chk == true &&	id_chk == true && pass_chk == true && pass_cfm == true && nick_chk == true){
			alert("회원가입 완료!");
			return true;
		}
		alert("다시 확인해 주세요!")
		return false;
	}