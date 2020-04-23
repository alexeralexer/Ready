package com.VER_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDescriptionWriter extends ScanWriter {

    private File report;

   public FileDescriptionWriter(String reportFile){
       this.report = new File(reportFile);
   }

    @Override
    public void write(File file, Long size) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(report, true));
        if (file.isFile()) pw.println(super.getInfoFile(file, size));
        else {
            pw.println("---------------------------");
            pw.println(super.getInfoDirectory(file, size));
            pw.println("---------------------------");
        }
        pw.close();
    }
}
