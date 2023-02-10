object Parking {


    private const val parkingSize = 2
    var parkingList = mutableMapOf<String,Car?>()

    fun createParking() {
        for (i in 1 .. parkingSize) {
            parkingList.put("P$i", null)
        }
    }

    fun getParkingFreePlace(): String? {
        return parkingList.filterValues { it == null }.keys.firstOrNull()
    }


}