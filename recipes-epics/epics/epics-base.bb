SUMMARY = "EPICS base recipe"
DESCRIPTION = "Recipe for building EPICS base for the EPICS control system."

LICENSE = "LICENSE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2eeea17a15fc6ba8501fdcec09b854dc"
LICENSE_PATH += "${S}"

BBCLASSEXTEND =+ "native nativesdk"
COMPATIBLE_HOST = "(x86_64|aarch64).*-linux"

SRC_URI = "gitsm://github.com/epics-base/epics-base;protocol=https;branch=7.0;rev=07572ab02593fa225660fdee670850c9989f5851"

DEPENDS += " readline"

RDEPENDS:${PN} += " bash perl"

S = "${WORKDIR}/git"

python do_my_test() {
    print(host_arch(d))
    print(gcc_target_arch(d))
    print(epics_target_arch(d))
}

do_compile() {
    INSTALL_LOCATION="${D}/opt/epics/${PN}/${PV}"
    mkdir -p "${INSTALL_LOCATION}"
    
    # Disable shared libraies, enable static libraries, and enable cross compilation
    echo "SHARED_LIBRARIES=NO" > configure/CONFIG_SITE.local
    echo "STATIC_BUILD=YES" >> configure/CONFIG_SITE.local
    echo "CROSS_COMPILER_TARGET_ARCHS=linux-aarch64" >> configure/CONFIG_SITE.local
    
    # Set location of final build products
    echo "INSTALL_LOCATION=${INSTALL_LOCATION}" >> configure/CONFIG_SITE.local
    echo "FINAL_LOCATION=${INSTALL_LOCATION}" >> configure/CONFIG_SITE.local

    export EPICS_HOST_ARCH=linux-x86_64

    echo "CC=${CC}"
    echo "PACKAGE_VERSION=${PV}"

    # Set list of compile tools. NOTE: can't use EPICS style GNU_DIR/CMPLR_PREFIX here, since ${CC} et al have flags in them
    echo "CC=${CC}" >> configure/os/CONFIG_SITE.Common.linux-aarch64
    echo "CXX=${CXX}" >> configure/os/CONFIG_SITE.Common.linux-aarch64
    echo "CCC=${CXX}" >> configure/os/CONFIG_SITE.Common.linux-aarch64
    echo "LD=${LD} -r" >> configure/os/CONFIG_SITE.Common.linux-aarch64
    echo "AR=${AR} -rc" >> configure/os/CONFIG_SITE.Common.linux-aarch64
    echo "RANLIB=${RANLIB}" >> configure/os/CONFIG_SITE.Common.linux-aarch64

    # Set some special LDFLAGS. Cannot use the Bitbake provided BUILD_LDFLAGS because it injects way too many options
    echo "USR_LDFLAGS=-Wl,--hash-style=gnu" >> configure/os/CONFIG_SITE.Common.linux-aarch64

    # NOTE: Build is actually done during the do_install() process
    # Installing files here will result in them being clobbered before do_install.
    # make build.${TGTARCH} would work (in theory), but the build process relies on msi
    # and other EPICS tools that are generated+installed as part of the install.xxx targets.
}

do_install() {
    INSTALL_LOCATION="${D}/opt/epics/${PN}/${PV}"
    
    make install.linux-aarch64 -j${OMP_NUM_THREADS}
    make clean

    # Need to remove these so we pass the stupid tmpdir sanity check...
    rm -rf "${INSTALL_LOCATION}/lib/pkgconfig"
}

# Disable stripping and debug split; doesn't work for combined packages like this
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Disable other checks that are incompatible here
INSANE_SKIP:${PN} = "staticdev file-rdeps arch tmpdir"

# Ensure we're staged to the sysroot for our deps
SYSROOT_DIRS += "/opt/epics"

FILES:${PN} += "/opt/epics/${PN}/${PV}/*"
FILES_${PN}-dev += "/opt/epics/${PN}/${PV}/*"
