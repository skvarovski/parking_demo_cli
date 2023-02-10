import java.lang.Exception

enum class Commander(val cmd: String) {
    START("/start"),
    HELP("/help"),
    PARK("/park"),
    RETURN("/return"),
    SHOW_PARKING("/show_parking"),
    SHOW_STATS("/show_stats"),
    END("/end"),
    ERROR("/error");

    companion object {

        private fun find(value: String?): Commander? = values().firstOrNull { it.cmd == value }

        fun get(value: String?): Commander = find(value) ?: ERROR

    }

}