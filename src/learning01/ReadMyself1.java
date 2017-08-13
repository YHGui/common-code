package learning01;

import java.io.*;

/**
 * Created by Katsura on 2017/2/23.
 */
public class ReadMyself1 {

    public static void main(String[] args) {
        BufferedReader br = null;
        StringWriter sw  =  new StringWriter();
        try {
           br = new BufferedReader(new FileReader("src/learning01/ReadMyself.java"));
            String line = null;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                sw.write(line);
                sw.write("\n");
            }

            System.out.println(sw.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
