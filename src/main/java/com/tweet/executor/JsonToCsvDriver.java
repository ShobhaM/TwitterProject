package com.tweet.executor;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import com.tweet.bean.Tweet;
import com.tweet.util.CsvWriter;
import com.tweet.util.TweetReader;
import com.tweet.util.convertToBean;

public class JsonToCsvDriver {
	
	private static Logger logger = Logger.getLogger(JsonToCsvDriver.class.getName());
	private ICsvMapWriter mapWriter = null;
	private TweetReader reader = new TweetReader();
	private CsvWriter writer = new CsvWriter();
	private convertToBean bean = new convertToBean();
	private Tweet tweet;
	int num;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonToCsvDriver driver = new JsonToCsvDriver();
		
		//String inputJsonFile = "/Users/shobha/workspace-convertjsontotweet/tweet-1398901770234.json";
		//String outputCsvFile = "/Users/shobha/workspace-convertjsontotweet/tweet-1398901770234.csv";
		
		String filepath = "/Users/shobha/tweetrepo/tweetsampledir"; //"/Users/shobha/tweetrepo/tweetjune14";
		
		try{
			
		driver.loadAndProcessFiles(filepath);
		
		}catch(Exception e){
			
			logger.severe("IO exception occured " + e.getMessage());
			
		}

	}
	
	public void loadAndProcessFiles(String filepath) throws IOException{
		File folder = new File(filepath);
		String inputJsonFile = "";
		String outputCsvFile = "";
		File[] listOfFiles = folder.listFiles();
		
		System.out.println("My path: "+ filepath);
		String archivePath = filepath + "/archive/";
		File archiveDir = new File(archivePath);
		if(!archiveDir.exists()) {
			if(archiveDir.mkdirs()) {
				System.out.println(archivePath + " -- created successfully");
			} else {
				System.out.println(archivePath + " -- failed to create");
			}
		} else {
			System.out.println(archivePath + " -- dir present");
		}
		
		for(File f: listOfFiles){
			if (f.isFile() && f.getName().toString() != ".DS_Store") {
				String filename = f.getName();
				inputJsonFile = filepath +"/"+ filename;
				System.out.println("JSON file is " + inputJsonFile );
				
				String[] fileparts = filename.split("\\.");
				outputCsvFile = filepath+"/"+fileparts[0] + ".csv";
				System.out.println("outputCsvFile ---------  :" + outputCsvFile);
				tweetJSONToCsv(inputJsonFile, outputCsvFile);
				
				
				File movefile = new File(inputJsonFile);
				
				String reNamedPath = archivePath+ filename;
				System.out.println("Renamed path: " + reNamedPath);
				if (movefile.renameTo(new File(reNamedPath))) {
					System.out.println("File is moved successful!");
				} else {
					System.out.println("File is failed to move!");
				}
				
			}
		}	
			
	}

	public void tweetJSONToCsv(String inputJsonFile, String outputCsvFile)throws IOException{
		
		
		ArrayList<JSONObject> array = reader.readFromFile(inputJsonFile);
		
		if(array != null){
			mapWriter =  new CsvMapWriter(new FileWriter(outputCsvFile), CsvPreference.STANDARD_PREFERENCE);
			writer.writeCsvHeader(mapWriter);
			
			for (JSONObject jo : array) {
				Tweet tweet = bean.convertToBean(jo);

				if (tweet != null) {
					writer.writeToCSV(tweet,mapWriter);
					num++;
				}
			}			
		}
		
		logger.info("No of tweets written to Csv ===============" + num);
	}
	
}
