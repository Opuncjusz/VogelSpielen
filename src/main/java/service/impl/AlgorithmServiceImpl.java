package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AlgorithmService;
import service.DesireService;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

	@Autowired
	private DesireService desireService;

	@Override
	public void calculate() {

	}
}
