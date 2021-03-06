package com.mapr.demos.filewatcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class NativeDirectoryWatcherExample {
 
    public static void main(String[] args) throws InterruptedException, IOException {

        WatchService watchService = FileSystems.getDefault().newWatchService();
 
        Path path = Paths.get("/mapr/dmitry001.hpe.com/user/mapr/tmp/folder");

        path.register(
          watchService, 
            StandardWatchEventKinds.ENTRY_CREATE,
              StandardWatchEventKinds.ENTRY_DELETE, 
                StandardWatchEventKinds.ENTRY_MODIFY);
 
        WatchKey key;
        while ((key = watchService.take()) != null) {
            System.out.println("take: " + key);
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                  "Event kind:" + event.kind() 
                    + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }

    }
}