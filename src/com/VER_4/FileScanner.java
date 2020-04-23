package com.VER_4;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

public class FileScanner implements FilenameFilter {

    private Arguments arguments;
    private Collection<ScanWriter> writers;
    private String ext;

    public FileScanner(Arguments arguments, Collection<ScanWriter> writers) {
        this.arguments = arguments;
        this.writers = writers;
    }

    public FileScanner(String extend) {
        ext = extend.toLowerCase();
    }

    public void execute() throws IOException {
        File file = new File(arguments.getDirectory());
        if (arguments.getExtend().equals("")) scannerAllFiles(file);
        else scannerExtFiles(file, arguments.getExtend());
    }

    public void scannerOut(File file, Long size) throws IOException {
        for (ScanWriter writer : writers) {
            writer.write(file, size);
        }
    }

    public void scannerAllFiles(File folder) throws IOException {  // Поиск в каталоге всех папок и файлов

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                scannerOut(files, files.length());
            } else if (files.isFile()) {
                scannerOut(files, files.length());
            } else if (files.isDirectory()) {
                scannerOut(files, getFolderSize(files));
                scannerAllFiles(files);
            }
        }
    }

    public void scannerExtFiles(File folder, String extend) throws IOException { // Поиск в каталоге файлов с заданным расширением

        for (File files : Objects.requireNonNull(folder.listFiles(new FileScanner(extend)))) {
            scannerOut(files, files.length());
        }
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory() && file.listFiles() != null) {
                scannerExtFiles(file, extend);
            }
        }
    }

    public long getFolderSize(File folder) {  // Измерение размера папки со всеми вложениями
        long size = 0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                size += file.length();
            } else if (file.isDirectory() && file.listFiles() != null) {
                size += getFolderSize(file);
            }
        }
        return size;
    }

    @Override
    public boolean accept(File file, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}