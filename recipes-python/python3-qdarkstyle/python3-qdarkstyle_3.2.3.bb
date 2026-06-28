inherit pypi python_setuptools_build_meta

SUMMARY = "The most complete dark/light style sheet for C++/Python and Qt applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=5853d07295f06b810b88fb21825eed34"

PYPI_PACKAGE = "QDarkStyle"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

SRC_URI[sha256sum] = "0c0b7f74a6e92121008992b369bab60468157db1c02cd30d64a5e9a3b402f1ae"

BBCLASSEXTEND = "native nativesdk"
