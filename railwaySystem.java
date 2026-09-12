import java.util.*;

class Ticket {
    int ticketNo;
    String customerName;

    Ticket(int ticketNo, String customerName) {
        this.ticketNo = ticketNo;
        this.customerName = customerName;
    }
}

public class RailwaySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // FIFO Queue
        Queue<String> waitingQueue = new LinkedList<>();

        // Stores all issued tickets
        ArrayList<Ticket> issuedTickets = new ArrayList<>();

        // Stores cancelled tickets
        Stack<Ticket> cancelledTickets = new Stack<>();

        int ticketNumber = 1;
        int choice;

        do {

            System.out.println("\n====== Railway Reservation System ======");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Cancel Last Ticket");
            System.out.println("4. Display Waiting Queue");
            System.out.println("5. Display Issued Tickets");
            System.out.println("6. Display Cancelled Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    waitingQueue.offer(name);

                    System.out.println(name + " added to waiting queue.");
                    break;

                case 2:

                    if (waitingQueue.isEmpty()) {
                        System.out.println("No customers waiting.");
                        break;
                    }

                    String customer = waitingQueue.poll();

                    Ticket ticket = new Ticket(ticketNumber++, customer);

                    issuedTickets.add(ticket);

                    System.out.println("Ticket Issued Successfully");
                    System.out.println("Ticket No : " + ticket.ticketNo);
                    System.out.println("Customer  : " + ticket.customerName);

                    break;

                case 3:

                    if (issuedTickets.isEmpty()) {
                        System.out.println("No tickets available to cancel.");
                        break;
                    }

                    Ticket cancelled = issuedTickets.remove(issuedTickets.size() - 1);

                    cancelledTickets.push(cancelled);

                    System.out.println("Ticket Cancelled");
                    System.out.println("Ticket No : " + cancelled.ticketNo);
                    System.out.println("Customer  : " + cancelled.customerName);

                    break;

                case 4:

                    if (waitingQueue.isEmpty())
                        System.out.println("Waiting Queue Empty");
                    else
                        System.out.println("Waiting Queue : " + waitingQueue);

                    break;

                case 5:

                    if (issuedTickets.isEmpty()) {
                        System.out.println("No Issued Tickets");
                    } else {

                        System.out.println("\nIssued Tickets");

                        for (Ticket t : issuedTickets) {

                            System.out.println(
                                    "Ticket No : " + t.ticketNo +
                                    " | Customer : " + t.customerName);
                        }
                    }

                    break;

                case 6:

                    if (cancelledTickets.isEmpty()) {
                        System.out.println("No Cancelled Tickets");
                    } else {

                        System.out.println("\nCancelled Tickets");

                        for (Ticket t : cancelledTickets) {

                            System.out.println(
                                    "Ticket No : " + t.ticketNo +
                                    " | Customer : " + t.customerName);
                        }
                    }

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
