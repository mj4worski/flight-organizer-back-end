package flight;


public final class FlightDto {
    private final   Long id;
    private final String departureFrom;
    private final String arrivalTo;

    public FlightDto(Long id, String departureFrom, String arrivalTo) {
        this.id = id;
        this.departureFrom = departureFrom;
        this.arrivalTo = arrivalTo;
    }

    public Long getId() {
        return id;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public String getArrivalTo() {
        return arrivalTo;
    }

}
