public class Silver extends Base {
    private String country;

    public Silver(int followers,int price, String country){
        super(followers,price);
        this.country = country;
    }

    public Silver(){
        super(1000,8);
    }

    public String print(){
        return ("Silver: " + followers() + " followers; " + price() + "€ total price; " + "from " + country + "\n");
    }

}
