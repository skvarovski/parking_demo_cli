import java.util.Scanner

/** part #3
 *
 * Необходимо реализовать следующие функции и их логику
 *
 * /return -- возвращает автомобиль. Важно возвращать автомобиль только владельцу, если автомобиль запрашивает другой человек, возвращать ошибку
 * /park_info_by_car -- возвращает место, где припаркована машина, по ее номеру
 * /park_info_by_place -- возвращает информацию о машине по месту на парковке
 * /park -- паркует автомобиль на любое свободное место
 * /help -- дополнить справку информацией о новых функциях
 *
 */



fun main(args: Array<String>) {

    startParking()


}

private fun startParking() {
    val scanner = Scanner(System.`in`)
    val manager = ManagerService()

    while (scanner.hasNextLine()) {

        val command = scanner.nextLine()

        if (command.isNullOrEmpty()) {
            println("Пустая команда, повторите ввод или воспользуйтесь подсказкой /help")
            continue
        }

        val cmd = command.toString().split(" ")

        when (Commander.get(cmd[0])) {
            Commander.START -> {
                println("Вас приветствует программа парковки автомобилей. используйте /help для помощи")
            }
            Commander.HELP -> {
                println(helpInfo())
            }

            Commander.END -> {
                println("Завершение работы.")
                break
            }

            Commander.PARK -> {
                manager.parking(cmd)
            }

            Commander.PARK_INFO_BY_CAR -> {
                manager.parkInfoByCar(cmd)
            }

            Commander.PARK_INFO_BY_PLACE -> {
                manager.parkInfoByPlace(cmd)
            }

            Commander.SHOW_PARKING -> {
                manager.showParking(cmd)
            }

            Commander.SHOW_STATS -> {
                manager.showStats(cmd)
            }

            Commander.RETURN -> {
                manager.returnCar(cmd)
            }


            Commander.ERROR -> println("Команда не найдена, пожалуйста обратитесь к документации или наберите /help")

        }


    }

}

private fun helpInfo(): String {
    return "Доступные команды для управления \n" +
            "/start - запуск программы\n" +
            "/end - завершения программы\n" +
            "/help - справка по командам\n" +
            "/park - парковка автомобиля, через пробел указать: марку цвет номер имя фамилию\n" +
            "/park_info_by_car -- возвращает место, где припаркована машина, по ее номеру\n" +
            "/park_info_by_place -- возвращает информацию о машине по месту на парковке\n" +
            "/return -- возвращает автомобиль. Возвращает автомобиль только владельцу, " +
            "если автомобиль запрашивает другой человек - возвращается ошибка\n"

}
