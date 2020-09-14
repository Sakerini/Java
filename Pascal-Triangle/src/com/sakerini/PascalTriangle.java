package com.sakerini;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    private int lines;
    private List<List<Integer>> triangle;

    public PascalTriangle(int lines) {
        this.lines = lines;
        triangle = new ArrayList<>();
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void initTriangle() {
        for (int i = 0; i < lines; i++) {
            triangle.add(new ArrayList<Integer>());

            if (i == 0) {
                triangle.get(i).add(0, 1);
                continue;
            }
            triangle.get(i).add(0, 1);
            for (int j = 0; j < i-1; j++) {
                    triangle.get(i).add(0);
            }
            triangle.get(i).add(i, 1);
        }
        makePascal();
    }
    public int getPascalSumm(int i, int j) {
        return triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j - 1);
    }

    public void makePascal() {
        System.out.println();
        for(int i = 2; i < lines; i++) {
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                triangle.get(i).set(j, getPascalSumm(i, j));
            }
        }
    }

    public void drawTriangle() {
        for (int i = 0; i < lines; i++) {
            System.out.println(triangle.get(i).toString());
        }
    }
}
