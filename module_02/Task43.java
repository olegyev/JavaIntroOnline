package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 9
 * Условие:
 *  Даны числа X, Y, Z, T - длины сторон четырехугольника.
 *  Написать метод (методы), вычисления его площади,
 *  если угол между сторонами длиной X и Y - прямой.
 */

public class Task43 {
    public static void main(String[] args) {
        double x = Math.round(generateRandomLength() * 100d) / 100d;
        double y = Math.round(generateRandomLength() * 100d) / 100d;
        double z = Math.round(generateRandomLength() * 100d) / 100d;
        double t = Math.round(calcT(x, y, z) * 100d) / 100d;

        double s = Math.round(calcQuadrangleArea(x, y, z, t) * 100d) / 100d;
        System.out.println("x = " + x + ", y = " + y + ", z = " + z + ", t = " + t);
        System.out.println("Area = " + s);
    }

    // От 1 включительно до 20 исключительно.
    public static double generateRandomLength() {
        return 1 + Math.random() * 19;
    }

    // Вычисляет длину стороны t, чтобы получился прямоугольник.
    public static double calcT(double x, double y, double z) {
        double h = calcHypotenuse(x, y);
        double angleZtoH = generateRandomAngleZtoH();
        double angleRadians = Math.toRadians(angleZtoH);
        return Math.sqrt(Math.pow(h, 2) + Math.pow(z, 2) - 2 * h * z * Math.cos(angleRadians));
    }

    // Вычисляет площадь четырехугольника по длинам его сторон и двум противолежащим углам
    // (один из которых - прямой угол между сторонами X и Y).
    public static double calcQuadrangleArea(double x, double y, double z, double t) {
        final double RIGHT_ANGLE = 90;
        double oppositeAngle = calcOppositeAngle(z, t, calcHypotenuse(x, y));
        double p = calcHalfPerimeter(x, y, z, t);
        double anglesRadians = Math.toRadians((RIGHT_ANGLE + oppositeAngle) / 2);
        return Math.sqrt((p - x) * (p - y) * (p - z) * (p - t) - x * y * z * t * Math.pow(Math.cos(anglesRadians), 2));
    }

    private static double calcHypotenuse(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static double generateRandomAngleZtoH() {
        return (1 + Math.random() * 178);
    }

    // Вычисляет угол между сторонами Z и T, противолежащий прямому углу между сторонами X и Y.
    private static double calcOppositeAngle(double z, double t, double h) {
        double d = (Math.pow(z, 2) + Math.pow(t, 2) - Math.pow(h, 2)) / (2 * z * t);
        return Math.toDegrees(Math.acos(d));
    }

    private static double calcHalfPerimeter(double x, double y, double z, double t) {
        return (x + y + z + t) / 2;
    }
}