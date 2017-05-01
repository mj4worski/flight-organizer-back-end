package flight;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Flight implements Serializable{

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

    public Flight(String departureFrom, String to) {
        this.departureFrom = departureFrom;
        this.arrivalTo = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getArrivalTo() {
        return arrivalTo;
    }

    public void setArrivalTo(String arrivalTo) {
        this.arrivalTo = arrivalTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureFrom, flight.departureFrom) &&
                Objects.equals(arrivalTo, flight.arrivalTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureFrom, arrivalTo);
    }
}
