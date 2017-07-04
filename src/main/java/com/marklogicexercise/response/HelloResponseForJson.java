package com.marklogicexercise.response;

import java.util.List;

public class HelloResponseForJson extends BaseResponse {
	List<String> hello = null;

	public List<String> getHello() {
		return hello;
	}

	public void setHello(List<String> hello) {
		this.hello = hello;
	}
}
