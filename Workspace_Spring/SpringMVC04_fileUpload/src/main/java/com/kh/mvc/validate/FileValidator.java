package com.kh.mvc.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

//	https://springsource.tistory.com/18
	
	//supports() 는 이 검증기가 검증할 수 있는 오브젝트 타입인지를 확인해 주는 메소드다. 
	//supports() 메소드를 통과한 경우에만 validate() 가 호출된다.
	@Override
	public boolean supports(Class<?> arg0) {
		return false; // return false; 사용 안하고 있음.
	}

	//만약 오류가 발견되면 Errors 인터페이스를 통해서 
	//특정 필드나 모델 오브젝트 전체에 대해 오류 정보를 등록할 수 있다.
	//Errors 인터페이스를 통해서 등록된 오류는 최종적으로 BindingResult 에 담겨
	//컨트롤러에 전달된다.
	@Override
	public void validate(Object uploadFile, Errors errors) {
		UploadFile file = (UploadFile) uploadFile;

		if(file.getFile().getSize() == 0) { // 파일의 용량이 0byte면!
			// file이라는 필드에 대해 에러 메세지 출력!
			errors.rejectValue("file", "errorCode", 
					"Please select a file");
			// 에러 코드에 대한 메시지가 존재하지 않을 경우 defaultMessage를 사용
		}
	}
}
