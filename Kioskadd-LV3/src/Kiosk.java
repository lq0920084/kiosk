import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //각 값을 저장할 리스트를 선언합니다.
    private List<MenuItem> burgers;
    private List<MenuItem> drinks;
    private List<MenuItem> desserts;
    //종료 여부를 확인할 변수를 지정합니다.
    private boolean end = false;
    //값을 받을 스캐너를 선언합니다.
    private Scanner menuSelect = new Scanner(System.in);
    //현재 메뉴 위치를 확인할 변수를 지정합니다.
    private int now_menu = 0;
    //선택된 값을 임시 저장할 변수를 만듭니다.
    private int now_select = 0;
    //현재 선택된 메뉴의 개수를 저장할 변수를 지정합니다.
    private int select_menu_size = 10;
    //스캐너의 값을 넣을 변수를 선언합니다.
    private int data = 5;
    //장바구니에 물건이 들어있는지를 구분할 변수를 선언합니다.
    private boolean add_order = false;
    //장바구니를 저장할 어레이리스트를 선언합니다.
    private List<MenuItem> add_order_data = new ArrayList<>();
    // 장바구니에 담기 전 임시로 보관해둘 변수를 선언합니다.
    private int order_temp = 0;
    //총금액을 합산할 임시 변수 선언.
    private int order_price = 0;
    //삭제할 값의 이름을 받을 임시함수를 선언합니다.
    private String rawdata = "";
    //숫자를 받을때와 문자를 받을때를 구분합니다.
    private boolean number_input=false;
    private boolean string_input=false;
    //관리자 암호를 설정합니다.
    private String pw = "";
    //관리자 암호를 확인할 입력 변수를 선언합니다.
    private String check_pw = "";
    //메뉴추가시 데이터를 받을 변수를 선언합니다.
    String add_name="",add_desc="";
    double add_price=0.0;

    private enum discount {
        cat1(0.9), cat2
                (0.95), cat3(0.97), cat4(1);
        private double discount;

        discount(double discount) {
            this.discount = discount;
        }

        public double getDiscount() {
            return this.discount;
        }
    }

    //할인율 셋팅.
    discount price_discount = discount.cat1;

    //버거목록 리스트를 가져옵니다.
    public void setBurgers(List<MenuItem> burgers) {
        this.burgers = burgers;
    }

    //음료목록 리스트를 가져옵니다.
    public void setDrinks(List<MenuItem> drinks) {
        this.drinks = drinks;
    }

    //디저트목록 리스트를 가져옵니다.
    public void setDesserts(List<MenuItem> desserts) {
        this.desserts = desserts;
    }


    //입력받은 값에 따라 스위치를 사용하여 로직을 실행합니다.
    public void start() {


        //반복문을 실행합니다.
        do {
            if(pw.equals("")&&rawdata.equals("")){
                string_input=true;
                System.out.println("Booting...");
                try {
                    Thread.sleep(4000);
                    System.out.println("최초 부팅 상태입니다. 새로운 관리자 비밀번호를 설정해주세요.");
                    System.out.println("관리자 비밀번호: ");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(pw.equals("")){
                pw = rawdata;
            }else if(check_pw.equals("")){
                check_pw=rawdata;
            }
            if (now_menu == 0&&!pw.equals("")) {
                //초기 메뉴 데이터를 출력합니다.
                System.out.println("[ MAIN MENU ]");
                System.out.println("1. Burgers");
                System.out.println("2. Drinks");
                System.out.println("3. Desserts");
                System.out.println("0. 종료      | 종료");
                if (add_order == true) {
                    System.out.println(" ");
                    System.out.println("[ ORDER MENU ]");
                    System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
                }
                System.out.println("999. 환경설정 ");
                string_input=false;
                number_input=true;
                now_menu = 1;
            } else if (now_menu == 1) {
                if (data == 0) {
                    end = true;
                } else {
                    if (data < 4||data==999) {
                        now_select = data;
                    } else if (add_order = true && (data == 4 || data == 5)) {
                        now_select = data;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }

                    now_menu = 2;
                }

            } else if (now_menu == 3) {
                if (data == 0) {
                    now_menu = 0;
                } else if (data <= select_menu_size) {
                    now_menu = 4;
                }
            } else if (now_menu == 5) {
                switch (data) {
                    case 1: {
                        //장바구니에 선택한 메뉴를 추가합니다.
                        if (now_select == 1) {
                            if (add_order_data.indexOf(burgers.get(order_temp)) == -1) {
                                add_order_data.add(burgers.get(order_temp));
                            } else {
                                add_order_data.get(add_order_data.indexOf(burgers.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(burgers.get(order_temp))).getQuantity() + 1);
                            }
                            System.out.println(burgers.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;

                        } else if (now_select == 2) {
                            if (add_order_data.indexOf(drinks.get(order_temp)) == -1) {
                                add_order_data.add(drinks.get(order_temp));
                            } else {
                                add_order_data.get(add_order_data.indexOf(drinks.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(drinks.get(order_temp))).getQuantity() + 1);
                            }
                            System.out.println(drinks.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;
                        } else {
                            if (add_order_data.indexOf(desserts.get(order_temp)) == -1) {
                                add_order_data.add(desserts.get(order_temp));
                            } else {
                                add_order_data.get(add_order_data.indexOf(desserts.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(desserts.get(order_temp))).getQuantity() + 1);
                            }
                            System.out.println(desserts.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;
                        }
                        number_input=false;
                        add_order = true;
                        break;
                    }
                    case 2: {
                        now_menu = 2;
                        break;
                    }
                    default: {
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }
                }
            }

            if (now_menu == 2) {
                switch (now_select) {
                    case 1: {
                        System.out.println("[ BURGERS MENU ]");

                        burgers.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        select_menu_size = burgers.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 2: {
                        System.out.println("[ DRINKS MENU ]");
                        drinks.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        select_menu_size = drinks.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 3: {
                        System.out.println("[ DESSERTS MENU ]");
                        desserts.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        select_menu_size = desserts.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 4: {
                        System.out.println("[  Orders ]");
                        add_order_data.stream().forEach(order -> {
                            System.out.println(order.getName() + "   | W " + order.getPrice() + " | " + order.getDescription() + " | 수량 :" + order.getQuantity());
                            order_price = (int) (order.getPrice() * 10 * order.getQuantity()) + order_price;
                        });
                        System.out.println(" ");
                        System.out.println("[  Total ]");
                        System.out.println("W " + (double) order_price / 10);
                        System.out.println(" ");
                        System.out.println("1.주문    2.메뉴판");
                        now_menu = 6;
                        break;
                    }
                    case 5: {
                        System.out.println("주문을 삭제합니다.");
                        System.out.println("1. 전체 삭제   2. 부분 삭제");
                        now_menu = 8;
                        break;
                    }
                    case 999: {
                        System.out.println("설정된 관리자 비밀번호를 입력해주세요.");
                        number_input=false;
                        string_input=true;
                        now_menu=1000;
                        break;
                    }
                }
            } else if (now_menu == 8) {
                switch (data) {
                    case 1: {
                        order_price = 0;
                        number_input=false;
                        now_menu = 0;
                        add_order = false;
                        add_order_data.clear();
                        System.out.println("모든 값이 삭제되었습니다.");
                        break;
                    }
                    case 2: {
                        System.out.println("삭제할 항목을 입력해주세요.");
                        add_order_data.stream().forEach(order -> {
                            System.out.println(order.getName() + "   | W " + order.getPrice() + " | " + order.getDescription() + " | 수량 :" + order.getQuantity());
                        });
                        string_input=true;
                        number_input=false;
                        now_menu=10;
                        break;
                    }
                    default: {
                        System.out.println("삭제할 항목을 잘못 지정하셨습니다.");
                    }
                }
            } else if (now_menu == 10) {
                //삭제할 목록을 넣을 임시 객체 생성.
                List<MenuItem> tempraw = new ArrayList<>();
                add_order_data.stream().filter(t -> {
                    if (t.getName().equals(rawdata) && t.getQuantity() == 1) {
                        System.out.println("삭제되었습니다.");
                        return true;
                    } else if (t.getName().equals(rawdata) && t.getQuantity() > 1) {
                        System.out.println("삭제되었습니다.");
                        t.setQuantity(t.getQuantity() - 1);
                        return false;
                    } else {
                        return false;
                    }
                }).forEach(x -> tempraw.add(x));
                tempraw.stream().forEach(raw -> {
                    add_order_data.remove(raw);
                });
                if(add_order_data.size()==0){
                    order_price = 0;
                    add_order = false;
                    add_order_data.clear();
                }
                string_input=false;
                number_input=false;
                now_menu = 0;
            }else if(now_menu == 1000){
                check_pw=rawdata;
                if(pw.equals(check_pw)){
                    string_input=false;
                    number_input=true;
                    System.out.println("환경 설정");
                    System.out.println("1. 관리자 비밀번호 변경");
                    System.out.println("2. 메뉴 수정.");
                    now_menu=999;
                }else {
                    System.out.println("입력된 관리자 비밀번호가 설정된 값과 다릅니다. 다시 입력해주세요.");
                }
            }else if(now_menu==999){
                switch(data){
                    case 1:{
                        System.out.println("새 암호를 입력해주세요.");
                        string_input=true;
                        number_input=false;
                        pw="";
                        now_menu=0;
                        break;
                    }
                    case 2:{
                        System.out.println("1. Burgers");
                        System.out.println("2. Drinks");
                        System.out.println("3. Desserts");
                        now_menu=997;
                        break;
                    }
                    default : {
                        System.out.println("잘못 입력하셨습니다.");
                    }

                }

            }else if(now_menu==997){
                now_select=data;
                switch (now_select) {
                    case 1: {
                        System.out.println("[ BURGERS MENU ]");

                        burgers.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        System.out.println("1. 메뉴 삭제   2. 메뉴 추가");
                        now_menu = 996;
                        break;
                    }
                    case 2: {
                        System.out.println("[ DRINKS MENU ]");
                        drinks.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        System.out.println("1. 메뉴 삭제   2. 메뉴 추가");
                        now_menu = 996;
                        break;
                    }
                    case 3: {
                        System.out.println("[ DESSERTS MENU ]");
                        desserts.stream().forEach(menu -> {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        });
                        System.out.println("1. 메뉴 삭제   2. 메뉴 추가");
                        now_menu = 996;
                        break;
                    }
                    default : {
                        System.out.println("잘못 선택하셨습니다.");
                        break;
                    }
                }

            }else if(now_menu==996){
                switch(data){
                    case 1: {
                        System.out.println("삭제할 메뉴의 이름을 입력해주세요.");
                        number_input=false;
                        string_input=true;
                        now_menu=995;
                        break;
                    }
                    case 2: {
                        System.out.println("추가할 메뉴의 이름을 입력해주세요.");
                        number_input=false;
                        string_input=true;
                        now_menu=993;
                        break;
                    }

                }
            }else if(now_menu==995){
                String deleteitem = "nodata";
                switch (now_select) {
                    case 1: {
                        for(MenuItem output : burgers){
                            if(output.getName().equals(rawdata)){
                                deleteitem=output.getName();
                            }
                        }
                        break;
                    }
                    case 2: {
                        for(MenuItem output : drinks){
                            if(output.getName().equals(rawdata)){
                                deleteitem=output.getName();
                            }
                        }
                        break;
                    }
                    case 3: {
                        for(MenuItem output : desserts){
                            if(output.getName().equals(rawdata)){
                                deleteitem=output.getName();
                            }
                        }
                        break;
                    }
                }
                System.out.println(deleteitem);
                if(deleteitem.equals(rawdata)){
                number_input=true;
                string_input=false;
                System.out.println("정말로 이 메뉴를 삭제하시겠습니까?");
                System.out.println("1. 예.    2.아니오.");
                now_menu=994;
                }else {
                System.out.println("없는 메뉴입니다.");
                System.out.println("다시 입력해주세요.");
                }
            }else if(now_menu==994){
                switch(data){
                    case 1:{
                        if(now_select==1) {
                            MenuItem delete = burgers.stream().
                                    filter(burger -> burger.getName().equals(rawdata)).
                                    findFirst().get();
                            burgers.remove(delete);
                        }else if(now_select==2){
                            MenuItem delete = drinks.stream().
                                    filter(drink -> drink.getName().equals(rawdata)).
                                    findFirst().get();
                            drinks.remove(delete);
                        }else {
                            MenuItem delete = desserts.stream().
                                    filter(dessert -> dessert.getName().equals(rawdata)).
                                    findFirst().get();
                            desserts.remove(delete);
                        }
                        System.out.println("삭제되었습니다.");
                        now_menu=0;
                        number_input=false;
                        break;
                    }
                    case 2:{
                        System.out.println("취소되었습니다.");
                        number_input=false;
                        now_menu=0;
                        break;
                    }
                    default: {
                        System.out.println("잘못된 입력입니다.");
                        System.out.println("다시 입력해주세요.");
                        break;
                    }
                }


            }else if(now_menu==993){
                add_name=rawdata;
                System.out.println("가격을 입력해주세요.");
                now_menu=992;

            }else if(now_menu==992){
                try{
                    add_price=Double.parseDouble(rawdata);
                    System.out.println("메뉴 설명을 입력해주세요.");
                    now_menu=991;
                }catch(Exception e){
                    System.out.println("잘못입력하셨습니다.");
                    System.out.println("다시 입력해주세요.");
                }

            }else if(now_menu==991){
                add_desc=rawdata;
                System.out.println(add_name + "   | W " + add_price + " | " + add_desc+" 을 정말로 추가하시겠습니까?");
                System.out.println("1. 예    2. 아니오");
                now_menu=990;
                string_input=false;
                number_input=true;
            }else if(now_menu==990){
                switch(data){
                    case 1:{
                        switch(now_select){
                            case 1: {
                                int lastorder=0;
                                for(MenuItem check : burgers){
                                    lastorder=check.getOrder();
                                }
                                burgers.add(new MenuItem(add_name,add_price,add_desc));
                                 burgers.get(lastorder).setOrder(lastorder);
                                break;
                            }
                            case 2: {
                                int lastorder=0;
                                for(MenuItem check : drinks){
                                    lastorder=check.getOrder();
                                }
                                drinks.add(new MenuItem(add_name,add_price,add_desc));
                                drinks.get(lastorder).setOrder(lastorder);
                                break;
                            }
                            case 3: {
                                int lastorder = 0;
                                for (MenuItem check : desserts) {
                                    lastorder = check.getOrder();
                                }
                                desserts.add(new MenuItem(add_name, add_price, add_desc));
                                desserts.get(lastorder).setOrder(lastorder);
                                break;
                            }
                        }
                        System.out.println("추가되었습니다.");
                        number_input=false;
                        now_menu=0;
                        break;
                    }
                    case 2:{
                            number_input=false;
                            now_menu=0;
                            System.out.println("메뉴추가가 취소되었습니다.");
                        break;
                    }
                    default:{
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println("다시 입력해주세요.");
                        break;
                    }


                }

            }

            if (now_menu == 4) {
                if (data >= 1 && data <= select_menu_size) {
                    switch (now_select) {
                        case 1: {
                            System.out.println("선택한 메뉴 : " + burgers.get(data - 1).getOrder() + ". " + burgers.get(data - 1).getName() + "   | W " + burgers.get(data - 1).getPrice() + " | " + burgers.get(data - 1).getDescription());
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인          2. 취소");
                            order_temp = data - 1;
                            break;
                        }
                        case 2: {
                            System.out.println("선택한 메뉴 : " + drinks.get(data - 1).getOrder() + ". " + drinks.get(data - 1).getName() + "   | W " + drinks.get(data - 1).getPrice() + " | " + drinks.get(data - 1).getDescription());
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인          2. 취소");
                            order_temp = data - 1;
                            break;
                        }
                        case 3: {
                            System.out.println("선택한 메뉴 : " + desserts.get(data - 1).getOrder() + ". " + desserts.get(data - 1).getName() + "   | W " + desserts.get(data - 1).getPrice() + " | " + desserts.get(data - 1).getDescription());
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인          2. 취소");
                            order_temp = data - 1;
                            break;
                        }

                    }

                }
                now_menu = 5;
            } else if (now_menu == 6) {
                switch (data) {
                    case 1: {
                        System.out.println("할인 정보를 입력해주세요.");
                        System.out.println("1. 국가유공자 : 10%");
                        System.out.println("2. 군인      : 5%");
                        System.out.println("3. 학생      : 3%");
                        System.out.println("4.일반       : 0%");
                        now_menu = 7;
                        break;
                    }
                    case 2: {
                        System.out.println("결제가 취소 되었습니다.");
                        order_price = 0;
                        now_menu = 0;
                        number_input=false;
                        break;
                    }
                }
            } else if (now_menu == 7) {
                switch (data) {
                    case 1:
                        price_discount = discount.cat1;
                        break;
                    case 2:
                        price_discount = discount.cat2;
                        break;
                    case 3:
                        price_discount = discount.cat3;
                        break;
                    case 4:
                        price_discount = discount.cat4;
                        break;
                    default: {
                        System.out.println("할인 대상을 잘못 지정하셨습니다.");
                    }
                }
                System.out.println("주문이 완료되었습니다. 금액은 W " + (order_price * price_discount.getDiscount()) + " 입니다.");
                number_input=false;
                order_price = 0;
                now_menu = 0;
                add_order = false;
                add_order_data.clear();
            }
            //입력받은 값을 변수 data에 넣습니다. 만일 숫자가 아닌 경우 오류를 표시합니다.
            if (!end && number_input) {
                try {
                    data = menuSelect.nextInt();
                    //버퍼지우기
                    menuSelect.nextLine();
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다.");
                    //무한 반복을 막기 위해 버퍼의 값을 제거합니다.
                    menuSelect.nextLine();
                }
            } else if (string_input) {
                rawdata = menuSelect.nextLine();
            }
        } while (!end);
    }
}
