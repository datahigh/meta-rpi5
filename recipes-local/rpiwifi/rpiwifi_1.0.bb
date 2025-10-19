DESCRIPTION = "Bring up wlan0 interface during boot"
SECTION = "examples"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
SRC_URI = "file://wifi.sh"
S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "wifi.sh"
INITSCRIPT_PARAMS = "defaults"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 wifi.sh ${D}${sysconfdir}/init.d
}
