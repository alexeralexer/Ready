package com.VER_2;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileScanner {

    private final Arguments arguments;
    private Collection<ScanWriter> writers;

    public FileScanner(Arguments arguments, Collection<ScanWriter> writers) {
        this.arguments = arguments;
        this.writers = writers;
    }

    public void execute() throws IOException {
        File file = new File(arguments.getDirectory());
        for (ScanWriter s : writers) {
            if (arguments.getExtend().equals("")) s.write(file);
            else s.findFiles(file);
        }
    }
}