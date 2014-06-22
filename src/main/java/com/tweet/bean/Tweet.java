package com.tweet.bean;

public class Tweet {
	
	private boolean favorited;
	private Contributors contributors;
	private boolean truncated;
	private String text;
	private Long in_reply_to_status_id;
	private Users user;
	private Object geo;
	private Long id;
	private boolean possibly_sensitive;
	private String lang;
	private Tweet retweeted_status;
	private Entities entities;
	private String created_at;
	private boolean retweeted;
	//public coordinates;
	private String in_reply_to_user_id_str;
	private String source;
	private String in_reply_to_status_id_str;
	private String in_reply_to_screen_name;
	private String id_str;
	//public place;
	private Integer retweet_count;
	private Long in_reply_to_user_id;
	
	public boolean isFavorited() {
		return favorited;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	public Contributors getContributors() {
		return contributors;
	}
	public void setContributors(Contributors contributors) {
		this.contributors = contributors;
	}
	public boolean getTruncated() {
		return truncated;
	}
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	public void setIn_reply_to_status_id(Long in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean getPossibly_sensitive() {
		return possibly_sensitive;
	}
	public void setPossibly_sensitive(boolean possibly_sensitive) {
		this.possibly_sensitive = possibly_sensitive;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Tweet getRetweeted_status() {
		return retweeted_status;
	}
	public void setRetweeted_status(Tweet retweeted_status) {
		this.retweeted_status = retweeted_status;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public boolean getRetweeted() {
		return retweeted;
	}
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	public String getIn_reply_to_user_id_str() {
		return in_reply_to_user_id_str;
	}
	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}
	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
	public String getId_str() {
		return id_str;
	}
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	public Integer getRetweet_count() {
		return retweet_count;
	}
	public void setRetweet_count(Integer retweet_count) {
		this.retweet_count = retweet_count;
	}
	public Long getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	public void setIn_reply_to_user_id(Long in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	
	
	@Override
	public String toString() {
		return "Tweet [favorited=" + favorited + ", contributors="
				+ contributors + ", truncated=" + truncated + ", text=" + text
				+ ", in_reply_to_status_id=" + in_reply_to_status_id
				+ ", user=" + user + ", id=" + id + ", possibly_sensitive="
				+ possibly_sensitive + ", lang=" + lang + ", retweeted_status="
				+ retweeted_status + ", created_at=" + created_at
				+ ", retweeted=" + retweeted + ", in_reply_to_user_id_str="
				+ in_reply_to_user_id_str + ", source=" + source
				+ ", in_reply_to_status_id_str=" + in_reply_to_status_id_str
				+ ", in_reply_to_screen_name=" + in_reply_to_screen_name
				+ ", id_str=" + id_str + ", retweet_count=" + retweet_count
				+ ", in_reply_to_user_id=" + in_reply_to_user_id + "]";
	}
	public Object getGeo() {
		return geo;
	}
	public void setGeo(Object geo) {
		this.geo = geo;
	}
	public Object getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

}
