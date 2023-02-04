package views;

import Model.Client;
import Model.Hotel;
import controller.HotelManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Client> clients = new ArrayList<>();
    public static HotelManager manager = new HotelManager(clients);
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;

    public static void main(String[] args) {
        do {
            System.out.println("Menu------------------------");
            System.out.println(
                    "1. Tạo danh sách khách hàng\n" +
                            "2. Thêm khách hàng vào danh sách\n" +
                            "3. Hiển thị danh sách khách hàng\n" +
                            "4. Xóa dữ liệu khách hàng\n" +
                            "5. Tính tiền khách hàng phải trả\n" +
                            "0. Thoát\n");
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> {
                    System.out.println("Nhập số lượng khách thuê phòng:");
                    int number = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < number; i++) {
                        manager.addClient(addNewClient());
                    }
                }
                case 2 -> manager.addClient(addNewClient());
                case 3 -> manager.display();
                case 4 -> manager.removeClient();
                case 5 -> manager.moneyToPay();
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public static Client addNewClient() {
        System.out.println("Nhập tên khách hàng muốn thêm:");
        String name = input.nextLine();
        System.out.println("Nhập Ngày sinh:");
        String dateOfBirth = input.nextLine();
        System.out.println("Nhập số CMND:");
        String idNumber = input.nextLine();
        System.out.println("Nhập số ngày thuê:");
        int numberOfDays = Integer.parseInt(input.nextLine());
        System.out.println("Nhập loại phòng thuê:");
        String typeOfRoom = input.nextLine();
        System.out.println("Nhập giá phòng:");
        double price = Integer.parseInt(input.nextLine());
        return new Hotel(name, dateOfBirth, idNumber, numberOfDays, typeOfRoom, price);
    }
}