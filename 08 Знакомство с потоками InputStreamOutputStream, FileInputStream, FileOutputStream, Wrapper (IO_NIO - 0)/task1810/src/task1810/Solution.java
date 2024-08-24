package task1810;

import java.io.*;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Requirements:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String filename;
                try{
                    filename = br.readLine();
                    if(filename==null){
                        break;
                    }
                } catch (IOException e){
                    System.err.println("Ошибка, такого файла не существует: "+e.getMessage());
                    continue;
                }
                FileInputStream pyk = null;
                try{
                    pyk = new FileInputStream(filename);
                    File file = new File(filename);
                    if (file.length() < 1000) {
                        throw new DownloadException();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                   if(pyk!=null){
                       try{
                           pyk.close();
                       } catch (IOException e){
                           e.printStackTrace();
                       }
                    }
                }
            }
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static class DownloadException extends Exception {
        public DownloadException(){
            super("Файл меньше 1000 байт 8-)");
        }

    }
}
