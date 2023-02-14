/**
 *  Класс в котором хранятся все доступные команды
 */

enum class Commander(val cmd: String) {
    START("/start"),
    HELP("/help"),
    PARK("/park"),
    PARK_INFO_BY_CAR("/park_info_by_car"),
    PARK_INFO_BY_PLACE("/park_info_by_place"),
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