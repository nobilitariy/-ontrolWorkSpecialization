package Animal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Animal {
    protected String name;
    protected LocalDate db;
    protected List<String> commands;
    protected static final String fileAnimal = "AnimalsData.txt";
    protected File file;
    protected Pattern pattern = Pattern.compile("\\|(\\d+)\\.\\|");
    
    public Animal(){}

    public Animal(String name, LocalDate birthDate, List<String> commands) {
        this.name = name;
        this.db = birthDate;
        this.commands = commands;

    }

    protected String getCommand() {
        if (!commands.isEmpty()) {
            StringBuilder commandsAnimal = new StringBuilder();
            int sizeList = commands.size();
            for (int i = 0; i < sizeList; i++) {
                String command = commands.get(i);
                commandsAnimal.append(command);
                if (i < sizeList - 1) {
                    commandsAnimal.append(", ");
                } else {
                    commandsAnimal.append(".");
                }
            }
            return commandsAnimal.toString();
        } else {
        return "животное не обучено ни одной из команд.";
        }
    }
    public String toString() {
        return " Кличка животного: " + name + ", дата рождения: " + db + ", cписок комманд: " + getCommand();
    }
    
    public String saveToFile(Animal animal) {
        File file = new File(fileAnimal);
        createIfNotExists(file);
        String index = "|" + getNextIndex(file) + ".|";
        String record = String.format("%s %s%n", index, animal.toString());
        return writeRecord(file, record);
    }
    
    private void createIfNotExists(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Не удалось создать файл", e);
            }
        }
    }
    
    private int getNextIndex(File file) {
        int index = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(pattern.matcher(line).find()) index++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла, повторите попытку");
        }
        return index + 1;
    }
    
    private String writeRecord(File file, String record) {
        try (FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter))) {
            printWriter.append(record);
            return "Все прошло успешно";
        } catch (IOException e) {
            return "Что-то пошло не так, попробуйте снова";
        }
    }
}
