inherit pypi python_setuptools_build_meta

SUMMARY = "Sphinx extension to support docstrings in Numpy format"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=001c710c66ea2255830c601c2d2c24fb"

PYPI_PACKAGE = "numpydoc"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-sphinx \
    python3-numpy \
    \
    "

SRC_URI[sha256sum] = "3f7970f6eee30912260a6b31ac72bba2432830cd6722569ec17ee8d3ef5ffa01"

BBCLASSEXTEND = "native nativesdk"
