inherit pypi python_setuptools_build_meta

SUMMARY = "PCDS Python Utilities"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ed04a81f93145a8e913e64266452100"

PYPI_PACKAGE = "pcdsutils"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-prettytable \
    python3-pyyaml \
    python3-qtpy \
    python3-qtpyinheritance \
    python3-requests \
    python3-typing-extensions \
    \
    "

SRC_URI[sha256sum] = "10572df8ebf26608a0d27fbc0db2839990f243051295665d3cf324625aaa0406"

BBCLASSEXTEND = "native nativesdk"
