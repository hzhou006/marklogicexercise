package com.marklogicexercise.service.impl;

import org.springframework.stereotype.Service;
import com.marklogicexercise.response.StateResponse;
import com.marklogicexercise.service.IStateService;

@Service
public class StateServiceImpl implements IStateService {

	private static Long total = null;

	@Override
	public StateResponse getTotal(Long delta) {
		StateResponse response = new StateResponse();
		if (total == null) {
			response.setTotal(delta);
			total = delta;
			return response;
		}
		total += delta;
		response.setTotal(total);
		return response;
	}

}
