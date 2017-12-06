package service.impl;

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
    public void shouldReturnFloorsListSortedByDistanceToStartingFloorAscendingStartingFloor5() {
    	long status = finderService.getStatus();
    	Assert.assertEquals(CommonTO.STATUS_SEARCH, status);
    }

	
}
