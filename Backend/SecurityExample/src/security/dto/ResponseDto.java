package security.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto<T extends Object> {

	private boolean sucess;

	private T data;
	
	private List<String> errors = new ArrayList<>();
	
	public ResponseDto() {
		
	}

	public ResponseDto(boolean sucess, T data) {
		this.sucess = sucess;
		this.data = data;
	}

	public ResponseDto(List<String> errors) {
		this.sucess = false;
		this.errors = errors;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
