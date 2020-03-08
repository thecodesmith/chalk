# Chalk

_Terminal colors for Groovy_

Inspired by the popular JavaScript library [chalk](https://github.com/chalk/chalk), and designed for idiomatic Groovy.

## Why

There are already a number of terminal color libraries for Java, but they all feel like writing, well, Java. This library is designed specifically with Groovy in mind, and takes advantage of Groovy's extension modules (see [examples](https://mrhaki.blogspot.com/2013/01/groovy-goodness-adding-extra-methods.html), [docs](https://groovy-lang.org/metaprogramming.html#_extension_modules)) to provide a clean, concise experience.

## Usage

This library makes additional color methods available directly on the `String` class. Here's an example:

```groovy
println 'Hello, World!'.green.bold.underlined
```

### Methods

These are implemented as getters on the `String` class, so the full form is like `'foo'.getGreen()`, but of course with Groovy we can use the property-style accessor and shorten it to `'foo'.green`.

### Composability

The text color, background color and text styles can all be composed together. Example:

```groovy
println 'foo'.blue.redBackground.bold.underlined
```

### Property Form and Method-chaining Form

There are two main ways to accomplish the same output. The easiest is to use the property form, like this:

```groovy
println 'foo'.red
println 'bar'.red.whiteBackground
println 'baz'.red.whiteBackground.bold
```

Another way of accomplishing the same output is to use methods, like this:

```groovy
import static com.thecodesmith.chalk.Color.red
import static com.thecodesmith.chalk.Color.white
import static com.thecodesmith.chalk.Style.bold

println 'foo'.text(red)
println 'bar'.text(red).background(white)
println 'baz'.text(red).background(white).style(bold)
```

They work the same, it is just a matter of preference which you use.

### Colors

- `black`
- `red`
- `green`
- `yellow`
- `blue`
- `magenta`
- `cyan`
- `white`

Extended colors (256-bit) are supported via the `color(int code)` method, which takes an ANSI color code, `0-255`. Example:

```groovy
println 'foo'.color(214)
```

### Background Colors

- `blackBackground`
- `redBackground`
- `greenBackground`
- `yellowBackground`
- `blueBackground`
- `magentaBackground`
- `cyanBackground`
- `whiteBackground`

### Text Styles

- `bold`
- `underlined`
- `reversed`
