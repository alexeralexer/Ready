package com.VER_2;

import java.io.File;

public class CommandLineArgumentsSupplier implements ArgumentsSupplier {

    private String[] argumentsArray;

    public CommandLineArgumentsSupplier(String[] argumentsArray) {
        this.argumentsArray = argumentsArray;
    }

    public static void logExistingDrives() {
        File[] roots = File.listRoots();
        System.out.println("Доступные диски для сканирования:");
        for (File list : roots)
            System.out.println(list.getAbsoluteFile() + " , SIZE: " + list.getTotalSpace() + " Byte");
        System.out.println();
    }

    @Override
    public Arguments processArguments() throws ArgumentsException {

        if (argumentsArray != null && argumentsArray.length == 4) {
            String directory = new ArgumentsException().checkAndGetDirectory(argumentsArray[0]);
            String reportFile = (argumentsArray[1] + "/" + argumentsArray[2] + ".txt");
            String extend = argumentsArray[3];
            System.out.println("Список файлов c расширением (" + argumentsArray[3] + ")");
            return new Arguments(directory, reportFile, extend);
        } else if (argumentsArray != null && argumentsArray.length == 3) {
            String directory = new ArgumentsException().checkAndGetDirectory(argumentsArray[0]);
            String reportFile = (argumentsArray[1] + "/" + argumentsArray[2] + ".txt");
            String extend = "";
            System.out.println("Не введен аргумент для поиска файлов с заданным расширением\nСписок всех папок и файлов в каталоге:");
            return new Arguments(directory, reportFile, extend);
        } else {
            throw new ArgumentsException("ERR");
        }
    }
}