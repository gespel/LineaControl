package main.kotlin

data class DeviceSettings(var deviceName: String, val ip: String, var inputChannels: Array<InputChannel>, val outputChannels: Array<OutputChannel>) {

}
