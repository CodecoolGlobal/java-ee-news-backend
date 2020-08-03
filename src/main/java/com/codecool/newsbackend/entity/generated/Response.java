package com.codecool.newsbackend.entity.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("totalResults")
	private int totalResults;

	@JsonProperty("articles")
	private List<ArticlesItem> articles;

	@JsonProperty("status")
	private String status;

	public int getTotalResults(){
		return totalResults;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}
}