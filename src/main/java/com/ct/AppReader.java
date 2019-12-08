package com.ct;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class AppReader {

	/**
	 * This method will read file content from location ex: "./static/pod.json".
	 * 
	 * @param fileLocation
	 * @return
	 */
	public static Optional<String> getContentFromFile(String fileLocation) {
		try {
			URI uri = ClassLoader.getSystemResource(fileLocation).toURI();
			byte[] readAllBytes = Files.readAllBytes(Paths.get(uri));
			String content = new String(readAllBytes, StandardCharsets.ISO_8859_1);
			return Optional.of(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();

	}

	/**
	 * This method will read file content from location line by line ex:
	 * "./static/pod.json".
	 * 
	 * @param fileLocation
	 * @return
	 */
	public static Optional<List<String>> getDataLineByLine(String filePath) {
		try {
			URI uri = ClassLoader.getSystemResource(filePath).toURI();
			return Optional.ofNullable(Files.readAllLines(Paths.get(uri)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static Optional<List<String>> getPropertiesFileValueList(String path) {
		try {
			Properties properties = new Properties();
			properties.load(ClassLoader.getSystemResourceAsStream(path));
			ArrayList<String> values = new ArrayList<>();
			
			properties
			.values()
			.stream()
			.forEach(e -> values.add(String.valueOf(e)));
			
			return Optional.ofNullable(values);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();

	}
}
