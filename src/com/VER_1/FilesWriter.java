package com.VER_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

class FilesWriter extends Writers{

    public FilesWriter(File folder, String name1, String name2, String ext) {
        super(folder, name1, name2, ext);
    }

    public void filesFolder(File folder) throws IOException {

        Writers writers = new Writers(folder, name1, name2, ext);
        File file = new File(name1);
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                pw.println(files + " Недоступная папка !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            } else if (files.isFile()) {
                pw.println(writers.getInfoFile(files));
            } else if (files.isDirectory()) {
                pw.println("------------------------------------");
                pw.println(writers.getInfoDirectory(files));
                pw.println("------------------------------------");
                filesFolder(files);
            }
        }
        pw.close();
    }
}
