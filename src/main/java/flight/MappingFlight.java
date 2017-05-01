package flight;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.stereotype.Component;
import rest.dto.FlightDTO;

@Component
public class MappingFlight extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(Flight.class).accessible(true), FlightDTO.class,
                TypeMappingOptions.wildcard(true));
    }
}
