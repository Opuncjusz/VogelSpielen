package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import service.NotificationService;
import starter.DevelopmentConfiguration;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    // @Autowired
    // private FinderService finderService;

    @Override
    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void notifyClients() {
        // List<String> currentStakeholders = finderService.getCurrentStakeholders();
        //
        // for(String stakeholder : currentStakeholders) {
        // LOG.info("stakeholder = " + stakeholder);
        // }
    }

    public void sendNotificationToOlek(String notificationTitle, String notificationBody) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",
                "key=AAAAn8Og0lE:APA91bH0B5rQc7oiv9JAkkepwNkJaPQkaz2nwKWpymZeCV_Du4BiOlRFHgm4QgFuxzWWbsh5cOsu3V6YD5XAj2vomsdCMdB9DZXqyzYqn2UoeoQhlVEmP3jwvMM80ZKfzE-1qMS9aZ0_");

        String body = "{\n" +
                "    \"to\" : \"eIawVgI6Ko0:APA91bFTeR29EoV8KRez8oAJjoubqPwL4swJDmTO_rVW4l5BbzmJ_kg6e6ZLiPEt5XSNUpqhw47_CFPbvNlp72z6hiy8fsge7-uI7r81uemXBXugJ6hsrCyWHgS2w_FbZHbqTUewhL_8\",\n"
                +
                "    \"notification\" : {\n" +
                "      \"body\" : \"" + notificationBody + "\",\n" +
                "      \"title\" : \"" + notificationTitle + "\"\n" +
                "      },\n" +
                "    \"data\" : {\"key\" : \"Ty chory pojebie\"}\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> exchange = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, entity, String.class);
    }
}
