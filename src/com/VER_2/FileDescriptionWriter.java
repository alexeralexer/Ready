package com.VER_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

class FileDescriptionWriter extends ScanWriter {

    private String reportFile;
    private String ext;
    private String extend;

    public FileDescriptionWriter(String reportFile, String extend) {
        this.reportFile = reportFile;
        this.extend = extend;
        ext = extend.toLowerCase();
    }

    public void write(File folder) throws IOException {

        File file = new File(reportFile);
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));

        for (File files : Objects.requireNonNull(folder.listFiles())) {
            if (files.isDirectory() && files.listFiles() == null) {
                pw.println(files + " Недоступная папка !!!");
            } else if (files.isFile()) {
                pw.println(super.getInfoFile(files));
            } else if (files.isDirectory()) {
                pw.println("------------------------------------");
                pw.println(super.getInfoDirectory(files));
                pw.println("------------------------------------");
                write(files);
            }
        }
        pw.close();
    }

    public void findFiles(File folder) throws IOException {

        File file = new File(reportFile);
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));

        for (File files : Objects.requireNonNull(folder.listFiles())) {     //(new ConsoleDescriptionWriter(extend))
            pw.println(super.getInfoFile(files));
        }
        pw.close();
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
