inherit epics-module

SUMMARY = "EPICS linStat recipe"
DESCRIPTION = "Recipe for building the linStat module for the EPICS control system."

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"
LICENSE_PATH += "${S}"

SRCREV = "aadfce42bbfe1d80849f11f257382bb13b85e6f1"
SRC_URI = "git://github.com/mdavidsaver/linstat;protocol=https;branch=master;rev=${SRCREV}"

do_compile() {
    # HACK: Current version of linStat is broken with the 'build' rule. Specifically, the TOOLCHAIN Makefile is only generated during install
    # Remove me once that is fixed upstream.
    echo "Hello, I do nothing"
}

S = "${WORKDIR}/git"
