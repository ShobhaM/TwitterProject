package com.tweet.bean;

public class Contributors {

	private Long id;
	private String id_str;
	private String screen_name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getId_str() {
		return id_str;
	}
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	@Override
	public String toString() {
		return "Contributors [id=" + id + ", id_str=" + id_str
				+ ", screen_name=" + screen_name + "]";
	}
	
	
}
