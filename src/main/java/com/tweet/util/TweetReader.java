package com.tweet.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.json.JSONObject;
import com.tweet.bean.Tweet;

public class TweetReader {
	
	private static Logger logger = Logger.getLogger(TweetReader.class.getName());
	private InputStream fis = null;
	private BufferedReader br = null;
	private ArrayList<JSONObject> jsonObjectArray = null;
	private Tweet tweet = null;
	private int tweetCount;
	
	public ArrayList<JSONObject> readFromFile(String fileName){
	
		try {
			
			jsonObjectArray = new ArrayList<JSONObject>();
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis));

			java.lang.String jsonString = null;

			while ((jsonString = br.readLine()) != null) {

				if (jsonString.isEmpty())
					continue;

				JSONObject currentObject = new JSONObject(jsonString);
				// System.out.println("jsonObject" + currentObject);
				jsonObjectArray.add(currentObject);
				tweetCount++;
			}
			
			logger.info("Total tweets in the file are ----------    " + tweetCount);

		} catch (FileNotFoundException fe) {
			logger.severe("File doesn't exist!!" + fe.getMessage());
		} catch (IOException io) {
			logger.severe("IO exception --- in reading file!!"
					+ io.getMessage());
		} catch (Exception e) {
			logger.severe(" Unknown exception" + e.getStackTrace());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.severe("Issue with closing reader -- buffredreader "
							+ e.getMessage());
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.severe("Issue with reading file-- close the inputstream "
							+ e.getMessage());
				}
			}
		}
		
		return jsonObjectArray;
	}
	
	
	public Tweet convertJSONToBean(ArrayList<JSONObject> jsonObjectArray){
		
		
		return tweet;
		
	}

	
}
