/**
 * Менеджер управления парковкой на основе команд
 */

class ManagerService {

    private val parking = Parking

    init {
        parking.createParking()
    }


    fun parking(cmd: List<String>) {
        val owner = Owner(
            cmd[5],
            cmd[6]
        )
        val car = Car(
            cmd[1],
            cmd[2],
            cmd[3],
            owner = owner
        )

        parking.getParkingFreePlace().let {
            if (it == null) println("нет свободных мест")

            parking.parkingList[it.toString()] = car

        }


    }

    fun showParking(command: List<String>) {

    }

    fun showStats(command: List<String>) {

    }


}