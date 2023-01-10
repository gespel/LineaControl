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
        var recv: String? = n.sendToDeviceAndReceive("\$GET $channel/Meter\r")
        return 0.0f
    }
    fun downloadDeviceSettings(): DeviceSettings {
        var inC = arrayOf(
            InputChannel(Channel.InA,0.0f),
            InputChannel(Channel.InB,0.0f),
            InputChannel(Channel.InC,0.0f),
            InputChannel(Channel.InD,0.0f)
        )
        var outC = arrayOf(
            OutputChannel(Channel.Out1, arrayOf(
                EqSetting(440.0f, -3f, 1.0f),
                EqSetting(880f, -3f, 1f)
            ), -3f),
        )
        var out = DeviceSettings("Test", "127.0.0.1", inC, outC)
        return out
    }
}