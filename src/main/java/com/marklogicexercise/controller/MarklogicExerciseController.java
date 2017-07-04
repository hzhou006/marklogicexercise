package com.marklogicexercise.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.marklogicexercise.response.AdderResponse;
import com.marklogicexercise.response.BaseResponse;
import com.marklogicexercise.response.HelloResponse;
import com.marklogicexercise.response.HelloResponseForJson;
import com.marklogicexercise.response.StateResponse;
import com.marklogicexercise.service.IAdderService;
import com.marklogicexercise.service.IHelloService;
import com.marklogicexercise.service.IStateService;

@RestController
@RequestMapping("/marklogic")
public class MarklogicExerciseController {

	@Autowired
	private IHelloService helloService = null;

	@Autowired
	private IAdderService adderService = null;

	@Autowired
	private IStateService stateService = null;

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseBody
	public BaseResponse createHello(HttpServletRequest request) {
		HelloResponseForJson responseJson = new HelloResponseForJson();
		HelloResponse responseXml = new HelloResponse();
		String accept = request.getHeader("accept");
		if (accept.equals("application/xml")) {
			responseXml = helloService.createHelloForXML();
			return responseXml;
		}
		responseJson = helloService.createHelloForJson();
		return responseJson;
	}

	@RequestMapping(value = "/adderToOne", method = RequestMethod.GET, produces = { "application/json" })
	public AdderResponse adderToOne(Integer inc) {
		AdderResponse response = new AdderResponse();
		response = adderService.addOne(inc);
		return response;
	}

	@RequestMapping(value = "/stateful", method = RequestMethod.POST, produces = { "application/json" })
	public StateResponse getTotalState(Long delta) {
		StateResponse response = new StateResponse();
		response = stateService.getTotal(delta);
		return response;
	}

}
