package main.kotlin

class Networking {
    fun sendToDevice(ip: String, port: Int, input: String) {
        /*val socket = Socket(ip, 51456)
        val dout = DataOutputStream(socket.getOutputStream())*/
        println("[$ip:$port] Sending to device:\n$input")
        //dout.writeUTF(input)
        //dout.flush()
        //dout.close()
        //socket.close()
    }
}