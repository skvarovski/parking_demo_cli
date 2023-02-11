import java.util.Scanner

/** part #1
 * Программа при вводе в консоль /start выводит приветствие в консоль
 *
 * При вводе /help выводит информацию о доступных командах "/start, /end" и их описание
 *
 * При вводе любых других данных выводить, что программа не может обработать запрос и предложить вызвать /help
 *
 * При вводе /end программа прощается с пользователем и завершает свою работу
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
