package FileHandling;
import java.io.*;
/*
Problem Statement:
You are required to create a C++ program that obfuscates a short story by converting each character into its corresponding ASCII value and stores these values in a text file. The program should also be able to read the stored ASCII values from the file and convert them back into the original story.

Requirements:
1. Write Functionality:
    - Implement a function void writeStoryToFile(const string& story, const string& filename) that takes a story as a string and a filename as inputs.
    - The function should convert each character of the story into its ASCII value and store these values in the specified file, separated by spaces.

2. Read Functionality:
    - Implement a function string readStoryFromFile(const string& filename) that takes a filename as input.
    - The function should read the ASCII values from the file, convert them back into their respective characters, and return the reconstructed story as a string.

3. Main Function:
    - The main function should demonstrate the functionality by:
        - Defining a short story as a string.
        - Calling writeStoryToFile to store the story in a file.
        - Calling readStoryFromFile to read the story back from the file.
        - Printing the retrieved story to verify it matches the original.

Example:
1. *Input Story*: "A simple story.\n"
2. *Stored in File*: `65 32 115 105 109 112 108 101 32 115 116 111 114 121 46 10 ` (ASCII values separated by spaces)
3. *Output Story*: "A simple story.\n"

Constraints:
- The story can contain any printable ASCII characters, including spaces and punctuation.
- The filename should be a valid file path that the program can access for reading and writing.

Expected Output:
The program should output the original story after reading it back from the file, confirming that the obfuscation and de-obfuscation processes are working correctly.

This problem tests your knowledge of file handling, character encoding, and basic string manipulation in C++. Implement the functions as described and ensure that the program correctly reads and writes the obfuscated story data.
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name :");
        String file = sc.next();
        System.out.println(readFromfile(file));
//        writeStorytofile("hey I am habeeba" , file);

    }
    public static void writeStorytofile(String story , String filename){
        try{
            FileWriter file = new FileWriter(filename);
//            file.write("this is file");
            for(int i = 0; i < story.length(); i++){
                char ch = story.charAt(i);
                int c = ch;
                file.write(String.valueOf(c) + String.valueOf(' ') );
            }
            file.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static String  readFromfile(String filename){

        StringBuilder str = new StringBuilder();
        try{
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            str = new StringBuilder();
            while(reader.hasNext()){
//                char ch = (Integer.parseInt(reader.next()));
                str.append(reader.next());
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        return str.toString();
    }

}
