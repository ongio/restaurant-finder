package com.supachote.restaurantfinder.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	public String readFileAsString(String fileName) {
		try {
			return new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (Exception e) {
			System.out.println("FileService.readFileAsString ERROR: can not read file: " + fileName);
			return null;
		}
	}
}
