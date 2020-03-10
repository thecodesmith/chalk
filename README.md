# Chalk

_Pretty terminal colors for Groovy._

![CI](https://github.com/thecodesmith/chalk/workflows/CI/badge.svg)
[![Coverage Status](https://coveralls.io/repos/github/thecodesmith/chalk/badge.svg)](https://coveralls.io/github/thecodesmith/chalk)
[![Download](https://api.bintray.com/packages/thecodesmith/maven/chalk/images/download.svg)](https://bintray.com/thecodesmith/maven/chalk/_latestVersion)

Inspired by the popular JavaScript library [chalk](https://github.com/chalk/chalk), and designed for idiomatic Groovy.

There are already a number of terminal color libraries for Java, but they all feel like writing, well, _Java_. This library is designed specifically with Groovy in mind, and takes advantage of Groovy's [extension modules](https://mrhaki.blogspot.com/2013/01/groovy-goodness-adding-extra-methods.html) to provide a clean, concise experience. Since I write most of my code in Groovy, I prefer to have an expressive API that feels more like natural language.

## Usage

The latest version is available from Bintray: [![Download](https://api.bintray.com/packages/thecodesmith/maven/chalk/images/download.svg?version=1.0.0-b.1)](https://bintray.com/thecodesmith/maven/chalk/1.0.0-b.1/link).
Replace the `{version}` tags below with the latest release version.

#### Using With Gradle

```groovy
implementation 'com.thecodesmith:chalk:{version}'
```

### Using With Groovy @Grab

```groovy
@Grab('com.thecodesmith:chalk:{version}')
```

### Methods

This library makes additional color methods available directly on the `String` class. Here's an example:

```groovy
println 'Hello, World!'.green.bold.underlined
```

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

## Contributing

See a feature that is missing? Feel free to open an issue, or contribute a pull request!

## License

This library is licensed under the terms of the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
