import java.util.ArrayList;
import java.util.List;

public class Menu {
    //메뉴 목록을 저장할 어레이리스트을 선언하고 값을 넣습니다.
    private List<MenuItem> Menu = new ArrayList<>();
    //순서를 관리할 변수를 선언합니다.
    private int Order=0;


    //키오스크에 초기 데이터를 넣을 생성자를 지정합니다.
    public Menu(MenuItem ... menu){
        for(MenuItem MenuData : menu){
            setMenu(MenuData);
        }
    }

    //키오스크 메뉴 에 값을 추가하는 setMenu 메서드를 정의합니다.
    public void setMenu(MenuItem menu){
        this.Menu.add(menu);
        menu.setOrder(this.Order);
        this.Order=menu.getOrder();
    }
    //리스트 내용을 출력합니다.
    public void getItem(){
        for(MenuItem menu: Menu) {
            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());

        } }

    //리스트 객체를 반환합니다.
    public List getList(){
        return this.Menu;
    }
}
