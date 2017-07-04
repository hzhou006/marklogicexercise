package com.marklogicexercise.service;

import com.marklogicexercise.response.HelloResponse;
import com.marklogicexercise.response.HelloResponseForJson;

public interface IHelloService {
	public HelloResponse createHelloForXML();

	public HelloResponseForJson createHelloForJson();
}
