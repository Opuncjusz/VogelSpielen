package frontend;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.AnswerTO;
import common.DesireTO;
import common.MatchTO;
import starter.DevelopmentConfiguration;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class MobileClientController {

	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerTO getStatusPOST(@PathVariable("userId") String userId, @RequestBody String requestBody) {

		LOG.info("userId = " + userId);
		LOG.info("requestBody = " + requestBody);

		DesireTO desireTO = getDesireTO(requestBody);

		return createAnswer();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerTO getStatusGET() {
		LOG.warn("");
		LOG.warn("");
		LOG.warn("Achtung! Es wurde RequestMethod.GET durchgeführt!");
		LOG.warn("Diese Method wird in der Zukunft nicht existieren!");
		LOG.warn("");
		LOG.warn("");

		AnswerTO status = getStatusPOST("MOCK USER", "");
		status.setMessage("[RequestMethod.GET] - ONLY POST METHOD WILL BE AVAILABLE");
		return status;
	}

	private AnswerTO createAnswer() {
		AnswerTO answerTO = new AnswerTO();
		answerTO.setId(System.currentTimeMillis());
		answerTO.setDesires(new ArrayList<DesireTO>());
		answerTO.setMatches(new ArrayList<MatchTO>());
		answerTO.setMessage("Mock answer");

		return answerTO;
	}

	private DesireTO getDesireTO(String body) {
		if (StringUtils.isEmpty(body)) {
			return new DesireTO();
		}

		try {
			return new ObjectMapper().readValue(body, DesireTO.class);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}
