package controller;

import Model.Client;
import Model.Hotel;
import storage.ReadWriteFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManager {
    List<Client> clients;

    public HotelManager(List<Client> clients) {
        this.clients = clients;
    }

    public HotelManager() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
        ReadWriteFile.writeToFile(clients);
    }

    Scanner input = new Scanner(System.in);

    public List<Client> removeClient() {
        System.out.print("Nhập số CMND khách hàng muốn xóa: ");
        String id = input.nextLine();
        for (Client client : clients) {
            if (id.equals(client.getIdNumber())) {
                clients.remove(client);
                return clients;
            } else {
                System.out.println("Số CMND không đúng");
            }
        } return null;
    }

    public void moneyToPay() {
        System.out.print("Nhập số CMND khách hàng muốn thanh toán tiền: ");
        String id = input.nextLine();
        double totalMoney = 0;
        for (Client client : clients) {
            if (id.equals(client.getIdNumber()) && client instanceof Hotel) {
                totalMoney = ((Hotel) client).getNumberOfDays() * ((Hotel) client).getPrice();
                System.out.println("Số tiền phải trả của khách là: " + totalMoney);
            } else {
                System.out.println("Số CMND không đúng");
            }
        }
    }
}
