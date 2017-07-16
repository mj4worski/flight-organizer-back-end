package flight;

import infrastructure.FlightOrganizerApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlightOrganizerApplication.class})
@Sql("/FindServiceIntTest.sql")
public class FindServiceIntTest {

    @Autowired
    private FindService objectUnderTest;

    @Test
    public void whenFlightDoesntExist_thenResultListIsEmpty() {
        //when
        List<FlightDto> flights = objectUnderTest.findExistingFlights("Cracow", "Warsow");
        //then
        Assert.assertTrue(flights.isEmpty());
    }

    @Test
    public void whenFlightIsMatched_thenResulstIsOne() {
        //when
        List<FlightDto> flights = objectUnderTest.findExistingFlights("Warsow", "Cracow");
        //then
        Assert.assertEquals(1, flights.size());
    }
}