
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //메뉴 선택 입력받기
        Scanner menuselect = new Scanner(System.in);
        //종료 여부를 확인할 변수를 선언합니다.
        boolean end = false;
        //스캐너로부터 받은 데이터를 저장합니다.
        int data = 0;
        //메뉴 목록을 저장할 어레이리스트을 선언하고 값을 넣습니다.
        List<MenuItem> menudata = new ArrayList<>();
        menudata.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menudata.add(new MenuItem("SmokeShack",68.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menudata.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menudata.add(new MenuItem("Hamburger",5.4," 비프패티를 기반으로 야채가 들어간 기본버거"));
        //순서를 설정합니다.
        for(int i=0;i<menudata.size()-1;i++){
            menudata.get(i+1).setOrder(menudata.get(i).getOrder());
        }
        //초기 메뉴 데이터를 출력합니다.
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menudata) {
            System.out.println(menu.getOrder()+". "+menu.getName()+"   | W "+menu.getPrice()+" | "+menu.getDescription());
        }
        System.out.println("0. 종료      | 종료");

        //반복문을 실행합니다.
        do {
            //입력받은 스캐너의 값이 숫자인지 확인합니다.
                data = menuselect.nextInt();


            //입력받은 값에 따라 스위치를 사용하여 로직을 실행합니다.
            switch (data) {
                case 0: {
                    end = true;
                    break;
                }
                case 1: {
                    System.out.println(menudata.get(data-1).getOrder()+". "+menudata.get(data-1).getName()+"   | W "+menudata.get(data-1).getPrice()+" | "+menudata.get(data-1).getDescription());
                    break;
                }
                case 2: {
                    System.out.println(menudata.get(data-1).getOrder()+". "+menudata.get(data-1).getName()+"   | W "+menudata.get(data-1).getPrice()+" | "+menudata.get(data-1).getDescription());
                    break;
                }
                case 3: {
                    System.out.println(menudata.get(data-1).getOrder()+". "+menudata.get(data-1).getName()+"   | W "+menudata.get(data-1).getPrice()+" | "+menudata.get(data-1).getDescription());
                    break;
                }
                case 4: {
                    System.out.println(menudata.get(data-1).getOrder()+". "+menudata.get(data-1).getName()+"   | W "+menudata.get(data-1).getPrice()+" | "+menudata.get(data-1).getDescription());
                    break;
                }
                default: {
                    System.out.println("값이 유효하지 않습니다.");
                }
            }


        } while (!end);
    }
}

