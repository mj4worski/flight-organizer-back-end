package rest.dto;

public class FlightDTO {
    private Long id;
    private String departureFrom;
    private String arrivalTo;

    private FlightDTO() {
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
}
