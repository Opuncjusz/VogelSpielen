package service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.AlgorithmResultDS;
import common.DesireTO;
import common.MatchTO;
import model.Stakeholder;
import service.AlgorithmService;
import service.DesireService;
import test.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplicationContext.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AlgorithmServiceImplTest {

    @Autowired
    private AlgorithmService algorithmService;

    @Autowired
    private DesireService desireService;

    private DesireTO createDefaultFirstDesire() {
        return createDefaultDesire(1, new Stakeholder("Dupcio 1"));
    }

    private DesireTO createDefaultSecondDesire() {
        return createDefaultDesire(2, new Stakeholder("Dupcio 2"));
    }

    private DesireTO createDefaultThirdDesire() {
        return createDefaultDesire(3, new Stakeholder("Dupcio 3"));
    }

    private DesireTO createDefaultDesire(long id, Stakeholder secondStakeholder) {
        DesireTO secondDesire = new DesireTO();
        secondDesire.setId(id);
        secondDesire.setPlace("miejsce");
        secondDesire.setFrom("2017-12-07 15:00");
        secondDesire.setTo("2017-12-07 16:00");
        secondDesire.setTotal("4");
        secondDesire.setRequired("2");
        secondDesire.setStakeholder(secondStakeholder);
        return secondDesire;
    }

    @Test
    public void shouldNotMatchOnDifferentPlace() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setPlace("inne");
        secondDesire.setPlace("miejsce");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldNotMatchOnTheSameStakeholder() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setStakeholder(secondDesire.getStakeholder());

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldNotMatchOnDifferentTimesTooEarly() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setFrom("2017-12-07 14:00");
        firstDesire.setTo("2017-12-07 15:00");
        secondDesire.setFrom("2017-12-07 15:00");
        secondDesire.setTo("2017-12-07 16:00");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldNotMatchOnDifferentTimesTooLate() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setFrom("2017-12-07 15:00");
        firstDesire.setTo("2017-12-07 16:00");
        secondDesire.setFrom("2017-12-07 14:00");
        secondDesire.setTo("2017-12-07 15:00");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldNotMatchOnNotEnoughPeople() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setTotal("4");
        firstDesire.setRequired("2");
        secondDesire.setTotal("4");
        secondDesire.setRequired("3");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldNotMatchOnTooMuchPeople() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        firstDesire.setTotal("4");
        firstDesire.setRequired("2");
        secondDesire.setTotal("4");
        secondDesire.setRequired("1");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }

    @Test
    public void shouldMatchTwoDesires() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(secondDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNotNull(match);
        Assert.assertEquals(match.getPlace(), "miejsce");
        Assert.assertEquals(match.getDesires().size(), 2);
        Assert.assertTrue(match.getDesires().contains(firstDesire));
        Assert.assertTrue(match.getDesires().contains(secondDesire));
        // TODO: require proper "from" and "to" based on business logic
    }

    @Test
    public void shouldMatchThreeDesires() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();
        DesireTO thirdDesire = createDefaultSecondDesire();

        firstDesire.setTotal("4");
        secondDesire.setTotal("4");
        thirdDesire.setTotal("4");

        firstDesire.setRequired("2");
        secondDesire.setRequired("1");
        thirdDesire.setRequired("1");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);
        desireService.handleIncomingDesire(secondDesire.getStakeholder(), secondDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(thirdDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNotNull(match);
        Assert.assertEquals(match.getPlace(), "miejsce");
        Assert.assertEquals(match.getDesires().size(), 3);
        Assert.assertTrue(match.getDesires().contains(firstDesire));
        Assert.assertTrue(match.getDesires().contains(secondDesire));
        Assert.assertTrue(match.getDesires().contains(thirdDesire));
        // TODO: require proper "from" and "to" based on business logic
    }

    @Test
    public void shouldMatchTwoOutOfThreeDesires() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();
        DesireTO thirdDesire = createDefaultSecondDesire();

        firstDesire.setTotal("4");
        secondDesire.setTotal("4");
        thirdDesire.setTotal("4");

        firstDesire.setRequired("2");
        secondDesire.setRequired("1");
        thirdDesire.setRequired("2");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);
        desireService.handleIncomingDesire(secondDesire.getStakeholder(), secondDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(thirdDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNotNull(match);
        Assert.assertEquals(match.getPlace(), "miejsce");
        Assert.assertEquals(match.getDesires().size(), 2);
        Assert.assertTrue(match.getDesires().contains(firstDesire));
        Assert.assertFalse(match.getDesires().contains(secondDesire));
        Assert.assertTrue(match.getDesires().contains(thirdDesire));
        // TODO: require proper "from" and "to" based on business logic
    }

    @Test
    public void shouldNotMatchThreeDesires() {
        DesireTO firstDesire = createDefaultFirstDesire();
        DesireTO secondDesire = createDefaultSecondDesire();
        DesireTO thirdDesire = createDefaultSecondDesire();

        firstDesire.setTotal("4");
        secondDesire.setTotal("4");
        thirdDesire.setTotal("4");

        firstDesire.setRequired("1");
        secondDesire.setRequired("1");
        thirdDesire.setRequired("1");

        desireService.handleIncomingDesire(firstDesire.getStakeholder(), firstDesire);
        desireService.handleIncomingDesire(secondDesire.getStakeholder(), secondDesire);

        AlgorithmResultDS algorithmResult = algorithmService.calculateBasedOnIncoming(thirdDesire);
        MatchTO match = algorithmResult.getCreatedMatch();

        Assert.assertNull(match);
    }
}
