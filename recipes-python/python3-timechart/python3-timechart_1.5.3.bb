inherit pypi python_setuptools_build_meta

SUMMARY = "Time Chart Tool based on PyDM"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ed04a81f93145a8e913e64266452100"

PYPI_PACKAGE = "timechart"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-pydm \
    python3-numpy \
    python3-qtpy \
    python3-pyqtgraph \
    python3-six \
    \
    "

SRC_URI[sha256sum] = "95a2b0614577ccb0af92c0dc33a9466864509bcc31a1f95b52e4befc52004a48"

BBCLASSEXTEND = "native nativesdk"
