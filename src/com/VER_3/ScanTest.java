package com.VER_3;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ScanTest {

    public static void main(String[] args) throws IOException {

        String[] arg = new String[]{};  // для проверки не из консоли
        //String[] arg = new String[]{"D:/Загрузки", "D:/", "Tester", "bin"};  // для проверки не из консоли

        ScanUtils.logExistingDrives();
        ArgumentsSupplier argumentsSupplier = new CommandLineArgumentsSupplier(arg);
        Arguments arguments = argumentsSupplier.processArguments();
        Collection<ScanWriter> writers = List.of(new ConsoleDescriptionWriter(), new FileDescriptionWriter(arguments.getReportFile()));
        FileScanner scanner = new FileScanner(arguments, writers);
        scanner.execute();

    }
}
