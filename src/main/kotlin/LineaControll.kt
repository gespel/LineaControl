package main.kotlin

class LineaControll {
    fun setMute(channel: String, value: Boolean) {
        var sendValue = "no"
        if(value) {
            sendValue = "yes"
        }
        var n = Networking()
        n.sendToDevice("\$SET In$channel/Mute $sendValue", "127.0.0.1")
    }
    fun get() {

    }
}