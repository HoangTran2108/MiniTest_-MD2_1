package views;

import Model.Client;
import Model.Hotel;
import controller.HotelManager;
import storage.ReadWriteFile;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Client> clients;

    static {
        try {
            clients = ReadWriteFile.readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static HotelManager manager = new HotelManager(clients);
    public static ReadWriteFile readWriteFile = new ReadWriteFile();
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
                        readWriteFile.writeToFile(clients);
                    }
                }
                case 2 -> {
                    manager.addClient(addNewClient());
                     readWriteFile.writeToFile(clients);
                }
                case 3 -> {
                    for (Client client : clients) {
                        System.out.println(client);
                    }
                }
                case 4 -> {
                    manager.removeClient();
                    readWriteFile.writeToFile(clients);
                }
                case 5 -> manager.moneyToPay();
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    public static Client addNewClient() {
        Hotel hotel = null;
        try {
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
            hotel = new Hotel(name, dateOfBirth, idNumber, numberOfDays, typeOfRoom, price);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }

}