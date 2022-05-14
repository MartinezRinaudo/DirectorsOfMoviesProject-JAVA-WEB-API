package com.educacionit.jwa.backend.backend.jwa.exceptions;

public enum ErrorEnum {
	INVALIDUSER(404, "The user/s doesn't found."),
	WRONGID(400, "You have entered an incorrect id."),
	EXISTINGUSER(400, "This username already exists in the database."),
	UNAUTHENTICATED(401, "Invalid username or password.");
	
	private int code;
	private String description;
	
	private ErrorEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}
