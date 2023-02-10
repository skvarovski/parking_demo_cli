object Parking {


    private const val parkingSize = 2
    var parkingList = mutableMapOf<String,Car?>()

    fun createParking(): MutableMap<String, Car?> {
        for (i in 1 .. parkingSize) {
            parkingList.put("P$i", null)
        }

        return parkingList
    }

    fun getParkingFreePlace(): String? {
        return parkingList.filterValues { it == null }.keys.firstOrNull()
    }


}