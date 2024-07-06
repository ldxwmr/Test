package org.example.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    @Test
    public void create01(){
        String filePath = "D:/test/news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create02(){
        File parentFile = new File("D:/test/");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create03(){
        String parentPath = "D:/test/";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
