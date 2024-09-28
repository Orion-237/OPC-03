enum class TypeChambre {
    simple, double, suite
}

data class Chambre(
    val numero: Int,
    val type: TypeChambre,
    val prixParNuit: Double,
    var disponibilite: Boolean = true
)

data class Reservation(
    val id: Int,
    val chambre: Chambre,
    val nuits: Int
)

class Hotel {
    public val chambres = mutableListOf<Chambre>()
    public val reservations = mutableListOf<Reservation>()
    public var idReservationCounter = 1

    fun ajouterChambre(numero: Int, type: TypeChambre, prixParNuit: Double) {
        chambres.add(Chambre(numero, type, prixParNuit))
    }

    fun faireReservation(numeroChambre: Int, nuits: Int): Int? {
        val chambre = chambres.find { it.numero == numeroChambre && it.disponibilite }
        if (chambre != null) {
            chambre.disponibilite = false
            val reservation = Reservation(idReservationCounter++, chambre, nuits)
            reservations.add(reservation)
            return reservation.id
        }
        return null 
    }
    
    fun afficherDisponibilite(type: TypeChambre): List<Chambre> {
        return chambres.filter { it.type == type && it.disponibilite }
    }
    
    fun calculerCout(reservationId: Int): Double? {
        val reservation = reservations.find { it.id == reservationId }
        if (reservation != null) {
            return reservation.chambre.prixParNuit * reservation.nuits
        }
        return null
    }
    
    fun annulerReservation(reservationId: Int): Boolean {
        val reservation = reservations.find { it.id == reservationId }
        if (reservation != null) {
            reservation.chambre.disponibilite = true
            reservations.remove(reservation)
            return true
        }
        return false
    }
    
}

fun main() {
    val hotel = Hotel()

    hotel.ajouterChambre(101, TypeChambre.simple, 100.0)
    hotel.ajouterChambre(102, TypeChambre.double, 150.0)
    hotel.ajouterChambre(201, TypeChambre.suite, 250.0)

    println("Chambres simples disponibles : ${hotel.afficherDisponibilite(TypeChambre.simple)}")

    val reservationId = hotel.faireReservation(101, 3)
    println("Reserver : $reservationId")

    val cout = hotel.calculerCout(reservationId!!)
    println("Cout total : $cout")

    hotel.annulerReservation(reservationId)
    println("Chambres simples disponibles après annulation : ${hotel.afficherDisponibilite(TypeChambre.simple)}")
}
