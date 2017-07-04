package com.marklogicexercise.service;

import org.springframework.stereotype.Service;
import com.marklogicexercise.response.StateResponse;

@Service
public interface IStateService {
	public StateResponse getTotal(Long delta);
}
