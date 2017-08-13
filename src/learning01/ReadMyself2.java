package learning01;

import java.io.*;

/**
 * Created by Katsura on 2017/2/23.
 */
public class ReadMyself2 {

    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            byte[] buffer = new byte[256];
            bis = new BufferedInputStream(new FileInputStream("src/learning01/200.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("src/learning01/create.jpg"));
            int length = -1;
            int total = 0;
            while ((length = bis.read(buffer)) != -1){
                //total += length;
                bos.write(buffer, 0, length);
            }
            bos.flush();
            //System.out.println(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
