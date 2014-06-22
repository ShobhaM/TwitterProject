package com.tweet.bean;

import java.util.Arrays;

public class Entities {
	
	private Object[] hashtags;
	private Object[] media;
	private Object[] urls;
	private Object[] user_mentions;
	public Object[] getHashtags() {
		return hashtags;
	}
	public void setHashtags(Object[] hashtags) {
		this.hashtags = hashtags;
	}
	public Object[] getMedia() {
		return media;
	}
	public void setMedia(Object[] media) {
		this.media = media;
	}
	public Object[] getUrls() {
		return urls;
	}
	public void setUrls(Object[] urls) {
		this.urls = urls;
	}
	public Object[] getUser_mentions() {
		return user_mentions;
	}
	public void setUser_mentions(Object[] user_mentions) {
		this.user_mentions = user_mentions;
	}
	@Override
	public String toString() {
		return "Entities [hashtags=" + Arrays.toString(hashtags) + ", media="
				+ Arrays.toString(media) + ", urls=" + Arrays.toString(urls)
				+ ", user_mentions=" + Arrays.toString(user_mentions) + "]";
	}
	
	

}
