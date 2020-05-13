package com.VER_5;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ScanTest {

    public static void main(String[] args) throws IOException {

        //String[] arg = new String[]{"D:/Загрузки", "D:/", "Test"};  // для проверки не из консоли
        String[] arg = new String[]{"D:/Загрузки", "D:/", "Test", "exe"};  // для проверки не из консоли

        try {
            ScanUtils.logExistingDrives();
            ArgumentsSupplier argumentsSupplier = new CommandLineArgumentsSupplier(arg);
            Arguments arguments = argumentsSupplier.processArguments();
            Collection<ScanWriter> writers = List.of(new ConsoleDescriptionWriter(), new FileDescriptionWriter(arguments.getReportFile()));
            FileScanner scanner = new FileScanner(arguments, writers);
            scanner.execute();
        } catch (ArgumentsException a) {
            System.out.println(a.getText());
        }
    }
}
