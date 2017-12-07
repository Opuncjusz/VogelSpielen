package service.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.AlgorithmService;
import test.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
public class AlgorithmServiceImplTest {

	@Autowired
	private AlgorithmService algorithmService;

	public void calculateTest() {

	}

}
