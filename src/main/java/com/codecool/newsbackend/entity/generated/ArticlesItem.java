package com.codecool.newsbackend.entity.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticlesItem{

	@JsonProperty("publishedAt")
	private String publishedAt;

	@JsonProperty("author")
	private String author;

	@JsonProperty("urlToImage")
	private String urlToImage;

	@JsonProperty("description")
	private String description;

	@JsonProperty("source")
	private Source source;

	@JsonProperty("title")
	private String title;

	@JsonProperty("url")
	private String url;

	@JsonProperty("content")
	private String content;

	public String getPublishedAt(){
		return publishedAt;
	}

	public String getAuthor(){
		return author;
	}

	public String getUrlToImage(){
		return urlToImage;
	}

	public String getDescription(){
		return description;
	}

	public Source getSource(){
		return source;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	public String getContent(){
		return content;
	}
}