package org.example;

import org.example.Exceptions.WrongParamException;
import org.example.Users.Client;
import org.example.Users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongParamException {
        startAction();
    }

    static ArrayList<User> userArrayList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String userName = null;
    static String userPhoneNumber = null;
    static String userLogin=null;
    static String userPassword=null;

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
            while (userName == null || userLogin==null||userPassword==null||userPhoneNumber==null) {
                if (userName == null) {
                    System.out.print("Введите имя: ");
                    userName = scan.nextLine();
                    checkInfo(userName);
                }
                if(userLogin==null){
                    System.out.print("Введите логин: ");
                    userLogin=scan.nextLine();
                    checkInfo(userLogin);
                }
                if (userPassword==null){
                    System.out.print("Введите Пароль: ");
                    userPassword=scan.nextLine();
                    checkInfo(userPassword);
                }
                if(userPhoneNumber==null){
                    System.out.print("Введите Номер телефона: ");
                    userPhoneNumber=scan.nextLine();
                    checkInfo(userPhoneNumber);
                }
                if (userName!=null&&userLogin!=null&&userPassword!=null&&userPhoneNumber!=null){
                    userArrayList.add(new Client(userName,userPhoneNumber,id,userLogin,userPassword));
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

    }
}


