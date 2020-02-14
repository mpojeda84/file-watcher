package com.mapr.demos.filewatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomDirectoryWatcherExample {
 
    public static void main(String[] args) throws InterruptedException, IOException {


        while(true) {
            Path path = Paths.get("/mapr/dmitry001.hpe.com/user/mapr/tmp/folder");
            Files.list(path).forEach(file -> {

            });
        }


    }
}