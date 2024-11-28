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
    private double order_price = 0;

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

            if (now_menu == 0) {
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

                now_menu = 1;
            } else if (now_menu == 1) {
                if (data == 0) {
                    end = true;
                } else {
                    if (data < 4) {
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
                            if(add_order_data.indexOf(burgers.get(order_temp))==-1) {
                                add_order_data.add(burgers.get(order_temp));
                            }else{
                                add_order_data.get(add_order_data.indexOf(burgers.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(burgers.get(order_temp))).getQuantity()+1);
                            }
                            System.out.println(burgers.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;

                        } else if (now_select == 2) {
                            if(add_order_data.indexOf(drinks.get(order_temp))==-1) {
                                add_order_data.add(drinks.get(order_temp));
                            }else{
                                add_order_data.get(add_order_data.indexOf(drinks.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(drinks.get(order_temp))).getQuantity()+1);
                            }
                            System.out.println(drinks.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;
                        } else {
                            if(add_order_data.indexOf(desserts.get(order_temp))==-1) {
                                add_order_data.add(desserts.get(order_temp));
                            }else{
                                add_order_data.get(add_order_data.indexOf(desserts.get(order_temp))).setQuantity(add_order_data.get(add_order_data.indexOf(desserts.get(order_temp))).getQuantity()+1);
                            }
                            System.out.println(desserts.get(order_temp).getName() + "이 장바구니에 추가되었습니다.");
                            now_menu = 0;
                        }

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
                        for (MenuItem menu : burgers) {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        }
                        select_menu_size = burgers.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 2: {
                        System.out.println("[ DRINKS MENU ]");
                        for (MenuItem menu : drinks) {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        }
                        select_menu_size = drinks.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 3: {
                        System.out.println("[ DESSERTS MENU ]");
                        for (MenuItem menu : desserts) {
                            System.out.println(menu.getOrder() + ". " + menu.getName() + "   | W " + menu.getPrice() + " | " + menu.getDescription());
                        }
                        select_menu_size = desserts.size();
                        System.out.println("0. 뒤로가기");
                        now_menu = 3;
                        break;
                    }
                    case 4: {
                        System.out.println("[  Orders ]");
                        for (MenuItem order : add_order_data) {
                            System.out.println(order.getName() + "   | W " + order.getPrice() + " | " + order.getDescription() + " | 수량 :"+ order.getQuantity());
                            order_price = (int)(order.getPrice()*10*order.getQuantity()) + order_price;
                        }
                        System.out.println(" ");
                        System.out.println("[  Total ]");
                        System.out.println("W " + (double)order_price/10);
                        System.out.println(" ");
                        System.out.println("1.주문    2.메뉴판");
                        now_menu = 6;
                        break;
                    }
                    case 5: {

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
                        System.out.println("주문이 완료되었습니다. 금액은 W " + order_price + " 입니다.");
                        order_price = 0;
                        now_menu = 0;
                        add_order = false;
                        add_order_data.clear();
                        break;
                    }
                    case 2: {
                        System.out.println("취소 되었습니다.");
                        order_price = 0;
                        now_menu = 0;
                        add_order = false;
                        add_order_data.clear();
                    }
                }
            }

            //입력받은 값을 변수 data에 넣습니다. 만일 숫자가 아닌 경우 오류를 표시합니다.
            if (end == false && now_menu != 0) {
                try {
                    data = menuSelect.nextInt();
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다.");
                    //무한 반복을 막기 위해 버퍼의 값을 제거합니다.
                    menuSelect.nextLine();
                }
            }
        } while (!end);
    }
}
