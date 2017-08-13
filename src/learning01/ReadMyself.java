package learning01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Katsura on 2017/2/23.
 */
public class ReadMyself {

    public static void main(String[] args) {
        File f = new File("src/learning01/ReadMyself.java");
        FileReader fr = null;
        //intelliJ idea 的作用
//        System.out.println(f.exists());
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.canRead());
//        System.out.println(f.canWrite());
//        System.out.println(f.canExecute());
        //可读可写可执行
        try {
            fr = new FileReader(f);
            char[] buffer = new char[10];
            int length = -1;
            while ((length = fr.read(buffer)) != -1) {
                if (length == 10) {
                    System.out.print(buffer);
                } else {
                    System.out.print(new String(buffer, 0, length));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

//读取的时候不一定每次长度都为10
    }

}
