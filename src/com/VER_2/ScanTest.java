package com.VER_2;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ScanTest {

    public static void main(String[] args) throws IOException {

        String[] arg = new String[]{"D:/Загрузки", "D:/", "Test", "bin"};  // для проверки не из консоли

        CommandLineArgumentsSupplier.logExistingDrives();
        ArgumentsSupplier argumentsSupplier = new CommandLineArgumentsSupplier(arg);
        Arguments arguments = argumentsSupplier.processArguments();
        Collection<ScanWriter> writers = List.of(new FileDescriptionWriter(arguments.getReportFile(), arguments.getExtend()),
                new ConsoleDescriptionWriter(arguments.getExtend()));
        FileScanner scanner = new FileScanner(arguments, writers);
        scanner.execute();

    }
}
