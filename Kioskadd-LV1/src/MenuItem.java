public class MenuItem {
    //값을 저장할 변수를 선언합니다.
    private int order =1;
    private String name;
    private double price;
    private String description;
    private int quantity=1;

    //생성자를 작성합니다.
    public MenuItem(String Name, double Price, String Description){
        this.name = Name;
        this.price = Price;
        this.description = Description;
    }

    //getter를 정의합니다.
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }
    public int getOrder(){
        return this.order;
    }
    //순서를 1 추가합니다.
    public void setOrder(int Order){
        this.order =Order+1;
    }

    //수량 getter, setter를 설정합니다.
    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int Quantity){
        this.quantity = Quantity;
    }
}
