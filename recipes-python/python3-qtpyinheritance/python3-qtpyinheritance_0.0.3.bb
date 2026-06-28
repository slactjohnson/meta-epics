inherit pypi python_setuptools_build_meta

SUMMARY = "Prototype qtpy inheritance-related tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4bd8aeacedfe94e3b325630f47691a06"

PYPI_PACKAGE = "qtpyinheritance"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-qtpy"

SRC_URI[sha256sum] = "86d4e2f4908971a74a1502e5ebd5fb4b319d11c75d64e72aa05ad7248d93b1da"

BBCLASSEXTEND = "native nativesdk"
