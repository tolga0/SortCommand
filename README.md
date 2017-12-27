# Extended [Locale](https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html) Sensitive String Sort

In the [previous programming assignment](https://github.com/AnadoluUniversityCeng/LocaleSensitiveSort), you implemented a Java application that sorts lines in a text file.
The objective was to understand that String sort is actually a locale-sensitive operation. 
In this assignment, you are going to add more capabilities to you sort application.


Your project **must** be a valid maven project. `mvn clean package` must produce an executable jar file named **sort.jar** under the target directory.
This can be done via maven plugins such as [shade](https://maven.apache.org/plugins/maven-shade-plugin) or [assembly](https://maven.apache.org/plugins/maven-assembly-plugin) plugin.

 
The enhanced version will support the following command line options.

Option | Description
------------ | -------------
-l, --locale | The locale. [defaults to en-US]
-r, --reverse | Reverse the result of comparisons.
-i, --ignore-case | Fold lower case to upper case characters using the supplied locale.
-o, --output=FILE | Write result to FILE instead of standard output.



Similar to [GNU Core Utilities'](https://www.gnu.org/software/coreutils/coreutils.html) [sort command](https://www.computerhope.com/unix/usort.htm), write a Java application that sorts the contents of a text file, line by line.

**sort syntax:** `sort [OPTION]... [FILE]...`

**sort examples**

Let's say you have a file, letters.txt, which contains the following lines:
`
a
h
m
e
t
A
H
M
E
T
`

For example, `java jar target/sort.jar letters.txt` will produce the following output:
`
A
E
H
M
T
a
e
h
m
t
`



Another example, `java jar target/sort.jar -i letters.txt` will produce the following output:
`
A
a
E
e
H
h
M
m
T
t
`

Note that sorting Turkish letters **without** `-l tr-TR` option will produce the following output:
`
a
b
c
d
e
f
g
h
i
j
k
l
m
n
o
p
r
s
t
u
v
y
z
ç
ö
ü
ğ
ı
ş
`
whereas sorting Turkish letters **with** `-l tr-TR` option will produce the correct order.

**P.S.** To parse command line arguments, you can use [JewelCLI](http://jewelcli.lexicalscope.com) library.

**P.P.S**: Optional parameter [finalName](https://maven.apache.org/plugins/maven-shade-plugin/shade-mojo.html#finalName) can be used to change the name of the shaded artifactId.

:exclamation: If you don't follow the aforementioned conventions, you will receive very poor grades (even if you think that your code works perfectly).