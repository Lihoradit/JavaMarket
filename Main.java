package org.example;

import org.example.Exceptions.WrongParamException;
import org.example.Users.Client;
import org.example.Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws WrongParamException {
        loadData(usersFile, objectType.Users);
        startAction();
    }

    static File usersFile = new File("/Users/Horde/IdeaProjects/JavaException/src/main/java/org/example/Clients");
    static File ordersFile = new File("/Users/Horde/IdeaProjects/JavaException/src/main/java/org/example/Products");
    static ArrayList<User> userArrayList = new ArrayList<>();
    static ArrayList<Product> orderArrayList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String userLogin = null;
    static String userPassword = null;

    enum objectType {
        Users, Products;
    }

    public static void loadData(File file, objectType type) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] fileLine = new String[3];
            String str;
            while ((str = br.readLine()) != null) {
                fileLine = str.split(";");
                switch (type) {
                    case Products:
                        orderArrayList.add(new Product(Integer.parseInt(fileLine[0]), fileLine[1], Integer.parseInt(fileLine[2])));
                        break;
                    case Users:
                        userArrayList.add(new Client(Integer.parseInt(fileLine[0]), fileLine[1], fileLine[2]) {
                        });

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден или не открывается" + e);
        } catch (IOException e) {
            System.out.println("Проблема с чтением/запись" + e);
        } catch (NumberFormatException e) {
            System.out.println("Неккоректное значение" + e);
        }
    }

    static void readData(File file) {
        switch (file.getName()) {
            case "Clients.txt":
                loadData(file, objectType.Users);
                break;
            case "Orders.txt":
                loadData(file, objectType.Products);
                break;
            default:
                System.out.println("Неккоректное имя файла");
                break;
        }
    }

    public static void startAction() throws WrongParamException {
        boolean act = true;
        int attempt = 3;
        int id = userArrayList.size();
        int autorizationChoise = 0;

        System.out.println("Добрый день!!!! Добро пожаловать в магазин Эльдорадо!");
        System.out.println("Выберите действие");
        System.out.println("1. Авторизоваться в аккаунт \n 2. Создать аккаунт");

        while (autorizationChoise == 0 || autorizationChoise >= 3) {
            try {
                autorizationChoise = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        if (autorizationChoise == 2) {
            System.out.print("Введите Имя: ");
            while (userLogin == null || userPassword == null) {
                if (userLogin == null) {
                    System.out.print("Введите логин: ");
                    userLogin = scan.nextLine();
                    checkInfo(userLogin);
                }
                if (userPassword == null) {
                    System.out.print("Введите Пароль: ");
                    userPassword = scan.nextLine();
                    checkInfo(userPassword);
                }
                if (userLogin != null && userPassword != null) {
                    userArrayList.add(new Client(id, userLogin, userPassword));
                    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile, true));
                    ) {
                        PrintWriter fileWriter = new PrintWriter(bufferedWriter);
                        fileWriter.println(userArrayList.size()-1 + ";" + userLogin + ";" + userPassword);
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println("Файл для записи не найден" + e);
                    }

                    System.out.println("Аккаунт успешно создан");
                }
            }


        }


    }

    public static void checkInfo(String info) throws WrongParamException {
        if (info.isEmpty()) {
            throw new WrongParamException("Поле не должно быть пустым!");
        }
        if (info.isBlank()) {
            throw new WrongParamException("Тебя мать в паспорте тоже пробелами заполнила?");
        }
        if (info.length() > 20) {
            throw new WrongParamException("Поле не должно превышать 20 символов");
        }
        for (User user : userArrayList) {
            if (Objects.equals(user.getLogin(), info)) {
                throw new WrongParamException("Логин занят");
            }
        }

    }

}


