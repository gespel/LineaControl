package main.kotlin

class Networking {
    fun sendToDevice(input: String, ip: String) {
        /*val socket = Socket(ip, 51456)
        val dout = DataOutputStream(socket.getOutputStream())*/
        println("$ip : Sending to device:\n$input")
        //dout.writeUTF(input)
        //dout.flush()
        //dout.close()
        //socket.close()
    }
}