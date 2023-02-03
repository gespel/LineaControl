package main.kotlin

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Networking(ip: String) {
    var port: Int = 51456
    var ip: String = ip
    private val socket = Socket(ip, 51456)
    private val dout = socket.getOutputStream()
    val inp = BufferedReader(InputStreamReader(socket.getInputStream()))

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
        println("[INFO][$ip:$port] Sending to device:\n$input")
        var receivedMessage: String
        try {
            dout.write(input.toByteArray())
            receivedMessage = inp.readLine()
            println("Received message: $receivedMessage")
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