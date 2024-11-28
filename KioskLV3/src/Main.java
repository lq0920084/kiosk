
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //데이터를 넣을 키오스크 객체를 생성합니다.
        Kiosk kiosk = new Kiosk(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack",68.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger",5.4," 비프패티를 기반으로 야채가 들어간 기본버거"));

        kiosk.start();



    }
}

