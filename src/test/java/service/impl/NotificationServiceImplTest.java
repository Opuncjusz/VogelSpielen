package service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
public class NotificationServiceImplTest {

	@Test
	public void notifyWhenMatchHasBeenFoundTest() {
		Assert.fail();
	}

	@Test
	public void dontNotifyWhenMatchHasNotBeenFoundTest() {
		Assert.fail();
	}

}
