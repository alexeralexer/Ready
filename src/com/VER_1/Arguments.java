package com.VER_1;

import java.io.File;
import java.io.IOException;

public class Arguments {

    private String directory;
    private String fold;
    private String nameAllFiles;
    private String nameExtFiles;
    private String extend;

    public Arguments(String directory, String fold, String nameAllFiles, String nameExtFiles, String extend) {
        this.directory = directory;
        this.fold = fold;
        this.nameAllFiles = nameAllFiles;
        this.nameExtFiles = nameExtFiles;
        this.extend = extend;
    }

    public void logExistingDrives() {
        File[] roots = File.listRoots();
        System.out.println("Доступные диски для сканирования:");
        for (File list : roots)
            System.out.println(list.getAbsoluteFile() + " , SIZE: " + list.getTotalSpace() + " Byte");
        System.out.println();
    }

    public void argumentsSupplier() throws IOException {

        String name1 = (fold + "\\" + nameAllFiles + ".txt");
        String name2 = (fold + "\\" + nameExtFiles + ".txt");
        String ext = "." + extend;
        File folder = new File(directory);

        if (!folder.exists()) {
            System.out.println("Каталог не найден!!!");
        } else if (folder.isDirectory() && folder.length() == 0) {
            System.out.println("В каталоге нет файлов!!!");
        } else {
            System.out.println("Каталог найден");
            var writers = new Writers(folder, name1, name2, ext);
            writers.write();
        }
    }
}
