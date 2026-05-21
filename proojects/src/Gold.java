public class Gold extends Base{
    private String country;
    private String ageGroup;

    public Gold(int followers,int price, String country, String ageGroup){
        super(followers,price);
        this.country = country;
        this.ageGroup = ageGroup;
    }

    public Gold(){
        super(5000,20);
    }

    public String print(){
        return ("Gold: " + followers() + " followers; " + price() + "€ total price; " + "from " + country + "; age group: "+ ageGroup + "\n");
    }

}
