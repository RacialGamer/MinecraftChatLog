package github.racialgamer.latestchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LatestChatLog {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getenv("APPDATA") + "/.minecraft/logs/latest.log"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(System.getenv("APPDATA") + "/.minecraft/logs/latestchat.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("[System] [CHAT]")) {
                    String chatMessage = line.substring(line.indexOf("[System] [CHAT]") + 15);
                    writer.write(chatMessage);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
