package com.VER_2;

import java.io.File;
import java.util.Objects;

class ConsoleDescriptionWriter extends ScanWriter {

    private String ext;
    private String extend;

    public ConsoleDescriptionWriter(String extend){
        this.extend = extend;
        ext = extend.toLowerCase();
    }

    public void write(File folder) {

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                System.out.println(files + " Недоступная папка !!!");
            } else if (files.isFile()) {
                System.out.println(super.getInfoFile(files));
            } else if (files.isDirectory()) {
                System.out.println(super.getInfoDirectory(files));
                write(files);
            }
        }
    }

    public void findFiles(File folder) {

        for (File files : Objects.requireNonNull(folder.listFiles((new ConsoleDescriptionWriter(extend))))) {  //(new ConsoleDescriptionWriter(extend))
            System.out.println(super.getInfoFile(files));
        }
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (f.isDirectory() && f.listFiles() != null) {
                findFiles(f);
            }
        }
    }

    @Override
    public boolean accept(File folder, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}

