package Animal.Pets;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pets{
    public Dog(String name, LocalDate birthDate, List<String> commands){
        super(name, birthDate, commands);
    }

    @Override
    public String toString() {
        
        return "Собака." + super.toString();
    }
}
