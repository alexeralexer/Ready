package com.VER_4;

import java.io.File;
import java.io.IOException;

public abstract class ScanWriter {

    public abstract void write(File file, Long size) throws IOException;

    public String getInfoFile(File files, Long size) {
        return ("FILE:      " + files.getName() + ", SIZE: " + size + " Byte");
    }

    public String getInfoDirectory(File files, Long size) {
        return ("DIRECTORY: " + files.getName() + ", SIZE: " + size + " Byte");
    }
}
