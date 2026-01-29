require streamdevice_2.8.26.inc

SUMMARY = "StreamDevice recipe with I2C support"
DESCRIPTION = "Recipe for building StreamDevice for the EPICS control system with patch for drvAsynI2C."

MODNAME = "epics-streamdevice"

PROVIDES += "epics-streamdevice"

SRC_URI += " \
    file://stream_drvasyni2c_2.8.20.patch \
"
