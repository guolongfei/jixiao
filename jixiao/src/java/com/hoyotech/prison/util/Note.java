package com.hoyotech.prison.util;

public class Note {
	private String value;
	private String label;

	public Note(){
		
	}
	
	public Note(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
