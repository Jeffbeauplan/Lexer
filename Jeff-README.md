# Jeff Beauplan Project 1 (Lexer) README

##### Structure of program:

    - Pr01.java
        TockenizeInput() - 
            input: Config config, String nfaProgram
            This function calls parseprogram to get a list of intructions and 
            then tries to run the thompson alogorithmn on the input using the nfa program.
        ParseProgram() - 
            input: string nfaProgram
            This function parses the nfaProgram string and turns each line into
            an instruction object and returns the list of intructions.
    
    - Thompson.java
        Tokenize() -
        input: byte[] input, List<Instruction> program
        This function takes in the input as a byte array and the nfa program as
        a list of instruction objects, tries to run the thompson alogorithmn and 
        throws exceptions if there are any errors.
    
    - Instruction.java
        This class represents an instruction. It has 3 members. OP, X and Y
    
    - Match.java
        This class represents a match, it contains the instruction # that produced the match
        and a lexeme.
    
    - Pr01Test.java
        testRuns() - 
        This function runs the unit test again the code written in Pr01.java.
        
##
For the following sections where we utilize the **gradle** command please ensure that you are in the correct directory.
####

>cd pr01/java-example

#
##### Compile:        

    ./gradlew classes
##### Making the Script:

    ./gradlew installDist
    This will make an executable and place it in the pr01/bin folder.
##### Test:

    ./gradlew test
    This runs the Pr01Test.java file
    
##### Run Against Student Grader

    While still in the java-examples folder:
    ../bin/student-grader ./build/install/pr01/bin/pr01