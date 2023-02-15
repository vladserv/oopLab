public class TSotrudnik extends TPerson{
    private final String serviceNumber;

    public TSotrudnik(String surname, String name, String patronymic, String serviceNumber){
        super(surname, name, patronymic);
        this.serviceNumber = serviceNumber;
    }

    public String getFullData(){
        return super.getFullData() + " " + this.serviceNumber;
    }
}
