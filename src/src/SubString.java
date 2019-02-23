import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubString {
    private static String[] findSubStrings(String s) {
        int length = s.length();
        String[] result = new String[length * (length + 1) / 2];
        //print all substrings with length j
        int counter = 0;
        for (int j = 1; j <= length; j++) {
            // start from index = 0 to index = length - j to compute all substrings with length j
            for (int index = 0; index + j <= length; index++) {
                result[counter] = s.substring(index, index + j);
                counter++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        String[] textLines = new String[lines];
        for (int i = 0; i < lines; i++) {
            textLines[i] = sc.next();
        }

        // getting all substrings of first string
        String[] subStrings = findSubStrings(textLines[0]);
        for (int i = 1; i < textLines.length; i++) {
            for (int k = 0; k < subStrings.length; k++) {

                // here we try to remove unused sub strings among all the strings
                if (!subStrings[k].equals("") && !textLines[i].contains(subStrings[k]) && !textLines[i].contains(new StringBuilder(subStrings[k]).reverse().toString())) {
                    subStrings[k] = "";
                }
            }
        }
        // as sub strings are inserted into the array from shortest to longest, the first occurrence of a non-empty string from end of the array
        // is the longest sub string among all strings
        for (int j = subStrings.length - 1; j >= 0; j--) {
            if (!subStrings[j].equals("")) {
                System.out.println(subStrings[j]);
                break;
            }
        }
    }
}
