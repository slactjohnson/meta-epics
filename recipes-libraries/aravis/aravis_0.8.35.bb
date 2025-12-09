SUMMARY = "aravis recipe"
DESCRIPTION = "Builds aravis, a library for genicam based cameras"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRCREV = "ea4f3c47cb387d81b63444887f3e0efda7918d50"
SRC_URI = "git://github.com/AravisProject/aravis;protocol=https;branch=aravis-0-8;rev=${SRCREV}"

S = "${WORKDIR}/git"

inherit meson

DEPENDS += "zlib libxml2 glib-2.0 libusb1 pkgconfig pkgconfig-native"

EXTRA_OEMESON += "-Dgst-plugin=disabled -Dviewer=disabled"