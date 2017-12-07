package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import service.NotificationService;
import starter.DevelopmentConfiguration;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

//    @Autowired
//	private FinderService finderService;
	
    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void notifyClients() {
//    	List<String> currentStakeholders = finderService.getCurrentStakeholders();
//    	
//    	for(String stakeholder : currentStakeholders) {
//    		LOG.info("stakeholder = " + stakeholder);
//    	}
    }
	
}
