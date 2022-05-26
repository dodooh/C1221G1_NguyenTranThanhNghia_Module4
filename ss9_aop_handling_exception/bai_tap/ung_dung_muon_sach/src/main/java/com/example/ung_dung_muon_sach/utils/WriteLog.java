package com.example.ung_dung_muon_sach.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteLog {

    public static void write(String filePath, String logs) {
        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(logs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
