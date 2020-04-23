package com.VER_1;

import java.io.IOException;

public class ScanTest {

    public static void main(String[] args) throws IOException {

        String directory = args[0];          // каталог для сканирования (вводит пользователь)
        String fold = args[1];               // путь для сохранения (вводит пользователь)
        String nameAllFiles = args[2];       // имя файла для сохранения всех файлов (вводит пользователь)
        String nameExtFiles = args[3];       // имя файла для сохранения файлов с расширением (вводит пользователь)
        String extend = args[4];             // тип расширением для поиска в каталоге (вводит пользователь)

        var arguments = new Arguments(directory, fold, nameAllFiles, nameExtFiles, extend);
        arguments.logExistingDrives();
        arguments.argumentsSupplier();
    }
}
