package main.kotlin

class Networking(ip: String) {
    var port: Int = 51456
    fun sendToDevice(input: String) {
        /*val socket = Socket(ip, 51456)
        val dout = DataOutputStream(socket.getOutputStream())*/
        println("[$this.ip:$port] Sending to device:\n$input")
        //dout.writeUTF(input)
        //dout.flush()
        //dout.close()
        //socket.close()
    }
}