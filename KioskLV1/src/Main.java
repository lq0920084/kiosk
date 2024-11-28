import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //메뉴 선택 입력받기
        Scanner MenuSelect = new Scanner(System.in);
        //종료 여부를 확인할 변수를 선언합니다.
        boolean End = false;
        //스캐너로부터 받은 데이터를 저장합니다.
        int data = 0;
        //메뉴 목록을 저장할 배열을 선언하고 값을 넣습니다.
        String[] Menu = new String[]{
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
        };
        //초기 메뉴 데이터를 출력합니다.
        System.out.println("[ SHAKESHACK MENU ]");
        for (String menu : Menu) {
            System.out.println(menu);
        }
        System.out.println("0. 종료      | 종료");

        //반복문을 실행합니다.
        do {
            //입력받은 스캐너의 값을 변수에 넣습니다.
            data = MenuSelect.nextInt();

            //입력받은 값에 따라 스위치를 사용하여 로직을 실행합니다.
            switch (data) {
                case 0: {
                    End = true;
                    break;
                }
                case 1: {
                    System.out.println(Menu[data - 1]);
                    break;
                }
                case 2: {
                    System.out.println(Menu[data - 1]);
                    break;
                }
                case 3: {
                    System.out.println(Menu[data - 1]);
                    break;
                }
                case 4: {
                    System.out.println(Menu[data - 1]);
                    break;
                }
                default: {
                    System.out.println("값이 유효하지 않습니다.");
                }
            }


        } while (!End);
    }
}

