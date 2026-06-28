inherit pypi python_setuptools_build_meta

SUMMARY = "Bluesky hardware abstraction with an emphasis on EPICS"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23fab1058ddd7a57693c400266eaaed7"

PYPI_PACKAGE = "ophyd"

PEP517_BUILD_API = "setuptools.build_meta"

DEPENDS += "python3-tomli-native python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-networkx \
    python3-numpy \
    python3-opentelemetry-api \
    python3-packaging \
    python3-pint \
    \
    "

SRC_URI[sha256sum] = "ef63cc291a34d55823ec2f62be91991786ce4b9100e374df097b785d849466c3"

BBCLASSEXTEND = "native nativesdk"
