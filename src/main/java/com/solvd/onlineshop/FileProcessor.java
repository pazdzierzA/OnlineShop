package com.solvd.onlineshop;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileProcessor {
	private static final Logger logger = LogManager.getLogger(FileProcessor.class);

	public void fileTask(String inputFileName, String outputFileName) {
		Map<String, Integer> wordCount = new HashMap<>();
		logger.info("Reading content from file: {}.txt", inputFileName);
		try {
			String content = FileUtils.readFileToString(new File(inputFileName + ".txt"), "UTF-8");
			Arrays.stream(StringUtils.split(content)).forEach(word -> wordCount.put(word, wordCount.getOrDefault(word, 0) + 1));
		} catch (IOException e) {
			logger.error("Error reading file: {}.txt. Error message: {}", inputFileName, e.getMessage(), e);
		}
	    logger.info("Writing content to file: {}.txt", outputFileName);
	    try {
			FileUtils.writeStringToFile(new File(outputFileName+ ".txt"), wordCount.toString(), "UTF-8");
		} catch (IOException e) {
			logger.error("Error writing to file: {}.txt. Error message: {}", outputFileName, e.getMessage(), e);
		}
	
		logger.info("File task completed successfully for input: {}.txt and output: {}.txt", inputFileName,
				outputFileName);
	}
}
