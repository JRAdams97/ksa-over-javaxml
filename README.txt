  
                 __ __ _____  ___           ____                    
                / //_// ___/ /   |         / __ \ _   __ ___   _____
               / ,<   \__ \ / /| | ______ / / / /| | / // _ \ / ___/
              / /| | ___/ // ___ |/_____// /_/ / | |/ //  __// /    
             /_/ |_|/____//_/  |_|       \____/  |___/ \___//_/     
                          __                     _  __  __  ___ __ 
                         / /____ _ _   __ ____ _| |/ / /  |/  // / 
             ______ __  / // __ `/| | / // __ `/|   / / /|_/ // /  
            /_____// /_/ // /_/ / | |/ // /_/ //   | / /  / // /___
                   \____/ \__,_/  |___/ \__,_//_/|_|/_/  /_//_____/
                                                       

                 ______________________________________________
                 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
                       AUTHORS: ADAMS, Justin (101091429)
                                TIAN, Lu      (102238612)
                           VERSION: 1.0 (25/10/2019)
                           TUTOR: Medhi Naseriparsa
                       SUBJECT: COS80007 - Advanced Java
                 ______________________________________________
                 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
                               
 ______________________________________________________________________________
 [S00] TABLE OF CONTENTS
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 TABLE OF CONTENTS........................................................[S00]
 INTRODUCTION.............................................................[S01]
 INSTALLATION.............................................................[S02]
 USAGE....................................................................[S03]
 FEATURES.................................................................[S04]
 EVALUATION & CONCLUSION..................................................[S07]

 ______________________________________________________________________________
 [S01] INTRODUCTION
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 keyword-snippet-analysis is a Java application designed to track performance
 differences between common forms of non-blocking and blocking I/O operations.
 It leverages off of Java's NIO packages and features 4 common I/O
 implementations. The general process of the application logic is as follows:

     1. Program is invoked with three commandline arguments:
         a. Invocation type. Class used to perform the experiment.
         b. Buffer/Array capacity; numeric value.
         c. Input file name; ending in '.txt'.
     
     2. Instance of invocation type/class is instantied with required
        fields (buffer/array).

     3. Experiment begins:
         a. Input file is located and tested.
         b. Output file is created.
         c. Buffering/Streaming method is executed.
         d. Hashtable is populated with entries for all preset keywords
            (in main.properties).

     4. Buffer/Array reads from the input file.

     5. Evaluation is performed on the current buffer/array by running it
        through checks for all keywords in the Hashtable.

     6. Matches are logged to console and printed to output file.

     7. Once the file is completely read and no more keyword matches are
        occurring, the file channels/streams are closed.

     8. Report builder collates data about the experiment and writes it to
        the report file (timings.txt).

     9. Experiment ends.
     

 PACKAGE CONTENTS:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 Java App. Project:

     - Uncompiled project with Java source code (/src/*).
     - Project resources (/src/main/resources/*).
     - Compiled Java project (/out/prod/*).
     - Example input file (/out/prod/input.txt).
     - Pre-made files and directories (/out/prod/output/*).
       (NOTE: anything in the pre-made directory can be deleted to ensure a
        fresh copy or to save space) 

 Executable JAR Project:
     - Executable JAR artefact (/out/keyword-snippet-analysis.jar).
     - Example input file (/out/input.txt).
     - Pre-made files and directories (/out/prod/output/*).
       (NOTE: anything in the pre-made directory can be deleted to ensure a
        fresh copy or to save space).

 Other:
     - Windows batch file containing batch executions of executable JAR
       (/batchrunner.bat).
     - README containing instructions about the program (/README.txt).

 ______________________________________________________________________________
 [S02] INSTALLATION / BUILDING
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 To build the keyword-snippet-analysis program, please follow the guidelines
 below:

     1. Open the root directory in the IDE of your choice.
 
     2. Bind the main class as 'KeywordSnippetAnalysis.java'.

     3. Add commandline arguments to the application via project options or
        build configuration (Project Structure on IntelliJ).

     4. Build the project. Compiled artefacts should appear in one of the
        output folders (may be dependent on profile).

     NOTE: Executable JAR does not need to be build. It can be used straight
     away.

 ______________________________________________________________________________
 [S03] USAGE
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 There are a handful of ways to run and configure the application. Follow the
 instructions below to run keyword-snippet-analysis in a particular mode.

 COMMANDLINE/EXECUTABLE JAR MODE:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
     1. Create an input file (.txt) and place it in the same location as the
        executable JAR or at the top level of the source code (e.g. out/prod
        directory). NOTE: You can put any text you want in this file.
     2. Open an instance of Command Prompt or PowerShell and navigate (cd) to
        the location of the application source code or executable JAR.
     3. Run an invocation of the program:
        JAR: java -jar keyword-snippet-analysis.jar <class> <capacity> <input>
      Source: 


 IDE PROJECT MODE:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
     1. Follow instructions given in [S02] (INSTALLATION / BUILDING).
     
     NOTE: Feel free to modify any of the properties defined in main.properties.
     You will be able to add new keywords or change the name of the report /
     output files.


 BATCHRUNNER MODE:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
     1. Verify that the batchrunner.bat file is present in the root directory
        (i.e. JAR is in '/out' and batchrunner.bat is in '/').

     2. Double click the batch file.

 ______________________________________________________________________________
 [S04] FEATURES
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 The primary features and functionality of the Keyword Snippet Analysis program
 are highlighted below:

     - Integration of NIO objects to obtain a file channel and utilise
       ByteBuffers to manage non-blocking I/O operations.
     
     - Usage of traditional OOP design concepts such as inheritance and
       abstraction (via static initialisation, abstract classes, subclasses).

     - Support for complex data structures such as Hashtables, ArrayLists,
       Sets, etc.

     - Dynamic output file generation through timestamp generation in file
       name. Allows separation of cases when running manually or via batch.

     - Binding of Java logging API (JUL) in project to improve console output.

     - Dynamic resource setting and access via project resource bundles
       (shown in project under 'main/resources/resources/main.properties').
       
     - Allows report generation for review of prior experiments and analysis
       of important metrics (i.e. elapsed experiment time, class type, etc.).

     - Supported running of NIO cases in batch using a command-line utility
       (batchrunner.bat).

     - Ability to efficiently run experiments and reuse project via packaged
       JAR.

     - Highly documented process outlined with inline comments and Javadoc
       specifications.

     - Abides by renowned Google Checkstyles guidelines and Sonar linting
       rules. Ensures high quality project code.



 ______________________________________________________________________________
 [S07] EVALUATION & CONCLUSION
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 
 MARKS EVALUATION:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 Based on the currently offered functionality of the program and the efforts
 spent on meeting the given criteria; I would estimate the following:

   1. [35/40] Design and implementation of different methods.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) Code is generally well distributed across a variety of classes.
      (++) Functionality is modularised into appropriate classes.
      (--) Some code complexity and long methods are present. 


   2. [08/10] Use of batch file containing java commands to do the experiments.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) Batch file supports many executions of the program.
      (--) Batch file is not appropriately documented (internally).


   3. [25/40] Use NIO and advanced Java features as far as possible.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) A large number of NIO objects are incorporated into the program.
      (--) Advanced Java features (functional interfaces, lambda expressions,
           method reference operators) are lacking.
      (--) Non-conventional usage of Hashtable to deserialize in XML format.
      (--) No multi-threading or synchronization used.
 

   4. [30/40] Use advanced data structure for indexing and exception handling.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) Java's in-built logging API (JUL) is used to ensure logs are present
           for all major milestones in the experiment (and exception logging).
      (++) Non-generic exceptions used to handle edge cases.
      (--) Logging is clunky and not very readable.
    

   5. [45/50] Recording the time for each method and printing the results in a
      text file.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) Elapsed time of a particular experimenct is calculated to nanosecond
           precision.
      (++) Reports file contains other useful data to provide more context
           about an experiment.
      (--) Report file is not self-explanatory.


   6. [10/10] Include reasonable documentation according to Javadoc standards.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) All methods and constructors have an associated Javadoc.
      (++) Javadocs use Oracle's recommended style guide to improve
           readability.


   7. [10/10] A readme.txt file explaining features completed, expected mark
      and locating presence of codes from other sources.
      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
      (++) Readme is detailed and addresses all identified sections.


 LICENSING:
 ¯¯¯¯¯¯¯¯¯
   - Google Checkstyles rules were utilized as part of the program to ensure
     code quality. These rules can be found in resources/google_checks.xml and
     were used only as a support tool. Google Checkstyles are covered by the
     license "GNU LGPL v2.1".

     SOURCE: https://github.com/checkstyle/checkstyle/blob/master/src/main/
     resources/google_checks.xml

   - SonarQube was also used as an additional code linting tool. This tool
     is specifically used to target complex issues in the codebase such as
     possible simplifications, bugs, and security vulnerabilities. Used as an
     IntelliJ plugin.

     SOURCE: https://www.sonarqube.org/


 FINAL COMMENTS:
 ¯¯¯¯¯¯¯¯¯¯¯¯¯¯
 If you have any concerns or questions. Please contact us at our respective
 email addresses:
 
   - 101091429@student.swin.edu.au
   - 102238612@student.swin.edu.au