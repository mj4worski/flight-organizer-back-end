package flight;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
class Flight implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    Long id;

    @Column
    private String departureFrom;
    @Column
    private String arrivalTo;

    protected Flight() {
    }

    FlightDto toDto() {
        return new FlightDto(id, departureFrom, arrivalTo);
    }
}
