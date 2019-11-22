package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 4
 * Условие:
 *  На плоскости заданы своими координатами n точек.
 *  Написать метод (методы), определяющие, между какими из пар точек
 *  самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Task38 {
    public static void main(String[] args) {
        Task38 solution = new Task38();
        int[] coords = solution.generateRandomCoords();
        solution.printCoords(coords);
        solution.calcMaxDist(coords);
    }

    public int[] generateRandomCoords() {
        // Определение количества точек (от 3 до 10 включительно).
        final int N = (int) (3 + Math.random() * 8);

        // Определение координат точек (на прямых X и Y от -15 до 15 включительно).
        int[] coords = new int[N * 2];
        for (int i = 0; i < coords.length; i++) {
            coords[i] = (int) (Math.random() * 31) - 15;
        }

        return coords;
    }

    public void printCoords(int[] coords) {
        System.out.println("Number of dots = " + coords.length / 2);
        System.out.print("Dots' coordinates:");
        for (int i = 0, j = 1; i + 1 < coords.length; i += 2, j++) {
            System.out.printf("\nx(%d) = %d", j, coords[i]);
            System.out.printf("\ny(%d) = %d", j, coords[i + 1]);
        }
    }

    // Метод определяет максимальное расстояние.
    public void calcMaxDist(int[] coords) {
        double maxDist = 0;
        for (int i = 0; i + 1 < coords.length - 2; i += 2) {
            for (int j = i + 2; j + 1 < coords.length; j += 2) {
                double dist = Math.sqrt(Math.pow(coords[j] - coords[i], 2) + Math.pow(coords[j + 1] - coords[i + 1], 2));
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }
        checkDotsForMaxDist(maxDist, coords);
    }

    // Метод выявляет, между какими из пар точек самое большое расстояние.
    private void checkDotsForMaxDist(double maxDist, int[] coords) {
        System.out.println("\nGreatest distance is " +  Math.round(maxDist * 1000d) / 1000d);
        System.out.println("Such a distance is between the following dots:");
        for (int i = 0; i + 1 < coords.length - 2; i += 2) {
           for (int j = i + 2; j + 1 < coords.length; j += 2) {
                double dist = Math.sqrt(Math.pow(coords[j] - coords[i], 2) + Math.pow(coords[j + 1] - coords[i + 1], 2));
                if (dist == maxDist) {
                    printMaxDots(i, j, coords[i], coords[i + 1], coords[j], coords[j + 1]);
                }
            }
        }
    }

    // Метод выводит эти пары на консоль.
    private void printMaxDots(int i, int j, int aX, int aY, int bX, int bY) {
        int dotOne = i / 2 + 1;
        int dotTwo = j / 2 + 1;
        System.out.printf("x(%d) = %d\ny(%d) = %d\nx(%d) = %d\ny(%d) = %d", dotOne, aX, dotOne, aY, dotTwo, bX, dotTwo, bY);
    }
}