package com.thecodesmith.chalk

import static com.thecodesmith.chalk.Colors.escape

enum Style {
    bold(1, 'bold'),
    underlined(4, 'underlined'),
    reversed(7, 'reversed')

    int value
    String name

    Style(int value, String name) {
        this.value = value
        this.name = name
    }

    String getText() {
        "${escape}[${value}m"
    }

    String toString() {
        name
    }
}
