package lineacontrol.core

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class Networking(ip: String) {
    var port: Int = 51456
    var ip: String = ip
    var verbose: Boolean = false
    private val socket = Socket(ip, 51456)
    private val dout = socket.getOutputStream()
    val inp = BufferedReader(InputStreamReader(socket.getInputStream()))

    fun setNetworkVerbosity(verbose: Boolean) {
        this.verbose = verbose
    }
    fun sendToDevice(input: String) {
        println("[INFO][$ip:$port] Sending to device:\n$input")
        try {
            dout.write(input.toByteArray())
        }
        catch (e: Exception) {
            println("[ERROR] paket could not be sent to device!")
        }
    }
    fun sendToDeviceAndReceive(input: String): String {
        if(this.verbose) {
            println("[INFO][$ip:$port] Sending to device:\n$input")
        }
        var receivedMessage: String
        try {
            dout.write(input.toByteArray())
            receivedMessage = inp.readLine()
            if(this.verbose) {
                println("[INFO][$ip:$port] Received message: $receivedMessage")
            }
        }
        catch (e: Exception) {
            println("[ERROR] paket could not be sent to device!")
            receivedMessage = null.toString()
        }
        return receivedMessage
    }
    fun closeConnection() {
        dout.close()
        socket.close()
    }
}