package com.VER_5;

import java.io.File;

public class ConsoleDescriptionWriter extends ScanWriter {

    @Override
    public void write(File file, Long size) {
        if (file.isFile())
            System.out.println(super.getInfoFile(file, size));
        else {
            System.out.println("---------------------------");
            System.out.println(super.getInfoDirectory(file, size));
            System.out.println("---------------------------");
        }
    }
}





