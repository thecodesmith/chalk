package com.thecodesmith.chalk

// @formatter:off
class Colors {

    static final String RESET        = '\033[0m'

    // region text colors
    static final String BLACK        = '\033[30m'
    static final String RED          = '\033[31m'
    static final String GREEN        = '\033[32m'
    static final String YELLOW       = '\033[33m'
    static final String BLUE         = '\033[34m'
    static final String MAGENTA      = '\033[35m'
    static final String CYAN         = '\033[36m'
    static final String WHITE        = '\033[37m'

    static final String BOLD_BLACK   = '\033[30;1m'
    static final String BOLD_RED     = '\033[31;1m'
    static final String BOLD_GREEN   = '\033[32;1m'
    static final String BOLD_YELLOW  = '\033[33;1m'
    static final String BOLD_BLUE    = '\033[34;1m'
    static final String BOLD_MAGENTA = '\033[35;1m'
    static final String BOLD_CYAN    = '\033[36;1m'
    static final String BOLD_WHITE   = '\033[37;1m'
    // endregion

    // region background colors
    static final String BG_BLACK = '\033[40m'
    static final String BG_RED   = '\033[41m'
    static final String BG_GREEN = '\033[42m'
    static final String BG_YELLOW = '\033[43m'
    static final String BG_BLUE = '\033[44m'
    static final String BG_MAGENTA = '\033[45m'
    static final String BG_CYAN = '\033[46m'
    static final String BG_WHITE = '\033[47m'
    // endregion

    // region plain colors (8-bit)
    static String getBlack(String self) {
        "$BLACK${self}$RESET"
    }

    static String getRed(String self) {
        "$RED${self}$RESET"
    }

    static String getGreen(String self) {
        "$GREEN${self}$RESET"
    }

    static String getYellow(String self) {
        "$YELLOW${self}$RESET"
    }

    static String getBlue(String self) {
        "$BLUE${self}$RESET"
    }

    static String getMagenta(String self) {
        "$MAGENTA${self}$RESET"
    }

    static String getCyan(String self) {
        "$CYAN${self}$RESET"
    }

    static String getWhite(String self) {
        "$WHITE${self}$RESET"
    }
    // endregion

    // region bold colors (16-bit)
    static String getBoldBlack(String self) {
        "$BOLD_BLACK${self}$RESET"
    }

    static String getBoldRed(String self) {
        "$BOLD_RED${self}$RESET"
    }

    static String getBoldGreen(String self) {
        "$BOLD_GREEN${self}$RESET"
    }

    static String getBoldYellow(String self) {
        "$BOLD_YELLOW${self}$RESET"
    }

    static String getBoldBlue(String self) {
        "$BOLD_BLUE${self}$RESET"
    }

    static String getBoldMagenta(String self) {
        "$BOLD_MAGENTA${self}$RESET"
    }

    static String getBoldCyan(String self) {
        "$BOLD_CYAN${self}$RESET"
    }

    static String getBoldWhite(String self) {
        "$BOLD_WHITE${self}$RESET"
    }
    // endregion

    // region extended colors (256-bit)
    static String color(String self, code) {
        "${twoFiftySixBit(code)}${self}$RESET"
    }

    private static String twoFiftySixBit(code) {
        "\033[38;5;${code}m"
    }
    // endregion

    // region background colors
    static String bg(String self, Background color) {
        "${color}${self}$RESET"
    }

    static String getBlackBackground(String self) {
        "${bg(self, Background.black)}"
    }

    static String getRedBackground(String self) {
        "${bg(self, Background.red)}"
    }

    static String getGreenBackground(String self) {
        "${bg(self, Background.green)}"
    }

    static String getYellowBackground(String self) {
        "${bg(self, Background.yellow)}"
    }

    static String getBlueBackground(String self) {
        "${bg(self, Background.blue)}"
    }

    static String getMagentaBackground(String self) {
        "${bg(self, Background.magenta)}"
    }

    static String getCyanBackground(String self) {
        "${bg(self, Background.cyan)}"
    }

    static String getWhiteBackground(String self) {
        "${bg(self, Background.white)}"
    }
    // endregion
}
