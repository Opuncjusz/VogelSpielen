package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import common.DesireTO;
import common.MatchTO;
import model.Stakeholder;
import service.MatchService;
import service.NotificationService;
import starter.DevelopmentConfiguration;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    @Autowired
    private MatchService matchService;

    private boolean sent = false;

    @Override
    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void notifyClients() {
        if (matchService.getAllNewMatches().isEmpty() && !sent) {
            LOG.info("Nie ma notyfikacji do wyslania...");
            sent = true;
        }

        for (MatchTO matchTO : matchService.getAllNewMatches()) {
            for (DesireTO desire : matchTO.getDesires()) {
                sendNotification(desire.getStakeholder());
                sent = true;
            }

            // matchTO.setHasBeenSentNotification(true);
        }

    }

    private void sendNotification(Stakeholder stakeholder) {
        LOG.info("Wysylam notyfikacje do " + stakeholder.getClientMobileToken());

        if (StringUtils.isEmpty(stakeholder.getClientMobileToken())) {
            LOG.warn("ClientMobileToken jest pusty, podmieniam na mocka");

            stakeholder.setClientMobileToken(
                    "eIawVgI6Ko0:APA91bFTeR29EoV8KRez8oAJjoubqPwL4swJDmTO_rVW4l5BbzmJ_kg6e6ZLiPEt5XSNUpqhw47_CFPbvNlp72z6hiy8fsge7-uI7r81uemXBXugJ6hsrCyWHgS2w_FbZHbqTUewhL_8");
        }

        String notificationTitle = "Match has been found";
        String notificationBody = "Match has been found";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",
                "key=AAAAn8Og0lE:APA91bH0B5rQc7oiv9JAkkepwNkJaPQkaz2nwKWpymZeCV_Du4BiOlRFHgm4QgFuxzWWbsh5cOsu3V6YD5XAj2vomsdCMdB9DZXqyzYqn2UoeoQhlVEmP3jwvMM80ZKfzE-1qMS9aZ0_");

        String body = "{\n" + "    \"to\" : \"" + stakeholder.getClientMobileToken() + "\",\n"
                + "    \"notification\" : {\n" + "      \"body\" : \"" + notificationBody + "\",\n"
                + "      \"title\" : \"" + notificationTitle + "\"\n" + "      },\n" + "    \"data\" : {\"key\" : \""
                + notificationTitle + "\"}\n" + "}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> exchange = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST,
                entity, String.class);
    }
}
