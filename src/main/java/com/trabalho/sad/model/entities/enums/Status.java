package com.trabalho.sad.model.entities.enums;

public enum Status {

	PRESIDENTE(1),
	DIRETOR(2),
	SUPERVISOR(3),
	SERVIDOR(4);

	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Status valueOf(int code) {
		for (Status value : Status.values() ) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("code status inválido");
	}
}
