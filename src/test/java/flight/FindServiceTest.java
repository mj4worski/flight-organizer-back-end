package flight;

import infrastructure.configuration.FlightOrganizerApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rest.dto.FlightDTO;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlightOrganizerApplication.class})
public class FindServiceTest {

    @Autowired
    private FindService objectUnderTest;

    @Before
    public void init() {
        objectUnderTest.saveFlight(new Flight("Warsow", "Cracow"));
        objectUnderTest.saveFlight(new Flight("Warsow", "Barcelona"));
    }

    @Test
    public void whenFlightDoesntExist_thenResultListIsEmpty() {
        //when
        List<FlightDTO> flights = objectUnderTest.findExistingFlights("Cracow", "Warsow");
        //then
        Assert.assertTrue(flights.isEmpty());
    }

    @Test
    public void whenFlightIsMatched_thenResulstIsOne() {
        //when
        List<FlightDTO> flights = objectUnderTest.findExistingFlights("Warsow", "Cracow");
        //then
        Assert.assertEquals(1, flights.size());
    }
}