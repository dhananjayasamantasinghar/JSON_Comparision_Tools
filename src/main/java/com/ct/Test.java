package com.ct;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.ct.model.Employee_1;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws IOException {

		Optional<List<String>> optValue = AppReader
				.getPropertiesFileValueList("./properties/fileProperties.properties");

		if (optValue.isPresent()) {
			List<String> pathList = optValue.get();

			for (String string : pathList) {
				Optional<String> optContent = AppReader.getContentFromFile(string);
				if (optContent.isPresent()) {
					System.out.println(new ObjectMapper().readValue(optContent.get(), Employee_1.class));
				}
			}
		}
	}
}
