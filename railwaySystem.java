import java.util.*;

// Represents a railway ticket
class Ticket {
    private int ticketNo;
    private String customerName;

    // Constructor
    public Ticket(int ticketNo, String customerName) {
        this.ticketNo = ticketNo;
        this.customerName = customerName;
    }

    // Getters - Encapsulation
    public int getTicketNo() {
        return ticketNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Ticket No : " + ticketNo +
               " | Customer : " + customerName;
    }
}


// Main Railway Reservation System
public class RailwayReservationSystem {

    // FIFO Queue - stores waiting customers
    private Queue<String> waitingQueue;

    // ArrayList - stores issued tickets
    private ArrayList<Ticket> issuedTickets;

    // LIFO Stack - stores cancelled tickets
    private Stack<Ticket> cancelledTickets;

    private int ticketNumber;


    // Constructor
    public RailwayReservationSystem() {
        waitingQueue = new LinkedList<>();
        issuedTickets = new ArrayList<>();
        cancelledTickets = new Stack<>();
        ticketNumber = 1;
    }


    // Add customer to waiting queue
    public void addCustomer(String customerName) {

        waitingQueue.offer(customerName);

        System.out.println(
            customerName + " added to waiting queue."
        );
    }


    // Serve customer and issue ticket
    public void serveCustomer() {

        if (waitingQueue.isEmpty()) {
            System.out.println("No customers waiting.");
            return;
        }

        // FIFO - first customer is served first
        String customerName = waitingQueue.poll();

        Ticket ticket = new Ticket(
            ticketNumber++,
            customerName
        );

        issuedTickets.add(ticket);

        System.out.println("\nTicket Issued Successfully");
        System.out.println(ticket);
    }


    // Cancel the most recently issued ticket
    public void cancelLastTicket() {

        if (issuedTickets.isEmpty()) {
            System.out.println("No tickets available to cancel.");
            return;
        }

        // Remove last issued ticket from ArrayList
        Ticket cancelledTicket =
            issuedTickets.remove(issuedTickets.size() - 1);

        // Push cancelled ticket into Stack
        cancelledTickets.push(cancelledTicket);

        System.out.println("\nTicket Cancelled");
        System.out.println(cancelledTicket);
    }


    // Display waiting customers
    public void displayWaitingQueue() {

        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting Queue Empty");
            return;
        }

        System.out.println("\nWaiting Queue:");

        for (String customer : waitingQueue) {
            System.out.println(customer);
        }
    }


    // Display all issued tickets
    public void displayIssuedTickets() {

        if (issuedTickets.isEmpty()) {
            System.out.println("No Issued Tickets");
            return;
        }

        System.out.println("\nIssued Tickets:");

        for (Ticket ticket : issuedTickets) {
            System.out.println(ticket);
        }
    }


    // Display cancelled tickets
    public void displayCancelledTickets() {

        if (cancelledTickets.isEmpty()) {
            System.out.println("No Cancelled Tickets");
            return;
        }

        System.out.println("\nCancelled Tickets:");

        // Stack follows LIFO
        for (int i = cancelledTickets.size() - 1; i >= 0; i--) {
            System.out.println(cancelledTickets.get(i));
        }
    }


    // Display menu
    public void displayMenu() {

        System.out.println("\n====== Railway Reservation System ======");
        System.out.println("1. Add Customer");
        System.out.println("2. Serve Customer");
        System.out.println("3. Cancel Last Ticket");
        System.out.println("4. Display Waiting Queue");
        System.out.println("5. Display Issued Tickets");
        System.out.println("6. Display Cancelled Tickets");
        System.out.println("7. Exit");
        System.out.print("Enter Choice: ");
    }


    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RailwayReservationSystem system =
            new RailwayReservationSystem();

        int choice;

        do {

            system.displayMenu();

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    system.addCustomer(name);
                    break;


                case 2:

                    system.serveCustomer();
                    break;


                case 3:

                    system.cancelLastTicket();
                    break;


                case 4:

                    system.displayWaitingQueue();
                    break;


                case 5:

                    system.displayIssuedTickets();
                    break;


                case 6:

                    system.displayCancelledTickets();
                    break;


                case 7:

                    System.out.println("Thank You!");
                    break;


                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 7);

        sc.close();
    }
}
