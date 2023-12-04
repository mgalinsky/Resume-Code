package com.company;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;

enum EngineType{Jet,Rocket,Electric,TurboProp,Piston};

public class FlightLab7 {
    ArrayList<Flight> fltarray = new ArrayList<>();
    ArrayList<AircraftType> airType = new ArrayList<>();


    class Flight {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        private String flightNumber;
        private String airline;
        private String origin;
        private AircraftType aircraftType;
        private String destination;
        private Date scheduledDeparture;
        private Date scheduledArrival;
        public String gate;

        public Flight(String flightNumber,
                      String airline,
                      String origin,
                      String destination,
                      Date scheduledDeparture,
                      Date scheduledArrival,
                      AircraftType aircraftType,
                      String gate){
            this.flightNumber = flightNumber;
            this.airline = airline;
            this.origin = origin;
            this.destination = destination;
            this.aircraftType = aircraftType;
            this.scheduledDeparture = scheduledDeparture;
            this.scheduledArrival = scheduledArrival;
            this.gate = gate;
        }
        public String toString(){
            return airline + " " + flightNumber + " " + origin + "/" + destination + " Departure: " + sdf.format(scheduledDeparture) +
                    " Arrival: " + sdf.format(scheduledArrival) + " " + aircraftType.toString() + " Gate: " + gate;
        }
    }

    static class AircraftType{
        public String manufacturer;
        public String model;
        public String typeDesignator;
        public EngineType engineType;
        public int engineNumber;

        public AircraftType(String manufacturer, String model, String typeDesignator, EngineType engineType, int engineNumber)
        {
            this.manufacturer = manufacturer;
            this.model = model;
            this.typeDesignator = typeDesignator;
            this.engineType = engineType;
            this.engineNumber = engineNumber;
        }
        public String toString(){
            return manufacturer + " " + model + " " + typeDesignator + " " + engineType + " EngType/Num: " + engineNumber;

        }

    }
    public void addAircraftType() {
        airType.add(new AircraftType("Boeing", "737-600", "B736", EngineType.Jet, 2));
        airType.add(new AircraftType("Boeing", "737-800", "B730", EngineType.Jet, 2));
        airType.add(new AircraftType("Airbus", "A-310", "A310", EngineType.Jet, 2));
        airType.add(new AircraftType("Airbus", "A-300B2", "A-340-500", EngineType.Jet, 2));
        airType.add(new AircraftType("Embraer", "A20", "E314", EngineType.TurboProp, 2));
        airType.add(new AircraftType("Embraer", "195", "E195", EngineType.Jet, 2));

    }
    public void addFlights() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy HH:mm");
        fltarray.add(new Flight("205", "AA", "PHL", "SVO", sdf.parse("1-28-2021 06:00"),
                sdf.parse("1-28-2021 18:30"), airType.get(0), "B20"));
        fltarray.add(new Flight("101", "DA", "PHL", "ATL", sdf.parse("1-28-2021 08:00"),
                sdf.parse("1-28-2021 11:30"), airType.get(2), "G30"));
        fltarray.add(new Flight("341", "AA", "PHL", "MDW", sdf.parse("1-28-2021 10:30"),
                sdf.parse("1-29-2021 12:30"), airType.get(3), "A11"));
        fltarray.add(new Flight("104", "DA", "PHL", "YYZ", sdf.parse("1-28-2021 04:30"),
                sdf.parse("1-29-2021 7:00"), airType.get(5), "A11"));
        fltarray.add(new Flight("341", "WW", "PHL", "ORD", sdf.parse("1-28-2021 09:30"),
                sdf.parse("1-29-2021 11:30"), airType.get(4), "A11"));
    }
    public void printFlights() {
        for (Flight flt : fltarray){
            System.out.println(flt);
        }
    }


    public static void main(String[] args) throws java.text.ParseException {
        FlightLab7 flight = new FlightLab7();
        flight.addAircraftType();
        ;
        flight.addFlights();
        flight.printFlights();

    }


}

