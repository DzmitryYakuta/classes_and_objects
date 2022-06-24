import kotlin.random.Random

class TV(brand: String, model: String, diagonalSize: Int) {

    var turnOn = false
        private set

    fun turnOnOff() {
        turnOn != turnOn
        if (turnOn) println("TV on") else println("TV off")
    }

    private val channelList = MutableList<String>(20) { it -> "Channel №${it + 1}" }
    private val numberOfChannel = Random.nextInt(1, 20)
    private val shuffledChannelList by lazy { channelList.shuffled() }
    private val finalChannelList = shuffledChannelList.take(numberOfChannel)

    fun showListChannel() {
        println(finalChannelList.size)
        finalChannelList.forEachIndexed { index, value -> println("${index + 1} - $value") }
    }

    var currentVolume = 0
    var numberOfCurrentChannel = 0

    fun volumeUp(stepVolume: Int) {
        val volumeNow = currentVolume + stepVolume
        currentVolume = if (volumeNow <= maxVolume) volumeNow else maxVolume
        println("Volume level now is $currentVolume")
    }

    fun volumeDown(stepVolume: Int) {
        currentVolume = maxOf(0, currentVolume - stepVolume)
        println("Volume level now is $currentVolume")
    }

    fun channelSwitching(numberChannel: Int) {
        if (!turnOn) turnOnOff()
        println("${channelList[numberChannel]} is On")
        numberOfCurrentChannel = numberChannel
    }

    fun channelSwitchUp() {
        if (!turnOn) turnOnOff()
        numberOfCurrentChannel = if (numberOfCurrentChannel + 1 >= channelList.size) 0 else numberOfCurrentChannel + 1
        println("${channelList[numberOfCurrentChannel]} is On")
    }

    fun channelSwitchDown() {
        if (!turnOn) turnOnOff()
        numberOfCurrentChannel =
            if (numberOfCurrentChannel - 1 < 0) channelList.size - 1 else numberOfCurrentChannel - 1
        println("${channelList[numberOfCurrentChannel]} is On")
    }

    companion object {
        const val maxVolume = 100
    }
}