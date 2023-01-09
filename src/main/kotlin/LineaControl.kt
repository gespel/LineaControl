package main.kotlin

class LineaControl {
    var n = Networking("127.0.0.1")
    fun setMute(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Mute $sendValue\r")
    }
    fun setGain(channel: Channel, value: Float) {
        n.sendToDevice("\$SET $channel/Gain $value dB\r")
    }
    fun reversePolarity(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Pol $sendValue\r")
    }
    fun setEq(channel: Channel, eqNumber: Int, freq: Float, gain: Float, q: Float) {
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Freq $freq\r")
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Gain $gain\r")
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Q $q\r")
    }

    fun getInputMeter(channel: Channel): Float {
        var recv: String = n.sendToDeviceAndReceive("\$GET $channel/Meter\r")
        return 0.0f
    }
}