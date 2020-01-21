package com.bo.restex.entity;

import java.util.ArrayList;

public class User implements ReturnEntity {
	String name;
	ArrayList<String> repositories;

	public User(String name, ArrayList<String> repositories) {
		this.name = name;
		this.repositories = repositories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getRepositories() {
		return repositories;
	}

	public void setRepositories(ArrayList<String> repositories) {
		this.repositories = repositories;
	}

}
