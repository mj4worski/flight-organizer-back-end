package flight;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FindService.class)
public class FindServiceTest {

    @Autowired
    private FindService objectUnderTest;

    @Test
    public void whenFlightDoesntExist_thenResultListIsEmpty() {
        //when
        List<Flight> flights = objectUnderTest.find("Cracow", "Warsow");
        //then
        Assert.assertTrue(flights.isEmpty());
    }

    @Test
    public void whenFlightIsMatched_thenRestulstIsOne() {
        //when
        List<Flight> flights = objectUnderTest.find("Warsow", "Cracow");
        //then
        Assert.assertEquals(1, flights.size());
    }
}