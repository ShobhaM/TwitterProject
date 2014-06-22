package com.tweet.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tweet.bean.Entities;
import com.tweet.bean.Tweet;
import com.tweet.bean.Users;

public class convertToBean {
	
	private static JSONArray jsonArray;
	
	public static Tweet convertToBean(JSONObject jsonObject) {

		/*
		 * public boolean favorited; public Contributors contributors; public
		 * boolean truncated; public String text; public long
		 * in_reply_to_status_id; public Users user; //public geo; public Long
		 * id; public boolean possibly_sensitive; public String lang; public
		 * Tweet retweeted_status; //public Entities entities; public String
		 * created_at; public boolean retweeted; //public coordinates; public
		 * String in_reply_to_user_id_str; public String source; public String
		 * in_reply_to_status_id_str; public String in_reply_to_screen_name;
		 * public String id_str; //public place; public Integer retweet_count;
		 * public Long in_reply_to_user_id;
		 */

		Tweet tweet = new Tweet();

		if (jsonObject.has("favorited") && !jsonObject.isNull("favorited")) {
			tweet.setFavorited(jsonObject.getBoolean("favorited"));
		}
		if (jsonObject.has("truncated") && !jsonObject.isNull("truncated")) {
			tweet.setTruncated(jsonObject.getBoolean("truncated"));
		}

		if (jsonObject.has("text") && !jsonObject.isNull("text")) {
			tweet.setText(jsonObject.getString("text"));
		}

		if (jsonObject.has("in_reply_to_status_id")
				&& !jsonObject.isNull("in_reply_to_status_id")) {
			tweet.setIn_reply_to_status_id(jsonObject
					.getLong("in_reply_to_status_id"));// jsonObject.getString("in_reply_to_status_id"));
		}

		// public Object geo;
		if (jsonObject.has("geo") && !jsonObject.isNull("geo")) {
			tweet.setGeo(jsonObject.get("geo"));
		}

		// public Long id;
		if (jsonObject.has("id") && !jsonObject.isNull("id")) {
			tweet.setId(jsonObject.getLong("id"));

		}

		if (jsonObject.has("entities") && !jsonObject.isNull("entities")) {
			JSONObject eObject = jsonObject.getJSONObject("entities");

			Entities entities = new Entities();

			jsonArray = eObject.getJSONArray("hashtags");
			ArrayList<Object> objectArray = new ArrayList<Object>();
			if (jsonArray != null) {
				int len = jsonArray.length();
				for (int i = 0; i < len; i++) {
					objectArray.add(jsonArray.getJSONObject(i));
				}

			}
			entities.setHashtags(objectArray.toArray());

			// get media array -- First get the JsonArary, convert to arraylist,
			// and get the object array
			if (eObject.has("media") && !eObject.isNull("media")) {
				jsonArray = eObject.getJSONArray("media");

				int len = jsonArray.length();
				for (int i = 0; i < len; i++) {
					objectArray.add(jsonArray.getJSONObject(i));
				}

			}
			entities.setMedia(objectArray.toArray());

			// urls

			if (eObject.has("urls") && !eObject.isNull("urls")) {
				jsonArray = eObject.getJSONArray("urls");

				int len = jsonArray.length();
				for (int i = 0; i < len; i++) {
					objectArray.add(jsonArray.getJSONObject(i));
				}
			}
			entities.setUrls(objectArray.toArray());

			// user_mentions

			if (eObject.has("user_mentions")
					&& !eObject.isNull("user_mentions")) {
				jsonArray = eObject.getJSONArray("user_mentions");

				int len = jsonArray.length();
				for (int i = 0; i < len; i++) {
					objectArray.add(jsonArray.getJSONObject(i));
				}
			}

			entities.setUser_mentions(objectArray.toArray());
			tweet.setEntities(entities);

		}

		// public String created_at;
		if (jsonObject.has("created_at") && !jsonObject.isNull("created_at")) {
			tweet.setCreated_at(jsonObject.getString("created_at"));
		}

		// public boolean retweeted;
		if (jsonObject.has("retweeted") && !jsonObject.isNull("retweeted")) {
			tweet.setRetweeted(jsonObject.getBoolean("retweeted"));
		}

		// public coordinates;

		// public String in_reply_to_user_id_str;
		if (jsonObject.isNull("in_reply_to_user_id_str")) {
			tweet.setIn_reply_to_user_id_str(null);
		} else {
			tweet.setIn_reply_to_user_id_str(jsonObject
					.getString("in_reply_to_user_id_str"));
		}

		// public String source;
		if (jsonObject.has("source") && !jsonObject.isNull("source")) {
			tweet.setSource(jsonObject.getString("source"));
		}

		// public String in_reply_to_status_id_str;
		if (jsonObject.has("in_reply_to_status_id_str")
				&& !jsonObject.isNull("in_reply_to_status_id_str")) {
			tweet.setIn_reply_to_status_id_str(jsonObject
					.getString("in_reply_to_status_id_str"));
		}

		// public String in_reply_to_screen_name;
		if (jsonObject.has("in_reply_to_screen_name")
				&& !jsonObject.isNull("in_reply_to_screen_name")) {
			tweet.setIn_reply_to_screen_name(jsonObject
					.getString("in_reply_to_screen_name"));
		}

		// public String id_str;
		if (jsonObject.has("id_str") && !jsonObject.isNull("id_str")) {
			tweet.setId_str(jsonObject.getString("id_str"));
		}

		// public place;
		// public Integer retweet_count;
		if (jsonObject.has("retweet_count")
				&& !jsonObject.isNull("retweet_count")) {
			tweet.setRetweet_count(jsonObject.getInt("retweet_count"));
		}

		// public Long in_reply_to_user_id;
		if (jsonObject.has("in_reply_to_user_id")
				&& !jsonObject.isNull("in_reply_to_user_id")) {
			tweet.setIn_reply_to_user_id(jsonObject
					.getLong("in_reply_to_user_id"));
		}

		if (jsonObject.has("user") && !jsonObject.isNull("user")) {
			JSONObject userObject = jsonObject.getJSONObject("user");
			Users user = new Users();
			// private boolean profile_use_background_image;
			user.setProfile_use_background_image(userObject
					.getBoolean("profile_use_background_image"));

			// private Long id;
			user.setId(userObject.getLong("id"));

			// private boolean verified;
			user.setVerified(userObject.getBoolean("verified"));

			// private String profile_image_url_https;
			user.setProfile_image_url_https(userObject
					.getString("profile_image_url_https"));

			// private String profile_sidebar_fill_color;
			user.setProfile_sidebar_fill_color(userObject
					.getString("profile_sidebar_fill_color"));

			// private String profile_text_color;
			user.setProfile_text_color(userObject
					.getString("profile_text_color"));

			// private Integer followers_count;
			user.setFollowers_count(userObject.getInt("followers_count"));

			// private String profile_sidebar_border_color;
			user.setProfile_sidebar_border_color(userObject
					.getString("profile_sidebar_border_color"));

			// private String id_str;
			user.setId_str(userObject.getString("id_str"));

			// private String profile_background_color;
			user.setProfile_background_color(userObject
					.getString("profile_background_color"));

			// private Integer listed_count;
			user.setListed_count(userObject.getInt("listed_count"));

			// private String profile_background_image_url_https;
			user.setProfile_background_image_url_https(userObject
					.getString("profile_background_image_url_https"));

			// private Integer utc_offset;
			if (userObject.has("utc_offset")
					&& !userObject.isNull("utc_offset")) {
				user.setUtc_offset(userObject.getInt("utc_offset"));
			}

			// private Integer statuses_count;
			user.setStatuses_count(userObject.getInt("statuses_count"));

			// private String description;
			if (!userObject.isNull("description")
					&& userObject.has("description")) {
				user.setDescription(userObject.getString("description"));
			}

			// private Integer friends_count;
			user.setFriends_count(userObject.getInt("friends_count"));

			// private String location;
			user.setLocation(userObject.getString("location"));

			// private String profile_link_color;
			user.setProfile_link_color(userObject
					.getString("profile_link_color"));

			// private String profile_image_url;
			user.setProfile_image_url(userObject.getString("profile_image_url"));

			// private following;
			// private boolean geo_enabled;
			user.setGeo_enabled(userObject.getBoolean("geo_enabled"));

			// private String profile_banner_url;
			if (!userObject.isNull("profile_banner_url")
					&& userObject.has("profile_banner_url")) {
				user.setProfile_banner_url(userObject
						.getString("profile_banner_url"));
			}

			// private String profile_background_image_url;
			user.setProfile_background_image_url(userObject
					.getString("profile_background_image_url"));

			// private String name;
			user.setName(userObject.getString("name"));

			// private String lang;
			user.setLang(userObject.getString("lang"));

			// private boolean profile_background_tile;
			user.setProfile_background_tile(userObject
					.getBoolean("profile_background_tile"));

			// private Integer favourites_count;
			user.setFavourites_count(userObject.getInt("favourites_count"));

			// private String screen_name;
			user.setScreen_name(userObject.getString("screen_name"));

			// private boolean notifications;
			if (jsonObject.has("notifications")
					&& !jsonObject.isNull("notifications")) {
				user.setNotifications(userObject.getBoolean("notifications"));
			}

			// private String url;
			if (jsonObject.has("url") && !jsonObject.isNull("url")) {
				user.setUrl(userObject.getString("url"));
			}

			// private String created_at;
			user.setCreated_at(userObject.getString("created_at"));

			// private boolean contributors_enabled;
			user.setContributors_enabled(userObject
					.getBoolean("contributors_enabled"));

			// private String time_zone;
			if (jsonObject.has("time_zone") && !jsonObject.isNull("time_zone")) {
				user.setTime_zone(userObject.getString("time_zone"));
			}

			// private boolean _protected;
			if (jsonObject.has("_protected")
					&& !jsonObject.isNull("_protected")) {
				user.set_protected(userObject.getBoolean("_protected"));
			}

			// private boolean default_profile;
			user.setDefault_profile(userObject.getBoolean("default_profile"));

			// private boolean is_translator;
			user.setIs_translator(userObject.getBoolean("is_translator"));

			tweet.setUser(user);
		}

		//System.out.println("tweet values are " + tweet.toString());
		return tweet;
	}

}
