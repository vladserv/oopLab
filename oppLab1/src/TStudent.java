public class TStudent extends TPerson {
    private final String group;
    private final String kurs;

    public TStudent(String surname, String name, String patronymic, String group, String kurs){
        super(surname, name, patronymic);
        this.group = group.toUpperCase();
        if(Integer.parseInt(kurs) < 1 || Integer.parseInt(kurs) >= 5){
            throw new NumberFormatException();
        }else {
            this.kurs = kurs;
        }
    }

    public String getFullData(){
        return super.getFullData() + " " + this.group + " " + this.kurs;
    }

}
