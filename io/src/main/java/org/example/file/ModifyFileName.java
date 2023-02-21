package org.example.file;

import java.io.File;

public class ModifyFileName {
    public static void main(String[] args) {
        modifyFileName("D:\\记录\\funnel\\dev\\");
    }
    public static void modifyFileName(String filePath){
        File file = new File(filePath);
        File[] files = file.listFiles();
        if (file.exists() && file.isDirectory()) {
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                //  将文件保存回aaa文件夹，也可存放在其他你需要保存的地方
                File dest = new File(filePath + name.replace(".txt", ".sql"));
                files[i].renameTo(dest);
                System.out.println(dest.getName());
            }
        }

    }
}
