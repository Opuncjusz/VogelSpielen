package service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.CommonTO;
import service.FinderService;
import test.TestApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
public class FinderServiceImplTest {

    @Autowired
	private FinderService finderService;
    
    @Test
    // Mock test
    public void statusTest() {
    	long status = finderService.getStatus();
    	Assert.assertEquals(CommonTO.STATUS_SEARCH, status);
    }
    
    @Test
    // Mock test
    public void stakeholdersTest() {
    	List<String> currentStakeholdersMock = finderService.getCurrentStakeholders();
    	
    	Assert.assertFalse(currentStakeholdersMock.isEmpty());
    	Assert.assertEquals(4, currentStakeholdersMock.size());
    }

	
}
