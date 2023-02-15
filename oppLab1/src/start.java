import java.io.*;
import java.util.Scanner;

public class start {
    public static void starter() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter name file: ");
        String fileName = in.nextLine();

        if (fileName.equals("")) {
            TSpisok.create();
            fileName = "temp.txt";
        } else {
            TSpisok.create(fileName);
        }

        String fileWork;
        do {
            System.out.println("What do you want to do with the file? (Use help to find out the available commands)");
            fileWork = in.nextLine();

            switch (fileWork) {
                case "add person" -> {
                    System.out.print("Enter new name person: ");
                    String namePersonAdd = in.nextLine();
                    String[] personList = namePersonAdd.split(" ");
                    switch (personList.length) {
                        case 5 -> TSpisok.addPerson(new TStudent(personList[0], personList[1], personList[2], personList[3], personList[4]));
                        case 4 -> TSpisok.addPerson(new TSotrudnik(personList[0], personList[1], personList[2], personList[3]));
                        case 3 -> TSpisok.addPerson(new TPerson(personList[0], personList[1], personList[2]));
                        default -> System.out.println("Data error");
                    }
                }


                case "number of people" -> System.out.println("number of people in file: " + TSpisok.kw_pers());


                case "output person" -> {
                    System.out.print("Enter index: ");
                    int numberS = in.nextInt();
                    try {
                        System.out.println(TSpisok.personListS(numberS));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The entered value is not included in the list");
                    }
                    in.nextLine();
                }



                case "output all people" -> {
                    for (TPerson p : TSpisok.persons) {
                        System.out.println(p.getFullData() + "\n");
                    }
                }


                case "help" -> System.out.println(
                    """
                    -----------------------------------------------------------------------
                    |add person - adds a user to the file                                 |
                    |number of people - outputs the number of people in the file          |
                    |output person - outputs the i-th person                              |
                    |output all people - outputs all people                               |
                    |link to a person - outputs a link to a person                        |
                    |exit - writes data to a file and releases resources                  |
                    -----------------------------------------------------------------------""");


                case "link to a person" -> {
                    System.out.print("Enter index: ");
                    int numberS = in.nextInt();
                    try {
                        System.out.println(TSpisok.personListP(numberS));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("The entered value is not included in the list");
                    }
                    in.nextLine();
                }


                case "exit" -> TSpisok.delete(fileName);


                default -> System.out.println("Unknown command. Use help to find out the available commands");
            }
        } while (!fileWork.equals("exit"));
    }
}
