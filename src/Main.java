import java.io.*;

public class Main extends regX {
    public static void main(String[] args) {
        String pattern, st, space = " ";
        int line = 1;
        regX re = new regX();

        String pattern_file_name = "pattern.txt";
        String text_file_name = "text.txt";
        String line_seperated_temporary_file_name = "sepout.txt";
        String output_file_name = "patternmatch.txt";

        try {
            BufferedReader readerp = new BufferedReader(new FileReader(pattern_file_name));
            BufferedReader readert = new BufferedReader(new FileReader(text_file_name));
            BufferedWriter writeri = new BufferedWriter(new FileWriter(line_seperated_temporary_file_name));
            BufferedWriter writerm = new BufferedWriter(new FileWriter(output_file_name));

            writerm.write("\n#################################################################\n" +
                    "#################################################################\n" +
                    "#################################################################\n" +
                    "##### \t\t\t\t\t\t\t    ##### \n" +
                    "##### \t\t\t\t\t\t\t    ##### \n" +
                    "#####    The below mentioned line numbers are the lines     #####\n" +
                    "#####   separated by \",\" and \".\" in the input file text,    #####\n" +
                    "#####           the separated lines are also  \t\t    #####\n" +
                    "#####        first written to the " + line_seperated_temporary_file_name + " file.         #####\n"
                    +
                    "##### \t\t\t\t\t\t\t    #####\n" +
                    "##### \t\t\t\t\t\t\t    ##### \n" +
                    "#################################################################\n" +
                    "#################################################################\n" +
                    "#################################################################\n\n\n");
            writerm.close();

            pattern = readerp.readLine();
            readerp.close();

            while ((st = readert.readLine()) != null) {
                String[] res = st.split("[,.]", 0);

                for (String text : res) {
                    if (text.charAt(0) == space.charAt(0)) {
                        text = text.substring(1);
                    }
                    writeri.write(text + "\n");
                    re.regX(pattern, text, line);
                    line++;
                }
            }
            writeri.close();
            readert.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}