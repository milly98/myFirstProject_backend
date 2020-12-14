package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	 public static ArrayList<String[]> AllContent = new ArrayList<String[]>();

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		
		
	}
	public void chat(String id, String content) {
		if (content=="") {
		}
		else {
			AllContent.add(new String[] {id,content});
		}
		
	}

}
