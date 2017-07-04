package com.marklogicexercise.service;

import org.springframework.stereotype.Service;
import com.marklogicexercise.response.AdderResponse;

@Service
public interface IAdderService {
	public AdderResponse addOne(Integer inc);
}
