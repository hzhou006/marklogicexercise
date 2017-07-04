package com.marklogicexercise.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.marklogicexercise.response.HelloResponse;
import com.marklogicexercise.response.HelloResponseForJson;
import com.marklogicexercise.service.IHelloService;

@Service
public class HelloServiceImpl implements IHelloService {

	@Override
	public HelloResponse createHelloForXML() {
		HelloResponse response = new HelloResponse();
		String str = "marklogic world";
		response.setHello(str);
		return response;
	}

	@Override
	public HelloResponseForJson createHelloForJson() {
		HelloResponseForJson response = new HelloResponseForJson();
		List<String> list = new ArrayList<>();
		list.add("marklogic");
		list.add("world");
		response.setHello(list);
		return response;
	}

}
