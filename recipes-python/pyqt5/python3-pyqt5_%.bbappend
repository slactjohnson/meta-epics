# python3-pyqt5_%.bbappend

# PyDM needs QtDesigner stuff
PYQT_MODULES += " \
    QtDesigner \
    "

DEPENDS += "qttools"
