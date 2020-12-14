package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.ReverbType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.WebApplication;

@RestController
public class HomeController {
	@GetMapping("/")
    public ArrayList<String[]> home(@RequestParam String id, @RequestParam String content){
    	System.out.println("홈 컨트롤러 진입");
    	WebApplication webApplication = new WebApplication();
    	
    	webApplication.chat(id, content);
		return WebApplication.AllContent;
    }
    @RequestMapping("/getall")
    public ArrayList<String[]> getall(){
    	//System.out.println("대화내역 가져오기");
    	return WebApplication.AllContent;
    }
    @RequestMapping("/download")
    public void download(){
    	System.out.println("대화내역 다운로드");

		String str = "";
    	for (String[] allcontent : WebApplication.AllContent) {
    		for(String allcontent2:allcontent) {
    			str+= allcontent2+"  ";
    		}
    		str+= "\n";
		}
    	System.out.println("str"+str);
    	OutputStream output;
		try {
			output = new FileOutputStream("./chatExport.txt");
			byte[] by = str.getBytes();
			output.write(by);
		}catch (FileNotFoundException e) {
			System.out.println("파일에러발생"+ e.toString());
		}catch (IOException e) {
			System.out.println("IO에러발생"+ e.toString());
		}
    }
}
