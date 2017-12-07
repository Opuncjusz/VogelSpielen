package service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.DesireTO;
import service.DesireService;
import test.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
public class DesireServiceImplTest {

	@Autowired
	private DesireService desireService;

	@Test
	public void addGameRequestTest() {
		int currentNumberOfDesires = desireService.getAllDesires().size();

		DesireTO desireTO = new DesireTO();
		desireService.handleIncomingDesire(desireTO);

		Assert.assertEquals(currentNumberOfDesires + 1, desireService.getAllDesires().size());
		Assert.assertTrue(desireService.getAllDesires().contains(desireTO));
	}

	@Test
	public void cancelGameRequestTest() {
		int startNumberOfDesires = desireService.getAllDesires().size();

		DesireTO desireTO = new DesireTO();
		desireService.handleIncomingDesire(desireTO);

		Assert.assertEquals(startNumberOfDesires + 1, desireService.getAllDesires().size());
		Assert.assertTrue(desireService.getAllDesires().contains(desireTO));

		desireService.canelDesire(desireTO);

		Assert.assertEquals(startNumberOfDesires, desireService.getAllDesires().size());
		Assert.assertFalse(desireService.getAllDesires().contains(desireTO));
	}

	@Test
	public void getCurrentRequestStatusWhenGameIsNotFound() {
		Assert.fail();
	}

	@Test
	public void getCurrentRequestStatusWhenGameHasBeenFound() {
		Assert.fail();
	}

	@Test
	public void getCurrentRequestStatusWhenRequestDoesNotExist() {
		Assert.fail();
	}

}
