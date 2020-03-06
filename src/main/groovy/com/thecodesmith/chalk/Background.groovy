package com.thecodesmith.chalk

enum Background {
    black(0),
    red(1),
    green(2),
    yellow(3),
    blue(4),
    magenta(5),
    cyan(6),
    white(7)

    int value

    Background(int value) {
        this.value = value
    }

    String toString() {
        "\033[4${value}m"
    }
}
