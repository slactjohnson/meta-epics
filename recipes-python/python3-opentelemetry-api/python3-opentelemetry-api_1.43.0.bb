inherit pypi python_hatchling

SUMMARY = "OpenTelemetry Python API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

PYPI_PACKAGE = "opentelemetry_api"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-typing-extensions"

SRC_URI += "file://0001-Remove-unsupported-project-classifier.patch \
           file://0002-Remove-unsupported-python-classifier.patch \
           "
SRC_URI[sha256sum] = "107d0d03857ea8fc7c5fcbbbd83f800c281f0d560553d61c1d675fccfd1761c1"

BBCLASSEXTEND = "native nativesdk"
