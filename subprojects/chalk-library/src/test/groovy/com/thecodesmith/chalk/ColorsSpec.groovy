package com.thecodesmith.chalk

import spock.lang.Specification
import spock.lang.Unroll

import static Color.*
import static com.thecodesmith.chalk.Style.*

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
            'foo'.blackBackground   == colorized('foo', '40m')
            'foo'.redBackground     == colorized('foo', '41m')
            'foo'.greenBackground   == colorized('foo', '42m')
            'foo'.yellowBackground  == colorized('foo', '43m')
            'foo'.blueBackground    == colorized('foo', '44m')
            'foo'.magentaBackground == colorized('foo', '45m')
            'foo'.cyanBackground    == colorized('foo', '46m')
            'foo'.whiteBackground   == colorized('foo', '47m')
        }
    }

    def 'text colors can be used in dsl form'() {
        expect:
        verifyAll {
            'foo'.text(black)   == colorized('foo', '30m')
            'foo'.text(red)     == colorized('foo', '31m')
            'foo'.text(green)   == colorized('foo', '32m')
            'foo'.text(yellow)  == colorized('foo', '33m')
            'foo'.text(blue)    == colorized('foo', '34m')
            'foo'.text(magenta) == colorized('foo', '35m')
            'foo'.text(cyan)    == colorized('foo', '36m')
            'foo'.text(white)   == colorized('foo', '37m')
        }
    }

    def 'background colors can be used in dsl form'() {
        expect:
        verifyAll {
            'foo'.bg(black)   == colorized('foo', '40m')
            'foo'.bg(red)     == colorized('foo', '41m')
            'foo'.bg(green)   == colorized('foo', '42m')
            'foo'.bg(yellow)  == colorized('foo', '43m')
            'foo'.bg(blue)    == colorized('foo', '44m')
            'foo'.bg(magenta) == colorized('foo', '45m')
            'foo'.bg(cyan)    == colorized('foo', '46m')
            'foo'.bg(white)   == colorized('foo', '47m')
        }
    }

    def 'text and background colors can be used together in dsl form'() {
        expect:
        verifyAll {
            'foo'.text(black).bg(black)     == combo('foo', '30m', '40m')
            'foo'.text(red).bg(red)         == combo('foo', '31m', '41m')
            'foo'.text(green).bg(green)     == combo('foo', '32m', '42m')
            'foo'.text(yellow).bg(yellow)   == combo('foo', '33m', '43m')
            'foo'.text(blue).bg(blue)       == combo('foo', '34m', '44m')
            'foo'.text(magenta).bg(magenta) == combo('foo', '35m', '45m')
            'foo'.text(cyan).bg(cyan)       == combo('foo', '36m', '46m')
            'foo'.text(white).bg(white)     == combo('foo', '37m', '47m')
        }
    }

    @Unroll
    def 'text can be styled: #style'() {
        expect:
        decode(text) == decode(expected)

        where:
        style        | text             | expected
        'bold'       | 'foo'.bold       | '\u001b[1mfoo\u001b[0m'
        'underlined' | 'foo'.underlined | '\u001b[4mfoo\u001b[0m'
        'reversed'   | 'foo'.reversed   | '\u001b[7mfoo\u001b[0m'
    }

    def 'colors can be printed'() {
        expect:
        color.toString() == name

        where:
        color   | name
        black   | 'black'
        red     | 'red'
        green   | 'green'
        yellow  | 'yellow'
        blue    | 'blue'
        magenta | 'magenta'
        cyan    | 'cyan'
        white   | 'white'
    }

    def 'styles can be printed'() {
        expect:
        style.toString() == name

        where:
        style      | name
        bold       | 'bold'
        underlined | 'underlined'
        reversed   | 'reversed'
    }

    def 'dsl form matches direct form'() {
        expect:
        dsl == text

        where:
        dsl                                         | text
        'foo'.text(white).bg(red).style(underlined) | 'foo'.white.redBackground.underlined
        'foo'.text(blue).bg(white).style(bold)      | 'foo'.blue.whiteBackground.bold
    }

    def 'foreground/background method names match text/bg method names'() {
        expect:
        'foo'.foreground(red) == 'foo'.text(red)
        'foo'.background(red) == 'foo'.bg(red)
    }

    def 'visual smoke test'() {
        expect:
        println "$text - $description"

        where:
        text          | description
        'foo'.black   | 'black text'
        'foo'.red     | 'red text'
        'foo'.green   | 'green text'
        'foo'.yellow  | 'yellow text'
        'foo'.blue    | 'blue text'
        'foo'.magenta | 'magenta text'
        'foo'.cyan    | 'cyan text'
        'foo'.white   | 'white text'

        'foo'.blackBackground   | 'black background'
        'foo'.redBackground     | 'red background'
        'foo'.greenBackground   | 'green background'
        'foo'.yellowBackground  | 'yellow background'
        'foo'.blueBackground    | 'blue background'
        'foo'.magentaBackground | 'magenta background'
        'foo'.cyanBackground    | 'cyan background'
        'foo'.whiteBackground   | 'white background'

        'foo'.black.blueBackground   | 'black text, blue background'
        'foo'.red.blueBackground     | 'red text, blue background'
        'foo'.green.blueBackground   | 'green text, blue background'
        'foo'.yellow.blueBackground  | 'yellow text, blue background'
        'foo'.blue.blueBackground    | 'blue text, blue background'
        'foo'.magenta.blueBackground | 'magenta text, blue background'
        'foo'.cyan.blueBackground    | 'cyan text, blue background'
        'foo'.white.blueBackground   | 'white text, blue background'

        'foo'.black.blueBackground.bold.underlined   | 'black text, blue background, bold, underlined'
        'foo'.red.blueBackground.bold.underlined     | 'red text, blue background, bold, underlined'
        'foo'.green.blueBackground.bold.underlined   | 'green text, blue background, bold, underlined'
        'foo'.yellow.blueBackground.bold.underlined  | 'yellow text, blue background, bold, underlined'
        'foo'.blue.blueBackground.bold.underlined    | 'blue text, blue background, bold, underlined'
        'foo'.magenta.blueBackground.bold.underlined | 'magenta text, blue background, bold, underlined'
        'foo'.cyan.blueBackground.bold.underlined    | 'cyan text, blue background, bold, underlined'
        'foo'.white.blueBackground.bold.underlined   | 'white text, blue background, bold, underlined'

        'foo'.black.blueBackground.bold.underlined.reversed   | 'black text, blue background, bold, underlined, reversed'
        'foo'.red.blueBackground.bold.underlined.reversed     | 'red text, blue background, bold, underlined, reversed'
        'foo'.green.blueBackground.bold.underlined.reversed   | 'green text, blue background, bold, underlined, reversed'
        'foo'.yellow.blueBackground.bold.underlined.reversed  | 'yellow text, blue background, bold, underlined, reversed'
        'foo'.blue.blueBackground.bold.underlined.reversed    | 'blue text, blue background, bold, underlined, reversed'
        'foo'.magenta.blueBackground.bold.underlined.reversed | 'magenta text, blue background, bold, underlined, reversed'
        'foo'.cyan.blueBackground.bold.underlined.reversed    | 'cyan text, blue background, bold, underlined, reversed'
        'foo'.white.blueBackground.bold.underlined.reversed   | 'white text, blue background, bold, underlined, reversed'
    }

    String decode(String text) {
        def u = { Character c -> '\\u' + Integer.toHexString(c as char | 0x10000).substring(1) }
        text.collect { c ->
            c ==~ /[\w;\[]/ ? c : u(c as Character)
        }.join()
    }

    String colorized(String text, String code) {
        "\u001b[${code}${text}\u001b[0m"
    }

    String combo(String text, String fg, String bg) {
        "\u001b[${bg}\u001b[${fg}${text}\u001b[0m\u001b[0m"
    }
}
