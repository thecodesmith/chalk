package com.thecodesmith.chalk

import static com.thecodesmith.chalk.Colors.escape

enum Color {
    black(0, 'black'),
    red(1, 'red'),
    green(2, 'green'),
    yellow(3, 'yellow'),
    blue(4, 'blue'),
    magenta(5, 'magenta'),
    cyan(6, 'cyan'),
    white(7, 'white')

    int value
    String name

    Color(int value, String name) {
        this.value = value
        this.name = name
    }

    String getText() {
        "${escape}[3${value}m"
    }

    String getBold() {
        "${escape}[3${value};1m"
    }

    String getBackground() {
        "${escape}[4${value}m"
    }

    String toString() {
        name
    }
}
