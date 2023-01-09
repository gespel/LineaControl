package main.kotlin

class LineaControl {
    var n = Networking("127.0.0.1")
    fun setMute(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Mute $sendValue")
    }
    fun setGain(channel: Channel, value: Float) {
        n.sendToDevice("\$SET $channel/Gain $value dB")
    }
    fun reversePolarity(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Pol $sendValue")
    }
    fun setEq(channel: Channel, eqNumber: Int, freq: Float, gain: Float, q: Float) {
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Freq $freq")
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Gain $gain")
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Q $q")
    }
}