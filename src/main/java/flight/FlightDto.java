package flight;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class FlightDto {
    private final   Long id;
    private final String departureFrom;
    private final String arrivalTo;

    FlightDto(Long id, String departureFrom, String arrivalTo) {
        this.id = id;
        this.departureFrom = departureFrom;
        this.arrivalTo = arrivalTo;
    }
}
