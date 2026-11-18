DESCRIPTION = "Container Manager config for cluster demo"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"


SRC_URI = "file://cluster-demo-slint.json \
           file://system.conf.cluster-demo-slint.in \
          "

inherit cm-config

do_install:append() {
    install -Dm644 ${UNPACKDIR}/cluster-demo-slint.json ${D}/opt/container/conf/cluster-demo-slint.json
    install -d ${D}/opt/container/guests/cluster-demo-slint/rootfs
    install -d ${D}/opt/container/guests/cluster-demo-slint/nv
    install -d ${D}/opt/container/guests/cluster-demo-slint/shmounts
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    /opt/container/conf/* \
    /opt/container/guests/cluster-demo-slint/* \
    "

