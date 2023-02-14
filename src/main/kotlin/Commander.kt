import java.lang.Exception

/**
 *  Класс в котором хранятся все доступные команды
 */

enum class Commander(val cmd: String) {
    START("/start"),
    HELP("/help"),
    END("/end"),
    ERROR("/error");

    companion object {

        private fun find(value: String?): Commander? = values().firstOrNull { it.cmd == value }

        fun get(value: String?): Commander = find(value) ?: ERROR

    }

}