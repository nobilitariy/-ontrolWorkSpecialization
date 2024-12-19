package Controller;

import java.time.LocalDate;
import java.util.List;

import Animal.AnimalModel;
import Registry.Registry;

public class Controller {
    private AnimalModel animalModel;
    private Registry registry;

    public Controller(Registry registry){
        this.animalModel = new AnimalModel(this);
        this.registry = registry;
    }

    public String addAnimal(int numberTeam, String nickName, LocalDate birthDate, List<String> commands){
        return animalModel.addAnimal(numberTeam, nickName, birthDate, commands);
        
    }
}
