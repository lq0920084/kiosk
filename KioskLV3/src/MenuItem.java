public class MenuItem {
    //값을 저장할 변수를 선언합니다.
    private int Order=1;
    private String Name;
    private double Price;
    private String Description;

    //생성자를 작성합니다.
    public MenuItem(String Name, double Price, String Description){
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
    }

    //getter를 정의합니다.
    public String getName(){
        return this.Name;
    }

    public double getPrice(){
        return this.Price;
    }
    public String getDescription(){
        return this.Description;
    }
    public int getOrder(){
        return this.Order;
    }
    //순서를 1 추가합니다.
    public void setOrder(int Order){
        this.Order=Order+1;
    }
}
