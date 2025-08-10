package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {
	
	@Autowired // 알아서 빈을 찾아서 그 빈을 이 인스턴스 멤버변수에 연결하라
	private TodoService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> testTodo(){
		String str = service.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
}
