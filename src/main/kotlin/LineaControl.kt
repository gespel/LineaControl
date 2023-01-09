package main.kotlin

class LineaControl {
    var n = Networking()
    fun setMute(channel: Channel, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        n.sendToDevice("127.0.0.1", 51456,"\$SET In$channel/Mute $sendValue")
    }
    fun get() {

    }
}