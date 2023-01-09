package main.kotlin

fun main(args: Array<String>) {
    var m = LineaControl()
    var sleeptime: Long = 300
    while (true) {
        m.setMute(Channel.A, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.A, false)
        m.setMute(Channel.B, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.B, false)
        m.setMute(Channel.C, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.C, false)
        m.setMute(Channel.D, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.D, false)
    }
}
