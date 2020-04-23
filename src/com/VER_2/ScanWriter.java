package com.VER_2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Objects;

public abstract class ScanWriter implements FilenameFilter {

    public abstract void write(File file) throws IOException;

    public abstract void findFiles(File file) throws IOException;

    public String getInfoFile(File files) {
        return ("FILE:      " + files.getName() + ", SIZE: " + files.length() + " Byte");
    }

    public String getInfoDirectory(File files) {
        long size = getFolderSize(files);
        return ("DIRECTORY: " + files.getName() + ", SIZE: " + size + " Byte");
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
