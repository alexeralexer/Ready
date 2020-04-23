package com.VER_3;

public class CommandLineArgumentsSupplier implements ArgumentsSupplier {

    private String[] argumentsArray;

    public CommandLineArgumentsSupplier(String[] argumentsArray) {
        this.argumentsArray = argumentsArray;
    }

    @Override
    public Arguments processArguments() throws ArgumentsException {

        if (argumentsArray != null && argumentsArray.length == 4) {
            String directory = argumentsArray[0];
            String reportFile = (argumentsArray[1] + "/" + argumentsArray[2] + ".txt");
            String extend = argumentsArray[3];
            System.out.println("Список файлов c расширением (" + argumentsArray[3] + ")");
            return new Arguments(directory, reportFile, extend);
        } else if (argumentsArray != null && argumentsArray.length == 3) {
            String directory = argumentsArray[0];
            String reportFile = (argumentsArray[1] + "/" + argumentsArray[2] + ".txt");
            String extend = "";
            System.out.println("Не введен аргумент для поиска файлов с заданным расширением\nСписок всех папок и файлов в каталоге:");
            return new Arguments(directory, reportFile, extend);
        }
        throw new ArgumentsException();
    }
}