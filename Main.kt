

class Chambre( val numero: Int , val type : String, val prixNuitee : Double, var disponibilite : Boolean ){

    fun reserver() {
        disponibilite = false
    }

    fun liberer() {
        disponibilite = true
    }

}

class Reservation( val idReservation : Int, val chambre: Chambre, val nbNuit : Int)
{
    fun calculerCoutResrvation() : Double = chambre.prixNuitee * nbNuit
}

class Hotel(){
    // Creation de la liste des chambres propres a l'hotel
    private val chambres = mutableListOf<Chambre>()
    // Creation d'une Map de reservation pour un meilleur reperage dans celles-ci
    private val reservations = mutableMapOf<Int,Reservation>()

    private var idReservation = 0


    // ici ce sont les fonctions Basiques ein 🚶‍♂️
    fun ajouterChambre( numero: Int , type : String,  prixNuitee : Double){
        val chambre = Chambre(numero,type,prixNuitee,true)
        chambres.add(chambre)
    }

    fun afficheDisponibilteChambre(type : String) : List<Chambre> = chambres.filter { it.type == type && it.disponibilite }

    fun annulerReservation(numReservation : Int) {
        val reservation = reservations[numReservation]
        reservation?.chambre?.liberer()
        reservations.remove(numReservation)
    }

    // voilà la vraie fonction qui permet de reserver une chambre en fonction du type et du nombre de nuits 😭😭
    fun reserverChambre(type : String , nbNuit: Int) : Reservation? {
        // verification si la chambre est dispo
        val chambreDispo = chambres.find { it.type == type && it.disponibilite }
        // traitement si la chambre est dispo
        if (chambreDispo != null){
            chambreDispo.reserver()
            val reservation = Reservation(idReservation++, chambreDispo, nbNuit)
            reservations[reservation.idReservation] = reservation
            println("Numero de la reservation N* ${idReservation}")
            return reservation
        }else{
            return null
        }

    }
}

fun main() {
    val hotel = Hotel()

    while (true) {
        println("\n--- Menu de Gestion de l'Hôtel ---")
        println("1. Afficher disponibilité")
        println("2. Faire une réservation")
        println("3. Ajouter des chambres")
        println("4. Annuler une réservation")
        println("5. Quitter")
        print("Veuillez choisir une option (1-5) : ")

        when (readln().toInt()) {
            1 -> {
                // Afficher disponibilité
                println("Quel type de chambre souhaitez-vous voir (Simple, Double, Suite) ?")
                val type = readln()
                val chambresDisponibles = hotel.afficheDisponibilteChambre(type)
                if (chambresDisponibles.isNotEmpty()) {
                    println("Chambres disponibles pour le type $type :")
                    chambresDisponibles.forEach { println("Chambre numéro: ${it.numero}, Prix: ${it.prixNuitee}XAF") }
                } else {
                    println("Aucune chambre $type disponible.")
                }
            }

            2 -> {
                // Faire une réservation
                println("Quel type de chambre souhaitez-vous réserver (Simple, Double, Suite) ?")
                val type = readln()
                println("Combien de nuits voulez-vous réserver ?")
                val nbNuits = readln().toInt()

                val reservation = hotel.reserverChambre(type, nbNuits)
                if (reservation != null) {
                    println("Réservation réussie pour la chambre ${reservation.chambre.numero}. Coût total : ${reservation.calculerCoutResrvation()}€")
                } else {
                    println("Désolé, aucune chambre $type n'est disponible pour réservation.")
                }
            }

            3 -> {
                // Ajouter des chambres
                println("Numéro de la chambre :")
                val numero = readln().toInt()
                println("Type de chambre (Simple, Double, Suite) :")
                val type = readln()
                println("Prix par nuit pour cette chambre :")
                val prixParNuit = readln().toDouble()

                hotel.ajouterChambre(numero, type, prixParNuit)
                println("Chambre ajoutée avec succès !")
            }

            4 -> {
                // Annuler une réservation
                println("Numéro de réservation à annuler :")
                val numReservation = readln().toInt()

                hotel.annulerReservation(numReservation)
                println("Reservation annulee:")

            }

            5 -> {
                // Quitter
                println("Merci d'avoir utilisé le système de gestion de l'hôtel. Au revoir !")
                break
            }

            else -> println("Option invalide, veuillez réessayer.")
        }
    }
}


