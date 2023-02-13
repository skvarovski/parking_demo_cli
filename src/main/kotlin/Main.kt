import java.util.Scanner

/** part #2
 *
 * Необходимо создать основные структуры данных:
 *
 * Car, Owner, Parking, Manager, Command, возможно тебе понадобится что-то еще, не бойся создавать другие классы,
 * если считаешь это необходимым
 *
 * Необходимо определиться какая структура данных будет наиболее подходящей для каждой сущности, обосновать почему,
 * а так же добавить поля, необходимые для работоспособности программы
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
                if (verifityCommand(cmd, 7)) {
                    println("park command")
                    manager.parking(cmd)
                } else {
                    println("park command wrong")
                    continue
                }
            }

            Commander.SHOW_PARKING -> {
                println("show parking command")
                manager.showParking(cmd)
            }

            Commander.SHOW_STATS -> {
                println("show stats command")
                manager.showStats(cmd)
            }

            Commander.RETURN -> {
                println("return command")
            }


            Commander.ERROR -> println("Команда не найдена, пожалуйста обратитесь к документации или наберите /help")
            else -> println("Команда не найдена, пожалуйста обратитесь к документации или наберите /help")

        }


    }

}
private fun verifityCommand(cmd: List<String>, size: Int) = cmd.size == size

private fun helpInfo(): String {
    return "Доступные команды для управления \n" +
            "/start - запуск программы\n" +
            "/end - завершения программы\n" +
            "/help - справка по командам\n"
}
