import java.util.Scanner

fun main(args: Array<String>) {


    //val scanner = Scanner(System.`in`)
    //val manager = ManagerService()
    println("Добро пожаловать в систему учёта парковки автомобилей")
    startParking()

}

private fun startParking() {
    val scanner = Scanner(System.`in`)
    val manager = ManagerService()

    while (scanner.hasNextLine()) {

        val command = scanner.nextLine()

        if (command.isNullOrEmpty()) {
            println("Пустая команда, повторите ...")
            continue
        }

        val cmd = command.toString().split(" ")

        when (Commander.get(cmd[0])) {
            Commander.HELP -> {
                println("help command")
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


            Commander.END -> {
                println("Завершение работы.")
                break
            }

            Commander.ERROR -> println("Команда не найдена, пожалуйста обратитесь к документации или наберите /help")

        }


    }

}
private fun verifityCommand(cmd: List<String>, size: Int) = cmd.size == size


