# The java pr01 example

Running the tests

    $ ./gradlew test

Making the command line script

    $ ./gradlew test installDist

Running the command line script

    $ echo "hi!" | ./build/install/pr01/bin/pr01 ../examples/0-ex-program.ns

Running the student-grader script:

    $ ../bin/student-grader ./build/install/pr01/bin/pr01

Initially your score will be 0%:

    ------------------------------------------------------------------------------
                                               score: 0.00%, passed: 0, failed: 19
