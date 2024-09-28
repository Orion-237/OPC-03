
class Room (val num: Int, val type: String, var price: Double){
    var isBooked: Boolean = false
    var reservationDuration: Int = 0

    fun reserationPrice() = reservationDuration * price

    fun bookRoom(duration: Int){
        if (isBooked) throw Exception("Already booked")
        else reservationDuration = duration
    }

    fun cancelBooking(){
        isBooked = false
        reservationDuration = 0
    }

    override fun toString(): String {
        return "\t\tNumber: $num\tType: $type\tStatus: ${if (!isBooked)"Available" else "Booked for ${reservationDuration} nights"}"
    }
}


// Hotel class to manage rooms and reservations
class Hotel {
    // List of rooms
    var rooms: MutableMap<Int ,Room> = mutableMapOf()

    var numRooms: Int = 0
        get() = rooms.size

    fun addRoom(num: Int, type: String, price: Double){
        rooms += num to Room(num, type, price)
    }

    fun bookRoom(roomNumber: Int, duration: Int){
        try {
            rooms[roomNumber]?.bookRoom(duration)
        } catch (e: Exception){
            println(e.message)
        }
    }

    fun cancelReservation(roomNumber: Int){
        try{
            rooms[roomNumber]?.cancelBooking()
        } catch (e: Exception){
            println(e.message)
        }
    }

    fun reservedRooms() = rooms.filter { it.value.isBooked }

    fun freeRooms() = rooms.filter { !it.value.isBooked }
}

var soleilRoyal = Hotel()

fun showMenu(options: List<String>){
    options.forEachIndexed { index, s -> println("\t\t${index+1}) $s") }
}

fun makeReservation(){
    val availableRooms = soleilRoyal.freeRooms().values
    if (availableRooms.isNotEmpty()){
        println("\n\n\t\tAvailable rooms")
        availableRooms.forEach{ println(it.toString())}
        print("Enter room number: ")
        var num = readln().toInt()
        println("For how many nights?: ")
        var duration = readln().toInt()
        try {
            soleilRoyal.bookRoom(num, duration)
        }catch (e: Exception){
            println(e.message)
        }
    }
    else {
        println("\tNO ROOM AVAILABLE!!!")
        readln()
    }
}

fun cancelReservation(){
    val bookedRooms = soleilRoyal.reservedRooms().values
    if (bookedRooms.isNotEmpty()){
        println("\n\n\t\tBooked rooms")
        bookedRooms.forEach{ println(it.toString())}
        print("Enter room number: ")
        var num = readln().toInt()
        soleilRoyal.cancelReservation(num)
    }
    else {
        println("\tNO ROOM BOOKED!!!")
        readln()
    }
}

fun showRooms(){
    soleilRoyal.rooms.values.forEach { println(it.toString()) }
}

fun addRoom(){
    var new: Int = 0
    var newType: String = ""
    var newPrice: Double = 0.0
    while (new <= 0){
        print("\t\tEnter new room number: ")
        try {
            new = readln().toInt()
        }catch (e: Exception){
            println("Only positive numbers! ")
            continue
        }
        if (new in soleilRoyal.rooms.keys){
            println("Room number already exist!!!")
        }else{
            print("\t\tEnter new room type (Simple, Double, Suite): ")
            newType = readln()
            print("\t\tEnter new room price: ")
            newPrice = readln().toDouble()
            break
        }
    }
    soleilRoyal.addRoom(new, newType, newPrice)
}


fun main(){
    for (i in 1 .. 9){
        soleilRoyal.addRoom(i, "Simple", 30000.0)
    }
    for (i in  10.. 19){
        soleilRoyal.addRoom(i, "Double", 50000.0)
    }
    for (i in 20 .. 29){
        soleilRoyal.addRoom(i, "Suite", 80000.0)
    }

    var menuOptions = listOf(
        "Make a reservation",
        "Cancel a reservation",
        "See available rooms",
        "Add room",
        "Exit"
    )

    var choice = 0
    while (true){
        println("\t\t=============================")
        println("\t\tWelcome to Soleil Royal hotel")
        println("\t\t=============================")
        showMenu(menuOptions)
        print("\n\t\tYour choice: ")

        choice = readln().toInt()
        when(choice){
            1 -> makeReservation()
            2 -> cancelReservation()
            3 -> showRooms()
            4 -> addRoom()
            5 -> break
        }
    }
}
