package task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file1 = br.readLine();
            String file2 = br.readLine();

        FileInputStream bym = null;
        FileOutputStream out = null;
        try{
            bym = new FileInputStream(file1);
            byte[] mass = new byte[bym.available()];
            int count = bym.read(mass);

            out = new FileOutputStream(file2);
            for (int i = count-1;i>=0;i--){
                out.write(mass[i]);
            }

        } finally {
            if(bym!=null){
                try {
                    bym.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    bym.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
