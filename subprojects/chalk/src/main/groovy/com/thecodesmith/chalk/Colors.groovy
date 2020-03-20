package com.thecodesmith.chalk

class Colors {

    static final String escape = '\u001b'
    static final String reset = "${escape}[0m"

    // region plain colors (8-bit) static methods
    static String black(String s) {
        text(s, Color.black)
    }

    static String red(String s) {
        text(s, Color.red)
    }

    static String green(String s) {
        text(s, Color.green)
    }

    static String yellow(String s) {
        text(s, Color.yellow)
    }

    static String blue(String s) {
        text(s, Color.blue)
    }

    static String magenta(String s) {
        text(s, Color.magenta)
    }

    static String cyan(String s) {
        text(s, Color.cyan)
    }

    static String white(String s) {
        text(s, Color.white)
    }
    // endregion

    // region plain colors (8-bit)
    static String text(String self, Color color) {
        "${color.text}${self}${reset}"
    }

    static String foreground(String self, Color color) {
        text(self, color)
    }

    static String getBlack(String self) {
        text(self, Color.black)
    }

    static String getRed(String self) {
        text(self, Color.red)
    }

    static String getGreen(String self) {
        text(self, Color.green)
    }

    static String getYellow(String self) {
        text(self, Color.yellow)
    }

    static String getBlue(String self) {
        text(self, Color.blue)
    }

    static String getMagenta(String self) {
        text(self, Color.magenta)
    }

    static String getCyan(String self) {
        text(self, Color.cyan)
    }

    static String getWhite(String self) {
        text(self, Color.white)
    }
    // endregion

    // region bold colors (16-bit)
    static String bold(String self, Color color) {
        "${color.bold}${self}${reset}"
    }

    static String getBoldBlack(String self) {
        bold(self, Color.black)
    }

    static String getBoldRed(String self) {
        bold(self, Color.red)
    }

    static String getBoldGreen(String self) {
        bold(self, Color.green)
    }

    static String getBoldYellow(String self) {
        bold(self, Color.yellow)
    }

    static String getBoldBlue(String self) {
        bold(self, Color.blue)
    }

    static String getBoldMagenta(String self) {
        bold(self, Color.magenta)
    }

    static String getBoldCyan(String self) {
        bold(self, Color.cyan)
    }

    static String getBoldWhite(String self) {
        bold(self, Color.white)
    }
    // endregion

    // region extended colors (256-bit)
    static String color(String self, code) {
        "${twoFiftySixBit(code)}${self}${reset}"
    }

    private static String twoFiftySixBit(code) {
        "${escape}[38;5;${code}m"
    }
    // endregion

    // region background colors
    static String bg(String self, Color color) {
        "${color.background}${self}${reset}"
    }

    static String background(String self, Color color) {
        bg(self, color)
    }

    static String getBlackBackground(String self) {
        bg(self, Color.black)
    }

    static String getRedBackground(String self) {
        bg(self, Color.red)
    }

    static String getGreenBackground(String self) {
        bg(self, Color.green)
    }

    static String getYellowBackground(String self) {
        bg(self, Color.yellow)
    }

    static String getBlueBackground(String self) {
        bg(self, Color.blue)
    }

    static String getMagentaBackground(String self) {
        bg(self, Color.magenta)
    }

    static String getCyanBackground(String self) {
        bg(self, Color.cyan)
    }

    static String getWhiteBackground(String self) {
        bg(self, Color.white)
    }
    // endregion

    // region text styles
    static String style(String self, Style style) {
        "${style.text}${self}${reset}"
    }

    static String getBold(String self) {
        style(self, Style.bold)
    }

    static String getUnderlined(String self) {
        style(self, Style.underlined)
    }

    static String getReversed(String self) {
        style(self, Style.reversed)
    }
    // endregion
}
