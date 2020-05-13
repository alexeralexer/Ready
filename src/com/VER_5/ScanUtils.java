package com.VER_5;

import java.io.File;

public class ScanUtils {
    public static void logExistingDrives() {
        File[] roots = File.listRoots();
        System.out.println("Доступные диски для сканирования:");
        for (File list : roots)
            System.out.println(list.getAbsoluteFile() + " , SIZE: " + list.getTotalSpace() + " Byte");
        System.out.println();
    }
}
