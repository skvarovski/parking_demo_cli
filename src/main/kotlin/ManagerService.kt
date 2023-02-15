/**
 * Менеджер управления парковкой на основе команд
 */

class ManagerService {

    private val parking = Parking
    private var countPark = 0

    init {
        parking.createParking()
    }


    fun parking(cmd: List<String>) {
        if (!verifityCommand(cmd, 6)) {
            println("Ошибка ввода данных, указывайте в формате: Марка, Цвет, Номер, Имя, Фамилия")
            return
        }
        val owner = Owner(
            cmd[4],
            cmd[5]
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
            countPark++

            println("Машина встала на парковку ${it.toString()}")

        }


    }

    fun parkInfoByCar(cmd: List<String>) {
        if (!verifityCommand(cmd, 2)) {
            println("Ошибка ввода данных, указывайте в формате: НомерАвто")
            return
        }

        val place = parking.parkingList.filterValues { it?.number == cmd[1] }.keys.firstOrNull()

        if (place.isNullOrEmpty()) {
            println("Парковочное место не найдено")
            return
        }

        println("Парковочное место автомобиля с номером ${cmd[1]} = $place")

    }

    fun parkInfoByPlace(cmd: List<String>) {
        if (!verifityCommand(cmd, 2)) {
            println("Ошибка ввода данных, указывайте в формате: ПарковочноеМесто")
            return
        }

        val place = parking.parkingList.filterKeys { it == cmd[1] }

        if (place.keys.firstOrNull().isNullOrEmpty()) {
            println("Нет такого парковочного места ${cmd[1]}")
            return
        }

        val car = place.values.firstOrNull()
        if (car == null) {
            println("На парковочном месте $cmd[1] нет автомобиля, оно пустое")
            return
        }

        println("На парковочном месте присуствует автомобиль ${car.brand} ${car.color} ${car.number}")
    }

    fun returnCar(cmd: List<String>) {
        if (!verifityCommand(cmd, 4)) {
            println("Некоректно введены данные, пожалуйста повторите: НомерАвто, Имя, Фамилию")
            return
        }

        val owner = Owner(
            cmd[2],
            cmd[3]
        )
        val car = parking.parkingList.filterValues { it?.number == cmd[1] }.values.firstOrNull()

        if (car?.owner != owner) {
            println("Эта машина не принадлежит владельцу")
            return
        }

        val place = parking.parkingList.filterValues { it == car }.keys.first()

        parking.parkingList[place] = null;

        println("Машина ${car.brand} владельца ${car.owner.firstName} ${car.owner.lastName} уезжает из паркинга")

    }

    fun showParkAllStats(cmd: List<String>) {
        if (!verifityCommand(cmd, 1)) {
            println("Некоректно введены данные, пожалуйста повторите")
            return
        }
        println("Количество машин, которые воспользовались парковкой = $countPark")
    }

    fun showParkStats(cmd: List<String>) {
        if (!verifityCommand(cmd, 1)) {
            println("Некоректно введены данные, пожалуйста повторите")
            return
        }

        val currentPark = parking.parkingList.filterValues { it !=null }.count()

        println("Количество занятых мест на парковсе = $currentPark")

    }

    private fun verifityCommand(cmd: List<String>, size: Int) = cmd.size == size


}