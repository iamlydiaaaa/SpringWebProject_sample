package org.zerock.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

// 지정된 패키지를 조사하고 관리하는데, 그 대상이 바로 /sample/*
// Controller 어노테이션은 추가적인 속성을 지정할 수 있지만,
// @RequestMapping은 몇 가지의 속성을 추가할 수 있다: (method속성(get,post,put.delete방식 사용할 때 쓰는))
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping("")
	public void basic() {
		log.info("basic.................(SampleController.java)");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.................(SampleController.java)");
	}
	
	// 위 @RequestMapping()의 축약형 표현. 간편하긴 하지만 GET방식에만 사용할 수 있으므로 기능에 대한 제한이 많음.
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.................(SampleController.java)");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
		//http://localhost:8090/sample/ex02?name=AAA&age=50
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "ex02List";
		//http://localhost:8090/sample/ex02List?ids=111&ids=222&ids=333
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: " + Arrays.toString(ids));
		return "ex02Array";
		//http://localhost:8090/sample/ex02Array?ids=111&ids=222&ids=333
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list DTOs: " + list);
		return "ex02Bean";
		//http://localhost:8090/sample/ex02Bean?list[0].name=hihi&list[2].name=byebye
		// '['를 %5B 로,  ']'를 %5D로 변경!!
		//http://localhost:8090/sample/ex02Bean?list%5B0%5D.name=hihi&list%5B2%5D.name=byebye
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
		//http://localhost:8090/sample/ex03?title=test&dueDate=2022-10-31
	}
	
	@GetMapping("/ex04")
	//ex04에서 int타입으로 선언된 page는 전달되지 않는다. 
	//그래서 @ModelAttribute 어노테이션으로 강제로,무조건! 파라미터를 전달시키도록 한다.
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		return "/sample/ex04";
		//http://localhost:8090/sample/ex04?name=Lydia&age=27&page=11
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05........... ");
		//http://localhost:8090/sample/ex05
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		
		log.info("/ex06........... ");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(22);
		dto.setName("맴커피");
		
		return dto;
		//http://localhost:8090/sample/ex06
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		
		log.info("/ex07........... ");
		
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
		//http://localhost:8090/sample/ex07
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		
		log.info("/exUpload........... ");
		//http://localhost:8090/sample/exUpload
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info("--------------------");
			log.info("name: " + file.getOriginalFilename() + " / size: " + file.getSize()+ " / contentType: " + file.getContentType());
		});
		
		//http://localhost:8090/sample/exUpload
	}
	
}
