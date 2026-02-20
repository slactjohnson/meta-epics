inherit slac-templated-ioc

SUMMARY = "SLAC ioc-common-bme280i2c recipe"
DESCRIPTION = "Recipe for building a SLAC templated BME280 IOC for the EPICS control system."

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=1e0e2c6c30de74e30aa6af57b7c31003"
LICENSE_PATH += "${S}"

# Remove slac-epics-iocadmin for now
EPICS_DEPENDS += "epics-autosave epics-asyn epics-calc epics-streamdevice-i2c epics-drvasyni2c"
DEPENDS += "${EPICS_DEPENDS}"

SRCREV = "7699dd7003f2da6e08f5af73accad29792702e03"
SRC_URI = "git://git@github.com/slactjohnson/ioc-common-bme280I2C.git;protocol=ssh;branch=working;rev=${SRCREV}"

S = "${WORKDIR}/git"


# Deal with race conditions
#do_compile[number_threads] = "1"
#do_install[number_threads] = "1"
EXTRA_OEMAKE += "-j 1"
