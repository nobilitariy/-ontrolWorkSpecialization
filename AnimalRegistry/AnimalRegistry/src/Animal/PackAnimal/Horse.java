package Animal.PackAnimal;

import java.time.LocalDate;
import java.util.List;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthDate, List<String> commands){
       super(name, birthDate, commands);
    }
    @Override
    public String toString() {
        
        return "Лошадь." + super.toString();
    }
}
