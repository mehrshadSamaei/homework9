package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("select your practice");
                System.out.println("practice 1 and 2 enter 1 or 2\n" +
                        "practic 3 enter 3 \n" +
                        "practic 4 enter 4 \n" +
                        "practic 5 enter 5" +
                        "practice 6 for exit");
                int numSelect = in.nextInt();

                switch (numSelect) {
                    case 1:
                        getPracticeOneAndTwo();
                        break;
                    case 2:
                        practicOneAndTwo();
                        break;
                    case 3:
                        getPracticeTree();
                        break;
                    case 4:
                        getPracticefour();
                        break;
                    case 5:
                        getPracticeFive();
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        throw new RuntimeException("incorect num");
                }
            } catch (Exception e) {
                System.out.println("plz inter number!!!");
                flag = false;
            }
        }

    }

    private static void practicOneAndTwo() {
        getPracticeOneAndTwo();
    }

    private static void getPracticeOneAndTwo() {
        String[] name = new String[]{"Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen"};
        Map<Integer, List<String>> listMap = Stream.of(name)
                .collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(listMap);
        listMap.forEach((Integer, String)
                -> System.out.println("number of charchter" +
                Integer + " name " + listMap.get(Integer).size()));
    }

    private static void getPracticeTree() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("enter first num");
            double num1 = input.nextDouble();
            System.out.println("enter second num");
            double num2 = input.nextDouble();
            BiFunction<Double, Double, Double> biFunction = (firstNumD, secondNumD) -> {
                return ((firstNumD + secondNumD) / 2);
            };
            Double ave = biFunction.apply(num1, num2);
            System.out.println("result average");
            System.out.println(ave);
        } catch (RuntimeException e) {
            System.out.println("enter num no String");
        }
    }

    private static void getPracticefour() {
        Scanner in = new Scanner(System.in);
        System.out.println("plz enter your word");
        String word = in.next();
        Supplier<Boolean> booleanSupplier = () -> word.substring(0, 1).equals(word.substring(word.length() - 1));
        System.out.println(booleanSupplier.get());
    }

    private static void getPracticeFive() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);
        numbers.stream()
                .filter(val -> val > 1)
                .forEach(System.out::println);

    }
}
