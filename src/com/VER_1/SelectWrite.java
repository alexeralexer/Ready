package com.VER_1;

import java.io.*;
import java.util.Objects;

class SelectWrite extends Writers implements FilenameFilter {

    String e;

    public SelectWrite(File folder, String name1, String name2, String ext) {
        super(folder, name1, name2, ext);
    }

    public SelectWrite(String ext) {
        super(ext);
        e = ext.toLowerCase();
    }

    public boolean accept(File folder, String name) {
        return name.toLowerCase().endsWith(e);
    }

    public void findFiles(File folder) throws IOException {

        Writers writers = new Writers(folder, name1, name2, ext);
        File file = new File(name2);
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));

        for (File files : Objects.requireNonNull(folder.listFiles((new SelectWrite(ext))))) {
            System.out.println(writers.getInfoFileSelect(files));
            pw.println(writers.getInfoFileSelect(files));
        }
        pw.close();
        for (File b : Objects.requireNonNull(folder.listFiles())) {
            if (b.isDirectory() && b.listFiles() != null) {
                findFiles(b);
            }
        }
    }
}

