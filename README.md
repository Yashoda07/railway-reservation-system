# Railway Reservation System

A console-based Railway Reservation System developed using **Java**, **Object-Oriented Programming (OOP)**, and **Data Structures**. The system manages waiting customers, ticket issuance, and ticket cancellations through a simple menu-driven interface.

## Features

* Add customers to a waiting queue
* Serve customers using **FIFO (Queue)**
* Issue and store railway tickets
* Cancel the last issued ticket
* Store cancelled tickets using **LIFO (Stack)**
* Display waiting, issued, and cancelled tickets
* Menu-driven console interface

## Data Structures Used

| Data Structure | Purpose                              |
| -------------- | ------------------------------------ |
| **Queue**      | Manages waiting customers using FIFO |
| **ArrayList**  | Stores issued tickets                |
| **Stack**      | Stores cancelled tickets using LIFO  |

## OOP Concepts Used

* **Classes & Objects** – `Ticket` and `RailwayReservationSystem`
* **Constructors** – Initialize ticket and system objects
* **Encapsulation** – Ticket attributes are private and accessed through getters
* **Methods** – Separate methods handle reservation, cancellation, and display operations

## Technologies

* Java
* Object-Oriented Programming
* Data Structures
* Java Collections Framework

## How to Run

1. Clone the repository.
2. Open the project in a Java-supported IDE or terminal.
3. Compile the program:

```bash
javac RailwayReservationSystem.java
```

4. Run the program:

```bash
java RailwayReservationSystem
```

## Project Structure

```text
Railway-Reservation-System/
│
├── RailwayReservationSystem.java
└── README.md
```
