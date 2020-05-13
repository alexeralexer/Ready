package com.SCAN;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

public class FileScanner {

    private Arguments arguments;
    private Collection<ScanWriter> writers;

    public FileScanner(Arguments arguments, Collection<ScanWriter> writers) {
        this.arguments = arguments;
        this.writers = writers;
    }

    public void execute() throws IOException {
        File folder = new File(arguments.getDirectory());
        scanDirectoryRecursive(folder);
    }

    public void scannerOut(File file, Long size) throws IOException {
        for (ScanWriter writer : writers) {
            writer.write(file, size);
        }
    }

    public void scanDirectoryRecursive(File folder) throws IOException {

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                scannerOut(files, files.length());
            } else if (files.isFile() && files.getName().endsWith(arguments.getExtend())) {
                scannerOut(files, files.length());
            } else if (files.isDirectory() && arguments.getExtend().equals("")) {
                scannerOut(files, getFolderSize(files));
                scanDirectoryRecursive(files);
            } else if (files.isDirectory()) {
                scanDirectoryRecursive(files);
            }
        }
    }

    public long getFolderSize(File folder) throws NullPointerException {
        long size = 0;
        try {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory() && file.listFiles() != null) {
                    size += getFolderSize(file);
                }
            }
            return size;
        } catch (NullPointerException ignored) {}
        return size;
    }
}