package com.VER_1;

import java.io.File;
import java.util.Objects;

class ConsoleWriter extends Writers{

    public ConsoleWriter(File folder, String name1, String name2, String ext) {
        super(folder, name1, name2, ext);
    }

    public void filesFolder(File folder) {

        Writers writers = new Writers(folder, name1, name2, ext);

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                System.out.println(files + " Недоступная папка !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            } else if (files.isFile()) {
                System.out.println(writers.getInfoFile(files));
            } else if (files.isDirectory()) {
                System.out.println(writers.getInfoDirectory(files));
                filesFolder(files);
            }
        }
    }
}

