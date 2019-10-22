package com.ksa.model.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "writer")
public class Writer {

	private String name;
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
