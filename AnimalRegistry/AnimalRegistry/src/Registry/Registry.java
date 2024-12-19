package Registry;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;

public class Registry{

    private Controller controller;
    private AddAnimals addAnimals;

    public Registry(){
       this.addAnimals = new AddAnimals();
       this.controller = new Controller(this);
    }

    Scanner scanner = new Scanner(System.in);
    public void start() {
        System.out.println("Выберите команду из списка:\n1. Внести животное в список\n2. Просмотреть список животных\n3. Посмотреть список комманд выбранного животного\n(Сделайте выбор указав цифру комманды ниже)");

        switch (getValidInteger()) {
            case 1:
                System.out.println(controllerAddAnimal());
                start();
            default:
                break;
        }
        
    }

    private int getValidInteger() {
        while (true) {
            try {
                int numberTeamCommand = scanner.nextInt();
                scanner.nextLine();
                if (numberTeamCommand > 0 && numberTeamCommand < 4) {
                    return numberTeamCommand;
                }else{
                    System.out.println("Пожалуйста, введите целое число от 1 до 3");
                    scanner.nextLine();
                } 
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите целое число от 1 до 3");
                scanner.nextLine();
            }
        }
    }



    private String controllerAddAnimal() {
        int numberTeam = addAnimals.getNumberTeam();
        String nickName = addAnimals.getNickName();
        LocalDate birthDate = addAnimals.getBirthDate();
        List<String> commands = addAnimals.getHasMoreCommands();
        return controller.addAnimal(numberTeam, nickName, birthDate, commands);
    }

    

    public void readAnimals() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAnimals'");
    }

    public void readAnimalCommand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAnimalCommand'");
    }    
}
