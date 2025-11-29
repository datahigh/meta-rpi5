DESCRIPTION = "Bring up wlan0 interface during boot"
SECTION = "examples"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
SRC_URI = " \
    file://wifi.sh \
    file://wifi.service \
"
S = "${WORKDIR}"

inherit systemd
FILES:${PN} += "${bindir}/wifi.sh"
FILES:${PN} += "${systemd_system_unitdir}/wifi.service"
SYSTEMD_SERVICE:${PN} = "wifi.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 wifi.sh ${D}${bindir}
    install -d ${D}${systemd_system_unitdir}
    install -m 0600 ${WORKDIR}/wifi.service ${D}${systemd_system_unitdir}/wifi.service
}

