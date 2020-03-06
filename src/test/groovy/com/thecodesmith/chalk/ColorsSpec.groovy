package com.thecodesmith.chalk

import spock.lang.Specification

// @formatter:off
class ColorsSpec extends Specification {

    def '8-bit colors are available on string objects'() {
        expect:
        verifyAll {
            'foo'.black   == colorized('foo', '30m')
            'foo'.red     == colorized('foo', '31m')
            'foo'.green   == colorized('foo', '32m')
            'foo'.yellow  == colorized('foo', '33m')
            'foo'.blue    == colorized('foo', '34m')
            'foo'.magenta == colorized('foo', '35m')
            'foo'.cyan    == colorized('foo', '36m')
            'foo'.white   == colorized('foo', '37m')
        }
    }

    def '16-bit colors are available on string objects'() {
        expect:
        verifyAll {
            'foo'.boldBlack   == colorized('foo', '30;1m')
            'foo'.boldRed     == colorized('foo', '31;1m')
            'foo'.boldGreen   == colorized('foo', '32;1m')
            'foo'.boldYellow  == colorized('foo', '33;1m')
            'foo'.boldBlue    == colorized('foo', '34;1m')
            'foo'.boldMagenta == colorized('foo', '35;1m')
            'foo'.boldCyan    == colorized('foo', '36;1m')
            'foo'.boldWhite   == colorized('foo', '37;1m')
        }
    }

    def '256-bit colors are available on string objects'() {
        expect:
        'foo'.color(code) == colorized('foo', "38;5;${code}m")

        where:
        code << (0..255)
    }

    def 'background colors are available on string objects'() {
        expect:
        verifyAll {
            'foo'.blackBackground   == colorizedBackground('foo', '40m')
            'foo'.redBackground     == colorizedBackground('foo', '41m')
            'foo'.greenBackground   == colorizedBackground('foo', '42m')
            'foo'.yellowBackground  == colorizedBackground('foo', '43m')
            'foo'.blueBackground    == colorizedBackground('foo', '44m')
            'foo'.magentaBackground == colorizedBackground('foo', '45m')
            'foo'.cyanBackground    == colorizedBackground('foo', '46m')
            'foo'.whiteBackground   == colorizedBackground('foo', '47m')
        }
    }

    String colorized(String text, String code) {
        "\033[${code}${text}\033[0m"
    }

    String colorizedBackground(String text, String code) {
        "\033[${code}${text}\033[0m"
    }
}
