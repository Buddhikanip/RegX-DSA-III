import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class KMP {
    boolean KMP(String pattern, String string, int line) {
        int lp = pattern.length();
        int ls = string.length();
        int pieT[] = new int[lp];
        int i = 0, j = 0;
        boolean status = false;

        preprocess(pattern, lp, pieT);

        while (i < ls) {
            if (pattern.charAt(j) == string.charAt(i)) {
                j++;
                i++;
            } else if (pattern.charAt(j) != string.charAt(i)) {
                if (j != 0)
                    j = pieT[j - 1];
                else
                    i = i + 1;
            }
            try {
                BufferedWriter writerm = new BufferedWriter(new FileWriter("patternmatch.txt", true));

                if (j == lp) {
                    System.out.println("Pattern '" + pattern + "' found at index " + (i - j) + " line " + line);
                    writerm.write("Pattern '" + pattern + "' found at index " + (i - j) + " line " + line + "\n");
                    j = pieT[j - 1];
                    status = true;
                }
                writerm.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return status;
    }

    void preprocess(String pattern, int len, int table[]) {
        int j = 0, i = 1;
        table[0] = 0;

        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                table[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    table[i] = j;
                    i++;
                }
            }
        }
    }
}