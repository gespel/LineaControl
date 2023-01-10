package main.kotlin

import java.io.DataOutputStream
import java.net.Socket

class Networking(ip: String) {
    var port: Int = 51456
    var ip: String = ip
    fun sendToDevice(input: String) {
        println("[INFO][$ip:$port] Sending to device:\n$input")
        try {
            val socket = Socket(ip, 51456)
            val dout = DataOutputStream(socket.getOutputStream())

            dout.writeUTF(input)
            dout.flush()
            dout.close()
            socket.close()
        }
        catch (e: Exception) {
            println("[ERROR] paket could not be sent to device!")
        }
    }
    fun sendToDeviceAndReceive(input: String): String? {
        try {
            println("[INFO][$ip:$port] Sending to device and waiting for response:\n$input")
            return ""
        }
        catch (e: Exception) {
            println("[ERROR] paket could not be sent to device!")
        }
        return null
    }
}