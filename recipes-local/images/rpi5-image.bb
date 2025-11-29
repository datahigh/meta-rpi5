require recipes-core/images/rpi-test-image.bb

EXTRA_IMAGE_FEATURES:append = " debug-tweaks ssh-server-openssh package-management"
IMAGE_INSTALL:append = " rpiwifi gattd helloworld-rust"
