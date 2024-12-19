package Animal.Pets;

import java.time.LocalDate;
import java.util.List;

import Animal.Animal;

public abstract class Pets extends Animal {
    public Pets (String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}
