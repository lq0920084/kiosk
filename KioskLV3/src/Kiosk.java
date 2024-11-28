import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //메뉴 목록을 저장할 어레이리스트을 선언하고 값을 넣습니다.
    private List<MenuItem> menu = new ArrayList<>();
    //순서를 관리할 변수를 선언합니다.
    private int order =0;
    //종료 여부를 확인할 변수를 지정합니다.
    private boolean end = false;


    //키오스크에 초기 데이터를 넣을 생성자를 지정합니다.
    public Kiosk(MenuItem ... menu){
        for(MenuItem MenuData : menu){
            setMenu(MenuData);
        }
    }

    //키오스크 메뉴 에 값을 추가하는 setMenu 메서드를 정의합니다.
     public void setMenu(MenuItem menu){
         this.menu.add(menu);
         menu.setOrder(this.order);
         this.order =menu.getOrder();
     }

    //입력받은 값에 따라 스위치를 사용하여 로직을 실행합니다.
    public void start(){
        //값을 받을 스캐너를 선언합니다.
        Scanner menuselect = new Scanner(System.in);
        //서브메뉴에서 메인메뉴로 돌아온 상태인지 오류를 표시한 상태인지 구분합니다.
        boolean reset=true;
        //스캐너의 값을 넣을 변수를 선언합니다.
        int data =5;
        //서브메뉴에 들어갔는지를 판단할 변수를 선언합니다.
        boolean submenu=false;
        //반복문을 실행합니다.
        do {
            if(!submenu&&reset){
                //초기 메뉴 데이터를 출력합니다.
                System.out.println("[ SHAKESHACK MENU ]");
                for (MenuItem menu : menu) {
                    System.out.println(menu.getOrder()+". "+menu.getName()+"   | W "+menu.getPrice()+" | "+menu.getDescription());
                }
                System.out.println("0. 종료      | 종료");
            }
            //입력받은 값을 변수 data에 넣습니다. 만일 숫자가 아닌 경우 오류를 표시합니다.
        try{
            data=menuselect.nextInt();
        }catch(Exception e){
            reset=false;
            System.out.println("잘못된 입력입니다.");
            //무한 반복을 막기 위해 버퍼의 값을 제거합니다.
            menuselect.nextLine();
        }
        if(submenu==false){
        switch (data) {
            case 0: {
                end = true;
                break;
            }
            case 1: {
                System.out.println(menu.get(data-1).getOrder()+". "+ menu.get(data-1).getName()+"   | W "+ menu.get(data-1).getPrice()+" | "+ menu.get(data-1).getDescription());
                System.out.println("0. 뒤로가기      | 뒤로가기");
                submenu=true;
                break;
            }
            case 2: {
                System.out.println(menu.get(data-1).getOrder()+". "+ menu.get(data-1).getName()+"   | W "+ menu.get(data-1).getPrice()+" | "+ menu.get(data-1).getDescription());
                System.out.println("0. 뒤로가기      | 뒤로가기");
                submenu=true;
                break;
            }
            case 3: {
                System.out.println(menu.get(data-1).getOrder()+". "+ menu.get(data-1).getName()+"   | W "+ menu.get(data-1).getPrice()+" | "+ menu.get(data-1).getDescription());
                System.out.println("0. 뒤로가기      | 뒤로가기");
                submenu=true;
                break;
            }
            case 4: {
                System.out.println(menu.get(data-1).getOrder()+". "+ menu.get(data-1).getName()+"   | W "+ menu.get(data-1).getPrice()+" | "+ menu.get(data-1).getDescription());
                System.out.println("0. 뒤로가기      | 뒤로가기");
                submenu=true;
                break;
            }
            default: {
                System.out.println("값이 유효하지 않습니다.");
            }
        }}else {
            //서브메뉴 내부에서 0이 들어올 경우.
            if(data==0){
                submenu=false;
                reset=true;
                //0이 아닌 경우
            }else {
                System.out.println("하위 메뉴에서 다른 메뉴를 선택할 수 없습니다.");
            }
        }
        } while (!end);
    }


}
