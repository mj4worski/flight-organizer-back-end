package flight;

import configuration.DozerConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import rest.dto.FlightDTO;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {FindService.class , FlightRepository.class, DozerConfiguration.class})
public class FindServiceTest {

    @Autowired
    private FindService objectUnderTest;

    @Before
    public void init(){
        objectUnderTest.saveFlight(new Flight("Warsow" , "Cracow"));
        objectUnderTest.saveFlight(new Flight("Warsow" , "Barcelona"));
    }

    @Test
    public void whenFlightDoesntExist_thenResultListIsEmpty() {
        //when
        List<FlightDTO> flights = objectUnderTest.find("Cracow", "Warsow");
        //then
        Assert.assertTrue(flights.isEmpty());
    }

    @Test
    public void whenFlightIsMatched_thenResulstIsOne() {
        //when
        List<FlightDTO> flights = objectUnderTest.find("Warsow", "Cracow");
        //then
        Assert.assertEquals(1, flights.size());
    }
}