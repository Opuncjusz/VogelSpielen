package frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.CommonTO;
import service.FinderService;
import starter.DevelopmentConfiguration;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class MobileClientController {
	
    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    @Autowired
    private FinderService finderService;

    @RequestMapping(method = RequestMethod.POST, value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonTO getStatus(@PathVariable("userId") String userId) {

    	LOG.info("userId = " + userId);
    	
    	long status = finderService.getStatus();
    	CommonTO commonTO = createCommonTO(status);
    	
        return commonTO;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStatus() {
    	String msg = "ONLY POST METHOD IST AVAILABLE";
    	LOG.info(msg);
    	return msg;
    }
    
    private CommonTO createCommonTO(long status) {
    	CommonTO commonTO = new CommonTO();
    	commonTO.setId(767676);
    	commonTO.setStatusId(status);
    	
    	return commonTO;
    }

}
