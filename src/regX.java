import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.exit;

public class regX extends KMP {

    static boolean status = false;

    void regX(String pattern, String string, int line) {
        boolean check = false;
        int index = 0, count = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '|') {
                check = true;
                index = i;
                count++;
            }
        }

        try {
            BufferedWriter writerm = new BufferedWriter(new FileWriter("patternmatch.txt", true));

            if (count > 1) {
                System.out.println("You can use '|' only one time of your pattern please check your pattern again !!!");
                writerm.write(
                        "You can use '|' only one time of your pattern please check your pattern again !!!" + "\n");
                exit(1);
            }

            if (check == true) {
                regX(pattern.substring(0, index), string, line);
                if (status == false)
                    regX(pattern.substring(index + 1, pattern.length()), string, line);
            } else if (pattern.charAt(0) == '^') {
                pattern = pattern.substring(1);

                if (pattern.length() <= string.length()) {
                    for (int i = 0; i < pattern.length(); i++) {
                        if (pattern.charAt(i) == string.charAt(i)) {
                            if (i == pattern.length() - 1) {
                                System.out.println("Pattern '" + pattern + "' found at index 0 line " + line);
                                writerm.write("Pattern '" + pattern + "' found at index 0 line " + line + "\n");
                            }
                        } else {
                            System.out.println("Nothing found at line " + line);
                            writerm.write("Nothing found at line " + line + "\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("Nothing found at line " + line);
                    writerm.write("Nothing found at line " + line + "\n");
                }
            } else if (pattern.charAt(pattern.length() - 1) == '$') {
                pattern = pattern.substring(0, pattern.length() - 1);

                if (pattern.length() <= string.length()) {
                    for (int i = pattern.length() - 1, j = string.length() - 1; i >= 0; i--, j--) {
                        if (pattern.charAt(i) == string.charAt(j)) {
                            if (i == 0) {
                                System.out.println("Pattern '" + pattern + "' found at index " + j + " line " + line);
                                writerm.write("Pattern '" + pattern + "' found at index " + j + " line " + line + "\n");
                            }
                        } else {
                            System.out.println("Nothing found at line " + line);
                            writerm.write("Nothing found at line " + line + "\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("Nothing found at line " + line);
                    writerm.write("Nothing found at line " + line + "\n");
                }
            } else {
                status = KMP(pattern, string, line);
                if (status == false) {
                    System.out.println("Nothing found at line " + line);
                    writerm.write("Nothing found at line " + line + "\n");
                }
            }
            writerm.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}