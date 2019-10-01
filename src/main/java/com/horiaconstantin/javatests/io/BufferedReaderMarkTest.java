package com.horiaconstantin.javatests.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;

public class BufferedReaderMarkTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("large_corporates_20180207.csv")));
        List<LineStats> lineStats = generateStats(br, ';');
    }

    private static List<LineStats> generateStats(BufferedReader br, Character separatorChar) throws IOException {
        List<LineStats> lineStats = new Vector<>();
        String line;
        int rows = 0;
//        br.mark(32765);
        br.mark(100000);
        while ((line = br.readLine()) != null && rows < 100) {
            LineStats stats = new LineStats(line, separatorChar);
            rows++;
            lineStats.add(stats);
        }
        br.reset();
        return lineStats;
    }
}
