package task1801;

import java.io.*;

import static java.io.File.separator;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        FileInputStream imp = null;
        int maxByte = Integer.MIN_VALUE;

        try {
            imp = new FileInputStream(filename);
            int currentByte;
            while ((currentByte = imp.read()) != -1) {
                if (currentByte > maxByte) {
                    maxByte = currentByte;
                }
            }
            System.out.println(maxByte);
        } finally {
            if (imp !=null) {
                try {
                    imp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } br.close();
        }



        //        String sep = separator;
//        String pyt = separator + "E:" + separator + "zadania" + separator + "7mod" + separator + "io-nio-main";
//        File file = new File(pyt);
//        System.out.println(file);


    }
}
