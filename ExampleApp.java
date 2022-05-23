import java.util.*;

class Train {
    int number;
    String name;
    int NO_OF_COACHS;
    List<Coach> coachs;
}
class Coach {
    // coach size
    int number;
    int NO_OF_SEATS;
    List<Seat> seats;
}
class Seat {
    int number;
    BERTH_TYPE berth_type;
}
class SharedSeat extends Seat {

}
enum BERTH_TYPE {
    LOWER, MIDDLE, UPPER,
    SIDE_UPPER, SIDE_LOWER; 
}
class Passenger {
    String name;
    int age;
    Seat seat;

    // for reverse lookup
    String pnr;
}
class Ticket {
    String pnr;
    List<Passenger> passenger;
}

public class ExampleApp {

    int MAX_AVAILABLE;
    List<Seat> AVAILABLE_SEATS;

    int MAX_RAC;
    Queue<Passenger> RAC_PASSENGERS;

    int MAX_WL;
    Queue<Passenger> WAITING_LIST_PASSENGERS;

    // pnr number to ticket mapping 
    Map<String, Ticket> ALL_TICKETS;


    // in cancel ticket function
    // when a ticket is cancelled
    // check deque from RAC and enque 
}
