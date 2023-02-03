package main.kotlin

fun main(args: Array<String>) {
    val m = LineaControl()
    val sleeptime: Long = 200
    while (true) {
        //m.setMute(Channel.Out1, true)
        //m.setGain(Channel.InA, -2.0f)
        m.sendCommandAndReceive("\$GET Out1/Meter")
        m.sendCommandAndReceive("\$SET OUT1/GAIN 0.0")
        m.unmuteAllInputs()
        m.unmuteAllOutputs()
        //m.getInputMeter(Channel.InA)
        Thread.sleep(sleeptime)
        //m.setDelay(Channel.Out1, 20.0f)
        //m.setMute(Channel.Out1, false)
        //m.setGain(Channel.InA, 2.0f)
        m.muteAllInputs()
        m.muteAllOutputs()
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
