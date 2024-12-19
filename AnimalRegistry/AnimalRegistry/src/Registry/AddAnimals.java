package Registry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddAnimals {

    Scanner scanner = new Scanner(System.in);

    public List<String> getHasMoreCommands() {
        List<String> commands = new ArrayList<>();
        System.out.println("Введите команду, которую умеет выполнять животное:");
        String firstCommand = scanner.nextLine().trim();
        commands.add(firstCommand);
        System.out.println("Введите дополнительную команду (для завершения нажмите Enter без ввода текста):");
        String additionalCommand = scanner.nextLine().trim();
        while (!additionalCommand.isBlank()) {
            commands.add(additionalCommand);
            System.out.println("Введите дополнительную команду (для завершения нажмите Enter без ввода текста):");
            additionalCommand = scanner.nextLine().trim();
        }
        return commands;
    }

    public LocalDate getBirthDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = null;
    while (date == null) {
        System.out.print("Введите дату в формате дд/мм/гггг: ");
        String dateInput = scanner.nextLine();
        try {
            date = LocalDate.parse(dateInput, formatter);
        } catch (Exception e) {
            System.out.print("Перепроверьте написание даты и повторите попытку: ");
        }
    }
    return date;
}


    public String getNickName() {
        String nickName = null;
        while (nickName == null) {
            System.out.println("Введите кличку животного:");
            scanner.nextLine();
            nickName = scanner.nextLine();
        }
        return nickName;
    }

    public int getNumberTeam() {
        int typeOfAnimal = 0;
        boolean isValidType = false;
        
        while (!isValidType) {
            try {
                System.out.println("Какое животное хотите добавить в список:\n 1.Домашнее\n 2.Вьючное\n (Сделайте выбор указав цифру команды ниже)");
                typeOfAnimal = scanner.nextInt();
                
                if (typeOfAnimal == 1 || typeOfAnimal == 2) {
                    isValidType = true;
                } else {
                    System.out.println("Ошибка! Пожалуйста, выберите 1 или 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Пожалуйста, введите число.");
                scanner.nextLine();
            }
        }
        
        int specificAnimal = 0;
        boolean isValidSpecific = false;
        
        while (!isValidSpecific) {
            try {
                if (typeOfAnimal == 1) {
                    System.out.println("Какое домашнее животное хотите добавить в список:\n 1.Собака\n 2.Кот\n 3.Хомяк \n(Сделайте выбор указав цифру команды ниже)");
                    specificAnimal = scanner.nextInt();
                    
                    if (specificAnimal >= 1 && specificAnimal <= 3) {
                        isValidSpecific = true;
                    } else {
                        System.out.println("Ошибка! Пожалуйста, выберите от 1 до 3");
                    }
                } else {
                    System.out.println("Какое вьючное животное хотите добавить в список:\n 4.Верблюд\n 5.Осел \n 6.Лошадь \n(Сделайте выбор указав цифру команды ниже)");
                    specificAnimal = scanner.nextInt();
                    
                    if (specificAnimal >= 4 && specificAnimal <= 6) {
                        isValidSpecific = true;
                    } else {
                        System.out.println("Ошибка! Пожалуйста, выберите от 4 до 6");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Пожалуйста, введите число");
                scanner.nextLine();
            }
        }
        
        return specificAnimal;
    }
}
