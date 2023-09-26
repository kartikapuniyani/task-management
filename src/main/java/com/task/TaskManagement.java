package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagement {

	public static void main(String[] args) {
//		DemoApplication d = new DemoApplication();
//		d.sum(10,20);
		SpringApplication.run(com.task.TaskManagement.class, args);
		String input = "gainjavaknowledge";

//		Map<String, Long> output = Arrays.stream(input.split("")).collect(
//				Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println("Output : "+output);
	}
//	public void sum(short a, short b){
//		//int sum = a+b;
//		System.out.println("short method"+ a+b);
//	}
//
//	public void sum(int a, int b){
//		System.out.println("int method"+ a+ b);
//	}
//
//	public void sum(long a, long b){
//		System.out.println("long method"+ a+ b);
//	}

}
