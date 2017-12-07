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
@RequestMapping("/")
public class MobileClientController {

	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

	@RequestMapping(method = RequestMethod.GET, value = "status/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerTO getStatusGET(@PathVariable("userId") String userId) {

		LOG.info("==== getStatusGET ====");
		LOG.info("userId = " + userId);

		return createAnswer(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "desire/put/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerTO putDesirePOST(@PathVariable("userId") String userId, @RequestBody String requestBody) {

		LOG.info("==== putDesirePOST ====");
		LOG.info("userId = " + userId);
		LOG.info("requestBody = " + requestBody);

		AnswerTO answer = new AnswerTO();
		answer.setMessage("putDesirePOST");

		return answer;
	}

	@RequestMapping(method = RequestMethod.POST, value = "desire/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerTO deleteDesirePOST(@PathVariable("userId") String userId, @RequestBody String requestBody) {

		LOG.info("==== deleteDesirePOST ====");
		LOG.info("userId = " + userId);
		LOG.info("requestBody = " + requestBody);

		AnswerTO answer = new AnswerTO();
		answer.setMessage("deleteDesirePOST");

		return answer;
	}

	private AnswerTO createAnswer(String userId) {
		AnswerTO answerTO = new AnswerTO();
		answerTO.setId(System.currentTimeMillis());
		answerTO.setDesires(new ArrayList<DesireTO>());
		answerTO.setMatches(new ArrayList<MatchTO>());
		answerTO.setMessage("Mock answer, userId: " + userId);

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
