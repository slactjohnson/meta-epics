inherit pypi python_setuptools_build_meta

SUMMARY = "Automated User Interface Creation from Ophyd Devices"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ed04a81f93145a8e913e64266452100"

PYPI_PACKAGE = "typhos"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-packaging-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-coloredlogs \
    python3-entrypoints \   
    python3-lxml \
    python3-numpy \
    python3-numpydoc \
    python3-ophyd \
    python3-pcdsutils \
    python3-platformdirs \
    python3-pyqt5 \
    python3-pydm \
    python3-pyqtgraph \
    python3-qdarkstyle \
    python3-qtawesome \
    python3-qtpy \
    python3-timechart \
    \
    "

SRC_URI[sha256sum] = "77766ed86d02e86dbacb93f6b2cc64430075253bcf8abb6622c089c21cca2992"

BBCLASSEXTEND = "native nativesdk"
