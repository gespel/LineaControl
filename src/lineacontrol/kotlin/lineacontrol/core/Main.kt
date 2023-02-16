package lineacontrol.core

fun main(args: Array<String>) {
    println("asd")
    val m = LineaControl("192.168.2.133", true)
    val sleeptime: Long = 200
    while (true) {
        //m.setMute(lineacontrol.core.Channel.Out1, true)
        //m.setGain(lineacontrol.core.Channel.InA, -2.0f)
        //m.sendCommandAndReceive("\$GET Out1/Meter")
        //m.sendCommandAndReceive("\$SET OUT1/GAIN 0.0")
        m.unmuteAllInputs()
        m.unmuteAllOutputs()
        //m.getInputMeter(lineacontrol.core.Channel.InA)
        Thread.sleep(sleeptime)
        //m.setDelay(lineacontrol.core.Channel.Out1, 20.0f)
        //m.setMute(lineacontrol.core.Channel.Out1, false)
        //m.setGain(lineacontrol.core.Channel.InA, 2.0f)
        m.muteAllInputs()
        m.muteAllOutputs()
        Thread.sleep(sleeptime)
        /*m.setMute(lineacontrol.core.Channel.A, false)
        m.setMute(lineacontrol.core.Channel.B, true)
        Thread.sleep(sleeptime)
        m.setMute(lineacontrol.core.Channel.B, false)
        m.setMute(lineacontrol.core.Channel.C, true)
        Thread.sleep(sleeptime)
        m.setMute(lineacontrol.core.Channel.C, false)
        m.setMute(lineacontrol.core.Channel.D, true)
        Thread.sleep(sleeptime)
        m.setMute(lineacontrol.core.Channel.D, false)*/
    }
}
