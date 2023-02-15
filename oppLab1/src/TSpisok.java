import java.io.*;
import java.util.ArrayList;

public class TSpisok {
    public static final ArrayList<TPerson> persons = new ArrayList<>();

    public static void create() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] personList = line.split(" ");
                switch (personList.length) {
                    case 5 -> addPerson(new TStudent(personList[0], personList[1], personList[2], personList[3], personList[4]));
                    case 4 -> addPerson(new TSotrudnik(personList[0], personList[1], personList[2], personList[3]));
                    case 3 -> addPerson(new TPerson(personList[0], personList[1], personList[2]));
                    default -> {
                        System.out.println("Data error in the file");
                        throw new NullPointerException();
                    }
                }

                line = reader.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            throw new FileNotFoundException("File not found");
        }
    }

    public static void create(String s) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(s));
            String line = reader.readLine();
            while (line != null) {
                String[] personList = line.split(" ");
                switch (personList.length){
                    case 5 -> addPerson(new TStudent(personList[0], personList[1], personList[2], personList[3], personList[4]));
                    case 4 -> addPerson(new TSotrudnik(personList[0], personList[1], personList[2], personList[3]));
                    case 3 -> addPerson(new TPerson(personList[0], personList[1], personList[2]));
                    default -> {System.out.println("Data error in the file"); throw new NullPointerException();}
                }

                line = reader.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            throw new FileNotFoundException("File not found");
        }
    }

    public static void delete(String fileName){
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (TPerson p : persons) {
                writer.write(p.getFullData() + "\n");
            }
            writer.flush();
            persons.clear();
            }catch(IOException exception){
                System.out.println("Error writing to the file");
        }
    }

    public static void addPerson(TPerson p){
        persons.add(p);
    }

    public static Integer kw_pers(){
        return persons.size();
    }

    public static String personListS(Integer n){
        return persons.get(n - 1).getFullData();
    }

    public static TPerson personListP(Integer n){
        return persons.get(n - 1);
    }
}
