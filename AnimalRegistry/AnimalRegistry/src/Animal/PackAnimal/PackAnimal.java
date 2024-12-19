package Animal.PackAnimal;

import java.time.LocalDate;
import java.util.List;

import Animal.Animal;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
    
}
