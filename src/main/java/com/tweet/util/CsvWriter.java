package com.tweet.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvMapWriter;

import com.tweet.bean.Tweet;
import com.tweet.bean.Users;

public class CsvWriter {
	
	private static Logger logger = Logger.getLogger(CsvWriter.class.getName());
	
	private String[] header = new String[] { "favorited", "contributors",
		"truncated", "text", "in_reply_to_status_id", "user", "geo",
		"id", "possibly_sensitive", "lang", "retweeted_status",
		"entities", "created_at", "retweeted", "coordinates",
		"in_reply_to_user_id_str", "source",
		"in_reply_to_status_id_str", "in_reply_to_screen_name",
		"id_str", "place", "retweet_count", "in_reply_to_user_id" };
	
	
	public void writeCsvHeader(ICsvMapWriter mapWriter){
		
		// write the header
					try {
						mapWriter.writeHeader(header);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						logger.severe("Issue with writing header " + e.getMessage());
						e.printStackTrace();
					}
		
	}
	

	public void writeToCSV(Tweet tweet, ICsvMapWriter mapWriter) throws IOException {

		//logger.info("inside writeToCsv method");
		final Map<String, Object> tweetMap = new HashMap<String, Object>();
		String userString = null;
		if (tweet.getUser() != null) {
			Users user = tweet.getUser();
			userString = user.toString();
			//System.out.println("user is : " + user.toString());
		} else {
			userString = null;
		}

		tweetMap.put("favorited", tweet.isFavorited());
		tweetMap.put("contributors", tweet.getContributors());
		tweetMap.put(header[2], tweet.getTruncated());
		tweetMap.put(header[3], tweet.getText());
		tweetMap.put(header[4], tweet.getIn_reply_to_status_id());
		tweetMap.put(header[5], userString);
		tweetMap.put(header[6], tweet.getGeo());
		tweetMap.put(header[7], tweet.getId());
		tweetMap.put(header[8], tweet.getPossibly_sensitive());
		tweetMap.put(header[9], tweet.getLang());
		tweetMap.put(header[10], tweet.getRetweeted_status());
		tweetMap.put(header[11], tweet.getEntities());
		tweetMap.put(header[12], tweet.getCreated_at());
		tweetMap.put(header[13], tweet.getRetweeted());
		tweetMap.put(header[14], "");
		tweetMap.put(header[15], tweet.getIn_reply_to_user_id_str());
		tweetMap.put(header[16], tweet.getSource());
		tweetMap.put(header[17], tweet.getIn_reply_to_status_id_str());
		tweetMap.put(header[18], tweet.getIn_reply_to_screen_name());
		tweetMap.put(header[19], tweet.getId_str());
		tweetMap.put(header[20], "");
		tweetMap.put(header[21], tweet.getRetweet_count());
		tweetMap.put(header[22], tweet.getIn_reply_to_user_id());

		final CellProcessor[] processors = getProcessors();
		
		// write the tweet maps
		mapWriter.write(tweetMap, header, processors);
	}

	private CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] {
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional() };

		return processors;
	}
	
}
