package main.kotlin

class LineaControl {
    var n = Networking("192.168.2.133")
    fun setMute(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Mute $sendValue\r")
    }
    fun setGain(channel: Channel, value: Float) {
        n.sendToDevice("\$SET $channel/Gain ${value}dB\r")
        //n.sendToDevice("\$SET Out1/Gain ${value}dB\r")
    }
    fun setDelay(channel: Channel, value: Float) {
        n.sendToDevice("\$SET InA/Delay ${value}ms\r")
    }
    fun getVersion() {
        n.sendToDevice("\$GET Version\r")
    }
    fun sendCommandAndReceive(cmd: String): String {
        return n.sendToDeviceAndReceive(cmd + "\r")
    }
    fun getMeter() {
        n.sendToDevice("\$GET In2/Meter\r")
    }

    fun muteAllInputs() {
        this.setMute(Channel.InA, true)
        this.setMute(Channel.InB, true)
        this.setMute(Channel.InC, true)
        this.setMute(Channel.InD, true)
    }
    fun unmuteAllInputs() {
        this.setMute(Channel.InA, false)
        this.setMute(Channel.InB, false)
        this.setMute(Channel.InC, false)
        this.setMute(Channel.InD, false)
    }
    fun muteAllOutputs() {
        this.setMute(Channel.Out1, true)
        this.setMute(Channel.Out2, true)
        this.setMute(Channel.Out3, true)
        this.setMute(Channel.Out4, true)
        this.setMute(Channel.Out5, true)
        this.setMute(Channel.Out6, true)
        this.setMute(Channel.Out7, true)
        this.setMute(Channel.Out8, true)
    }

    fun unmuteAllOutputs() {
        this.setMute(Channel.Out1, false)
        this.setMute(Channel.Out2, false)
        this.setMute(Channel.Out3, false)
        this.setMute(Channel.Out4, false)
        this.setMute(Channel.Out5, false)
        this.setMute(Channel.Out6, false)
        this.setMute(Channel.Out7, false)
        this.setMute(Channel.Out8, false)
    }
    fun reversePolarity(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("\$SET $channel/Pol $sendValue\r")
    }
    fun setEq(channel: Channel, eqNumber: Int, freq: Float, gain: Float, q: Float) {
        //n.sendToDevice("\$SET $channel/Eq${eqNumber}Freq $freq Hz\r")
        n.sendToDevice("\$SET $channel/Eq${eqNumber}Gain ${gain}dB\r")
        //n.sendToDevice("\$SET $channel/Eq${eqNumber}Q $q\r")
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