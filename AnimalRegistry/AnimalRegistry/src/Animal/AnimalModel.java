package Animal;


import java.time.LocalDate;
import java.util.List;

import Animal.PackAnimal.*;
import Animal.Pets.*;
import Controller.Controller;

public class AnimalModel {
    private Controller controller;
    private Animal animal;


    public AnimalModel(Controller controller){
        this.controller = controller;
        this.animal  = new Animal();
    }
    public String addAnimal(int numberTeam, String nickName, LocalDate birthDate, List<String> commands){
        Animal animal = createAnimal(numberTeam, nickName, birthDate, commands);
        return animal.saveToFile(animal);
    }

    private Animal createAnimal(int numberTeam, String nickName, LocalDate birthDate, List<String> commands) {
        switch (numberTeam) {
            case 1: return new Dog(nickName, birthDate, commands);
            case 2: return new Cat(nickName, birthDate, commands);
            case 3: return new Hamster(nickName, birthDate, commands);
            case 4: return new Camel(nickName, birthDate, commands);
            case 5: return new Donkey(nickName, birthDate, commands);
            case 6: return new Horse(nickName, birthDate, commands);
            default: return null;
        }       
    }   
}
