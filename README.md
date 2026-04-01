# 113CSC-HotelProject
classDiagram
    class ComesWithDesignatedParking {
        <<interface>>
        +assignParking() void
    }

    class HotelSystem {
        -reservations : Reservation[]
        -numOfRes : int
        -customers : Customer[]
        +addReservation(r: Reservation) boolean
        +removeReservation(id: String) boolean
        +searchReservation(id: String) int
        +calculateTotalRevenue(index: int) double
    }

    class Date {
        -day : int
        -month : int
        -year : int
        +getDate() String
        +setDay(d: int) void
        +setMonth(m: int) void
        +setYear(y: int) void
    }

    class Customer {
        -name : String
        -phone : String
        +getName() String
        +getPhone() String
        +assignParking() void
    }

    class Reservation {
        <<abstract>>
        #resID : String
        #price : double
        #status : char
        #guest : Customer
        #date : Date
        +calculatePrice()* double
        +getGuest() Customer
        +getStatus() char
        +setStatus(s: char) void
    }

    class Room {
        <<abstract>>
        #beds : int
        #roomNumber : String
        #isOccupied : boolean
        #numberOfNights : int
        +checkIn() void
        +checkOut() void
        +calculatePrice() double
    }

    class EventSpace {
        <<abstract>>
        #maxCapacity : int
        #sizeInSqFt : int
        +calculatePrice() double
    }

    class RegularRoom {
        -hasMiniFridge : boolean
        +calculatePrice() double
    }

    class FamilyRoom {
        -hasKitchenette : boolean
        +addCot() void
        +calculatePrice() double
    }

    class Suite {
        -hasBalcony : boolean
        +calculatePrice() double
        +assignParking() void
    }

    class Lobby {
        +calculatePrice() double
    }

    class EventHall {
        +calculatePrice() double
    }

    Reservation <|-- Room 
    Reservation <|-- EventSpace 
    Room <|-- RegularRoom 
    Room <|-- FamilyRoom 
    Room <|-- Suite 
    EventSpace <|-- Lobby 
    EventSpace <|-- EventHall 

    ComesWithDesignatedParking <|.. Suite 
    ComesWithDesignatedParking <|.. Customer 

    HotelSystem *-- "*" Reservation 
    Reservation *-- "1" Date 
    
    HotelSystem o-- "*" Customer 
    Reservation o-- "1" Customer
