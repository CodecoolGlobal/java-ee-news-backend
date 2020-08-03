package com.codecool.newsbackend.entity.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private Object id;

	public String getName(){
		return name;
	}

	public Object getId(){
		return id;
	}
}