package configuration;

import flight.MappingFlight;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"flight"})
public class DozerConfiguration {

    @Bean
    public DozerBeanMapper dozerBeanMapper(MappingFlight mappingFlight) {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(mappingFlight);
        return dozerBeanMapper;
    }
}
