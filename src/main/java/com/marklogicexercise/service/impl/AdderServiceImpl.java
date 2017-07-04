package com.marklogicexercise.service.impl;

import org.springframework.stereotype.Service;
import com.marklogicexercise.response.AdderResponse;
import com.marklogicexercise.service.IAdderService;

@Service
public class AdderServiceImpl implements IAdderService {

	@Override
	public AdderResponse addOne(Integer inc) {

		AdderResponse response = new AdderResponse();
		if (inc == null) {
			response.setAnswer(1);
			return response;
		}
		response.setAnswer(inc + 1);
		return response;
	}

}
