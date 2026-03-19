# python3-qtpy_2.4.3.bb

inherit pypi python_setuptools_build_meta

SUMMARY = "QtPy, a Python abstraction layer for PySide2/PyQt5/PyQt6/PySide6"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b2830f54500be1314b9ec6096989f983"

PYPI_PACKAGE = "qtpy"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-packaging-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-packaging \
    "

SRC_URI[sha256sum] = "db744f7832e6d3da90568ba6ccbca3ee2b3b4a890c3d6fbbc63142f6e4cdf5bb"

BBCLASSEXTEND = "native nativesdk"

