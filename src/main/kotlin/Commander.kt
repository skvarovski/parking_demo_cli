import java.lang.Exception

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