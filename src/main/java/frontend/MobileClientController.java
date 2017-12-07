package frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.CommonTO;
import starter.DevelopmentConfiguration;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class MobileClientController {

	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

	// @Autowired
	// private FinderService finderService;

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonTO getStatusPOST(@PathVariable("userId") String userId, @RequestBody String requestBody) {

		LOG.info("userId = " + userId);
		LOG.info("requestBody = " + requestBody);

		// long status = finderService.getStatus();
		CommonTO commonTO = createCommonTO(0);

		return commonTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonTO getStatusGET(@PathVariable("userId") String userId) {
		CommonTO status = getStatusPOST(userId, "[RequestMethod.GET]");
		status.setMessage("ONLY POST METHOD IST AVAILABLE");
		return status;
	}

	// @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}",
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public String getStatus() {
	// String msg = "ONLY POST METHOD IST AVAILABLE";
	// LOG.info(msg);
	// return msg;
	// }

	private CommonTO createCommonTO(long status) {
		CommonTO commonTO = new CommonTO();
		commonTO.setId(767676);
		commonTO.setStatusId(status);

		return commonTO;
	}

}
