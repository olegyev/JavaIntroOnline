package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 3
 * Условие:
 *  Вычислить площадь правильного шестиугольника со стороной a,
 *  используя метод вычисления площади треугольника.
 */

public class Task37 {
    public static void main(String[] args) {
        Task37 solution = new Task37();
        int a = solution.generateRandomNum();
        double area = solution.calcHexagonArea(a);

        System.out.println("a = " + a + "\nHexagon area is " + Math.round(area * 1000d) / 1000d);
    }

    public int generateRandomNum() {
        return (int) (1 + (Math.random() * 100)); // от 1 до 100 включительно
    }

    public double calcHexagonArea(int a) {
        return 6 * calcTriangleArea(a);
    }

    private double calcTriangleArea(int a) {
        return (a * a * Math.sqrt(3)) / 4;
    }
}