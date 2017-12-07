package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.DesireTO;
import common.MatchTO;
import model.Stakeholder;
import service.MatchService;
import test.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
public class MatchServiceImplTest {

    @Autowired
    MatchService matchService;

    @Test
    public void simplestAddMatchTest() {
        Stakeholder stakeholder = new Stakeholder("dupcio");
        MatchTO matchTO = new MatchTO();
        matchTO.setId(1);
        matchTO.setDesires(new ArrayList());
        DesireTO desireTO = new DesireTO();
        desireTO.setId((long) 667);
        desireTO.setStakeholder(stakeholder);
        matchTO.getDesires().add(desireTO);
        matchService.addOrUpdateMatch(matchTO);

        List<MatchTO> matches = matchService.getAllMatchesByStakeholder(stakeholder);

        Assert.assertTrue(matches.contains(matchTO));

    }

}
