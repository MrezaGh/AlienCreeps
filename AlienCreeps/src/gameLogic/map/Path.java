package gameLogic.map;

import sun.font.FontRunIterator;

import java.util.ArrayList;

public class Path {
    private static ArrayList<int[]> pathHomes1_1 = new ArrayList<>();
    private static ArrayList<int[]> getPathHomes1_2 = new ArrayList<>();
    private static ArrayList<int[]> pathHomes2_1 = new ArrayList<>();
    private static ArrayList<int[]> pathHomes2_2 = new ArrayList<>();
    private static ArrayList<int[][]> pathHomes1 = new ArrayList<>();
    private static ArrayList<int[][]> pathHomes2 = new ArrayList<>();

    public Path() {
        makePathHomes1_1();
        makePathHomes1_2();
        makePathHomes2_1();
        makePathHomes2_2();
    }

    private void makePathHomes1_1() {
        int[] a;
        for (int i = 0; i < 11; i++) {
            a = new int[]{i * 32, 704};
            pathHomes1_1.add(a);
        }
        for (int i = 0; i < 8; i++) {
            a = new int[]{10 * 32, 672 - 32 * i};
            pathHomes1_1.add(a);
        }
        for (int i = 0; i < 12; i++) {
            a = new int[]{(11 + i) * 32, 14 * 32};
            pathHomes1_1.add(a);
        }
        for (int i = 0; i < 13; i++) {
            a = new int[]{22 * 32, (16 + i) * 32};
            pathHomes1_1.add(a);
        }
        for (int i = 0; i < 12; i++) {
            a = new int[]{(23 + i) * 32, 864};
            pathHomes1_1.add(a);
        }
    }

    private void makePathHomes1_2() {
        int[] a;
        for (int i = 0; i < 12; i++) {
            a = new int[]{i * 32, 704 + 32};
            getPathHomes1_2.add(a);
        }
        for (int i = 0; i < 8; i++) {
            a = new int[]{11 * 32, 704 - 32 * i};
            getPathHomes1_2.add(a);
        }
        for (int i = 0; i < 10; i++) {
            a = new int[]{(12 + i) * 32, 15 * 32};
            getPathHomes1_2.add(a);
        }
        for (int i = 0; i < 13; i++) {
            a = new int[]{21 * 32, (16 + i) * 32};
            getPathHomes1_2.add(a);
        }
        for (int i = 0; i < 13; i++) {
            a = new int[]{(23 + i) * 32, 896};
            getPathHomes1_2.add(a);
        }
    }

    /*private void makePathHommes1() {
        int[][] a;
        for (int i = 0; i < 12; i++) {
            a = new int[][]{{i * 32, 704}, {i * 32, 704 + 32}};
            pathHomes1.add(a);
        }
        for (int i = 0; i < 8; i++) {
            a = new int[][]{{10 * 32, 672 - 32 * i}, {11 * 32, 672 - 32 * i}};
            pathHomes1.add(a);
        }
        for (int i = 0; i < 11; i++) {
            a = new int[][]{{(11 + i) * 32, 14 * 32}, {(12 + i) * 32, 15 * 32}};
            pathHomes1.add(a);
        }
        for (int i = 0; i < 13; i++) {
            a = new int[][]{{22 * 32, (16 + i) * 32}, {21 * 32, (16 + i) * 32}};
            pathHomes1.add(a);
        }
        for (int i = 0; i < 12; i++) {
            a = new int[][]{{(23 + i) * 32, 864}, {(23 + i) * 32, 896}};
            pathHomes1.add(a);
        }
    }*/

    private void makePathHomes2() {
        int[][] a;
        for (int i = 0; i < 8; i++) {
            a = new int[][]{{7 * 32, i * 32}, {8 * 32, i * 32}};
            pathHomes2.add(a);
        }
        for (int i = 0; i < 25; i++) {
            a = new int[][]{{(9 + i) * 32, 7 * 32}, {(9 + i) * 32, 6 * 32}};
            pathHomes2.add(a);
        }
    }

    private void makePathHomes2_1() {
        int[] a;
        for (int i = 0; i < 8; i++) {
            a = new int[]{7 * 32, i * 32};
            pathHomes2_1.add(a);
        }
        for (int i = 0; i < 25; i++) {
            a = new int[]{(8 + i) * 32, 7 * 32};
            pathHomes2_1.add(a);
        }
        for (int i = 0; i < 9; i++) {
            a = new int[]{32 * 32, (8 + i) * 32};
            pathHomes2_1.add(a);
        }
        for (int i = 0; i < 3; i++) {
            a = new int[]{(31 - i) * 32, 16 * 32};
            pathHomes2_1.add(a);
        }
        for (int i = 0; i < 12; i++) {
            a = new int[]{29 * 32, (17 + i) * 32};
            pathHomes2_1.add(a);
        }
        for (int i = 0; i < 5; i++) {
            a = new int[]{(30 + i) * 32, 28};
            pathHomes2_1.add(a);
        }
    }

    private void makePathHomes2_2() {
        int[] a;
        for (int i = 0; i < 7; i++) {
            a = new int[]{8 * 32, i * 32};
            pathHomes2_2.add(a);
        }
        for (int i = 0; i < 25; i++) {
            a = new int[]{(9 + i) * 32, 6 * 32};
            pathHomes2_2.add(a);
        }
        for (int i = 0; i < 11; i++) {
            a = new int[]{33 * 32, (8 + i) * 32};
            pathHomes2_2.add(a);
        }
        for (int i = 0; i < 3; i++) {
            a = new int[]{(32 - i) * 32, 18};
            pathHomes2_2.add(a);
        }
        for (int i = 0; i < 10; i++) {
            a = new int[]{30, (19 + i) * 32};
            pathHomes2_2.add(a);
        }
        for (int i = 0; i < 3; i++) {
            a = new int[]{(31 + i) * 32, 28};
            pathHomes2_2.add(a);
        }

    }

    public static ArrayList<int[][]> getPathHomes1() {
        return pathHomes1;
    }

    public static ArrayList<int[][]> getPathHomes2() {
        return pathHomes2;
    }

    public static void setPathHomes1(ArrayList<int[][]> pathHomes1) {
        Path.pathHomes1 = pathHomes1;
    }

}