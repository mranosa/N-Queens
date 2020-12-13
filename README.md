# N Queens Challenge Solution in Java

The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal. The eight queens puzzle is an example of the more general n queens problem of placing n non-attacking queens on an n×n chessboard, for which solutions exist for all natural numbers n with the exception of n = 2 and n = 3.

Visit [Wikipedia] to know more.

### Pre-Requisites

* [Java]
* [Gradle]

### Run tests
```sh
$ ./gradlew clean test
```
### Run app
```sh
$ ./gradlew run --args=4
```

### Tested On

* Ubuntu 18.04
* Java openjdk version 11.0.9.1
* Gradle 6.7
 
### Implementation Thought Process

It has been a while since I have written in Java, so this challenge for me was a great way to brush up on my skills. Feedback for things to remove and improve are very much welcome, you can do a PR or email me at ken.ranosa@gmail.com with the subject of "N-Queen Code Feedback".

This is the first time that I have bumped into the N Queens Challenge. So along the way, I learned how to use recursive backtracking. I am self-taught and don't have a strong formal education concerning data structures and algorithms. My learnings are mainly done once the need or idea arises, while on the job, or during personal projects.

With regards to solving the challenge. I first researched the problem and found that this is quite a popular puzzle. It also introduced me to backtracking. 

My mind initially got bogged down visualizing how the backtracking recursion works, but before I dropped down the rabbit hole, I took a step back. I changed my focus again on what needs to be delivered and drafted the specs to consider this challenge done. I based the specs on the [Wikipedia] link and drafted a list of basic integration test cases.

This is my general approach to how I do things. Draft the essential test cases, do test-driven development, and let the tests guide the code design. If it is not in the tests, it is not essential. During the process, the tests have shown the need to return a set of Boards as solutions. Each board is one solution that has a unique configuration for a set of Queens. The Queen's properties are its coordinates on the board, and the behaviors are mainly checked to see if it has neighbor/s in the same column, row, diagonally, and if it is safe from them.

Once all tests pass, it is done. If bugs are found or there is a need for optimization, I only handle them once the need arises. Cheers!

[Wikipedia]: <http://ace.ajax.org>
[Java]: <https://www.java.com/en/download/>
[Gradle]: <https://gradle.org/install/>