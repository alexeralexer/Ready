package com.VER_1;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Writers {

    protected File folder;
    protected String name1;
    protected String name2;
    protected String ext;

    public Writers(File folder, String name1, String name2, String ext) {
        this.folder = folder;
        this.name1 = name1;
        this.name2 = name2;
        this.ext = ext;
    }

    public Writers(String ext) {
    }

    public void write() throws IOException {
        System.out.println("Общий список папок и файлов в каталоге:");
        var consoleWrite = new ConsoleWriter(folder, name1, name2, ext);
        consoleWrite.filesFolder(folder);
        var fileWrite = new FilesWriter(folder, name1, name2, ext);
        fileWrite.filesFolder(folder);
        System.out.println("\nСписок файлов с выбранным расширением:");
        var select = new SelectWrite(folder, name1, name2, ext);
        select.findFiles(folder);
        System.out.println("Проверка завершена");
    }

    public String getInfoFile (File files) {
        return ("FILE:      " + files.getName() + ", SIZE: " + files.length() + " Byte");
    }

    public String getInfoDirectory (File files) {
        long size = getFolderSize(files);
        return ("DIRECTORY: " + files.getName() + ", SIZE: " + size + " Byte");
    }

    public String getInfoFileSelect (File files) {
        return ("FILE: " + files.getName() + ", SIZE: " + files.length() + " Byte");
    }

    public long getFolderSize(File dir) {  // Измерение размера папки со всеми вложениями
        long size = 0;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile()) {
                //System.out.println(file);
                size += file.length();
            } else if (file.isDirectory() && file.listFiles() != null) {
                //System.out.println(file);
                size += getFolderSize(file);
            }
        }
        return size;
    }
}
