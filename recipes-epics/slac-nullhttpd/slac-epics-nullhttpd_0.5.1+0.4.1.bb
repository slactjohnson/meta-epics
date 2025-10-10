inherit epics-module

SUMMARY = "nullhttpd recipe"
DESCRIPTION = "Recipe for building SLAC's nullhttpd for the EPICS control system."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"
LICENSE_PATH += "${S}"

SRC_URI = "git://github.com/slac-epics/nullhttpd;branch=slac-master;protocol=https;rev=R0.5.1-0.4.1"

DEPENDS += "epics-base"

S = "${WORKDIR}/git"
