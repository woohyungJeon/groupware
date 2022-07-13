package com.ezenit.eroupware.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.example.bean.ExampleDTO;
import com.ezenit.eroupware.example.dao.ExampleDAO;

@Service
public class ExampleServiceImpl implements ExampleService {

	@Autowired
	private ExampleDAO exampleDAO;
	
	@Override
	public int insertExample(ExampleDTO dto) {
		return exampleDAO.insertExample(dto);
	}

}
