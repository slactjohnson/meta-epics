inherit pypi python_setuptools_build_meta

SUMMARY = "FontAwesome icons in PyQt and PySide applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2606b1a6778457da767700bc97388d63"

PYPI_PACKAGE = "qtawesome"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

SRC_URI[sha256sum] = "b2bf9351beb335095006892796f072ffd9755a2d7e5113dc71918dcd9ba4ef4a"

BBCLASSEXTEND = "native nativesdk"
