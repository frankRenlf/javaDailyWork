//
// Simple Java code intended as a refresher for students who need to 'brush up' on their Java.
// There are no network featires in this example.
//
// Compile with: javac ParseCmdLineArgs.java
// Execute with: java ParseCmdLineArgs arg1 arg2 arg3 ...
//

public class ParseCmdLineArgs {

    // The sole constructor, which expects the command line arguments to be provided
    // as a String array.
    private String[] s;

    public ParseCmdLineArgs(String[] args) {
        // Your code should go here.
        if (args.length == 0) {
            System.out.println("EMPTY INPUT");
            return;
        }
        s = args;
        for (int i = 0; i < s.length; i++) {

            if (s[i].contains("."))
                System.out.println("Line " + i + " may be a hostname");

            // (v) If it has exactly 3 dots, also append a message that it may be an IPv4
            // address. Various ways of doing this, this just
            // seemed the nost obvious way to me (note the '[' and ']' are needed as split()
            // expects a regular expression).
            if (s[i].split("[.]").length == 4)
                System.out.println("Line " + i + " may be an IPv4 address");
            System.out.println("Arguemrnt line " + i + ": " + s[i]);
            // End the line.
            // System.out.println();
        }

    }

    // main(): This is the function that is called after executing with 'java
    // ParseCmdLineArgs'.
    // Any command line arguments are passed as the string array 'String[] args',
    // i.e. if you execute the code with
    // java ParseCmdLineArgs arg1 arg2 arg3
    // then String[] args will be an array of length 3, containing the strings
    // 'arg1', arg2', and arg3.'
    public static void main(String[] args) {
        ParseCmdLineArgs parser = new ParseCmdLineArgs(args);
    }
}