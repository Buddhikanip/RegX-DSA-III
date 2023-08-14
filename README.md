# RegX-DSA-III
Implement Regex characters using the Knuth-Morris-Pratt (KMP) string matching algorithm. The solution was done by using the Java programming language.

<br /><br />
## How to run?
First, go to the [src](https://github.com/Buddhikanip/RegX-DSA-III/tree/main/src) folder and find the Main.java file. This is the main file in this scenario. You can run it using your own test cases and open the [pattrenmatch](https://github.com/Buddhikanip/RegX-DSA-III/blob/main/patternmatch.txt) file to view the outputs. If you want to add a new test case, go to the [text](https://github.com/Buddhikanip/RegX-DSA-III/blob/main/text.txt) and [pattern](https://github.com/Buddhikanip/RegX-DSA-III/blob/main/pattren.txt) files, create your own test cases.


<br />

You can change this text file name to your own file name.
```java
String pattern_file_name = "pattern.txt";
String text_file_name = "text.txt";
String output_file_name = "patternmatch.txt";
```

`regX.java` contains the Regex file, and the main file extends functions from the `regX.java` file.
<br/><br/>
#
First, extends `regX.java` and set the alias to re. Because `regX` is too long and hard to handle.
```java
public class Main extends regX
```

<br /><br />

## Methodology
I use the `Knuth-Morris-Pratt (KMP)` algorithm to implement this and filter the pattern using simple if statements. Also, the matiching condition is called to the relevant function, and the output is given as a pattern location.

```java
for (int i = 0; i < pattern.length(); i++) {
  if (pattern.charAt(i) == '|') {
    check = true;
    index = i;
    count++;
  }
}

if (check == true) {
  regX(pattern.substring(0, index), string, line);
  if (status == false) {
    regX(pattern.substring(index + 1, pattern.length()), string, line);
  } else if (pattern.charAt(0) == '^') {
    pattern = pattern.substring(1);
  } else if (pattern.charAt(pattern.length() - 1) == '$') {
    pattern = pattern.substring(0, pattern.length() - 1);
  } else {
     status = KMP(pattern, string, line);
  }
}
```

In this version, the program recognizes `^` `|` `$` as the regex character.

<br><br>
*If you want to clone and run this code, open the Main file in your IDE and run.


____
<p align="center">
    <a href="https://github.com/Buddhikanip/RegX-DSA-III/">
      <img alt="Hits" src="https://hits.sh/github.com/Buddhikanip/RegX-DSA-III.svg?label=Views"/>
    </a>
    <a href="https://github.com/Buddhikanip/RegX-DSA-III/actions">
      <img alt="Tests Passing" src="https://github.com/anuraghazra/github-readme-stats/workflows/Test/badge.svg" />
    </a>
    <a href="https://github.com/Buddhikanip/RegX-DSA-III/graphs/contributors">
      <img alt="GitHub Contributors" src="https://img.shields.io/github/contributors/Buddhikanip/RegX-DSA-III" />
    </a>
    <a href="https://github.com/Buddhikanip/RegX-DSA-III/issues">
      <img alt="Issues" src="https://img.shields.io/github/issues/Buddhikanip/RegX-DSA-III?color=0088ff" />
    </a>
    <a href="https://github.com/Buddhikanip/RegX-DSA-III/pulls">
      <img alt="GitHub pull requests" src="https://img.shields.io/github/issues-pr/Buddhikanip/RegX-DSA-III?color=0088ff" />
    </a>
  </p>
