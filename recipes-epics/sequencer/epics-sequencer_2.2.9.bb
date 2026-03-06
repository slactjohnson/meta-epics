inherit epics-module

SUMMARY = "Sequencer recipe"
DESCRIPTION = "Recipe for building the SNC sequencer for the EPICS control system."

LICENSE = "LICENSE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9738eff23564c3683d154e44cc154fbb"
LICENSE_PATH += "${S}"

SRCREV = "13bc466e940e0211bfc2da5523108bbe1d610fca"
SRC_URI = "git://github.com/epics-modules/sequencer;protocol=https;branch=main;rev=${SRCREV} \
           file://0001-Allow-inclusion-of-local-RELEASE-and-CONFIG_SITE.patch \
           "

DEPENDS += "${EPICS_DEPENDS} lemon re2c"

S = "${WORKDIR}/git"
