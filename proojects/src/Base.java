public class Base {
    private int followers;
    private int price;


    public Base(int followers,int price){
        this.followers = followers;
        this.price = price;
    }

    public Base(){
        followers = 500;
        price = 5;
    }

    public int followers(){
        return followers;
    }
    public int price(){
        return price;
    }

    public String print(){
        return ("Base: " + followers + " followers; " + price + "€ total price; " + "\n");
    }



}
