#
# class for all EPICS modules that automatically brings in epics-base and epics-base-native
#

inherit epics-component epics-functions

# All EPICS modules depend on epics-base and epics-base-native
DEPENDS += "epics-base epics-base-native"

# We should always have epics-base on target
EPICS_DEPENDS += "epics-base"

# Add all EPICS dependencies to the image
RDEPENDS:${PN} += "${EPICS_DEPENDS}"

do_install:append() {
    # Install and sanitize all configuration files
    # Do RECIPE_SYSROOT_NATIVE first to avoid conflict with RECIPE_SYSROOT
    cp -rfv configure "${D}/opt/epics/${MODNAME}"
    find "${D}/opt/epics/${MODNAME}/configure" -type f -name 'CONFIG*' -exec sed -i "s,${RECIPE_SYSROOT}/image,,g" {} \;
    find "${D}/opt/epics/${MODNAME}/configure" -type f -name 'CONFIG*' -exec sed -i "s,${RECIPE_SYSROOT_NATIVE},,g" {} \;
    find "${D}/opt/epics/${MODNAME}/configure" -type f -name 'CONFIG*' -exec sed -i "s,${RECIPE_SYSROOT},,g" {} \;
    find "${D}/opt/epics/${MODNAME}/configure" -type f -name 'CONFIG*' -exec sed -i "s,${WORKDIR},,g" {} \;

    # Sanitize all installed .local files
    find "${D}/opt/epics/${MODNAME}" -type f -iname '*.local' -exec sed -i "s,${RECIPE_SYSROOT},,g" {} \;

    # Sanitize envPaths
    find "${D}/opt/epics/${MODNAME}" -type f -name 'envPaths' -exec sed -i "s,${RECIPE_SYSROOT},,g" {} \;
}
