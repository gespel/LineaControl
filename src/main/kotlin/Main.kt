package main.kotlin

fun main(args: Array<String>) {
    val m = LineaControl()
    val sleeptime: Long = 3000
    while (true) {
        m.setGain(Channel.InA, -3f)
        m.setMute(Channel.InA, true)
        m.setEq(Channel.Out1, 1, 440.0f, -3f, 1f)
        m.getInputMeter(Channel.InA)
        Thread.sleep(sleeptime)
        /*m.setMute(Channel.A, false)
        m.setMute(Channel.B, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.B, false)
        m.setMute(Channel.C, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.C, false)
        m.setMute(Channel.D, true)
        Thread.sleep(sleeptime)
        m.setMute(Channel.D, false)*/
    }
}
