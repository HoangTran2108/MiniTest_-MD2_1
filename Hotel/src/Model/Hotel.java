package Model;

public class Hotel extends Client{
    private int numberOfDays;
    private String typeOfRoom;
    private double price;

    public Hotel(String name, String dateOfBirth, String idNumber, int numberOfDays, String typeOfRoom, double price) {
        super(name, dateOfBirth, idNumber);
        this.numberOfDays = numberOfDays;
        this.typeOfRoom = typeOfRoom;
        this.price = price;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + " Tên khách hàng: " + getName() +
                ", Ngày sinh: " + getDateOfBirth() +
                ", Số CMND: " + getIdNumber() +
                ", Số ngày thuê " + numberOfDays +
                ", Loại phòng: " + typeOfRoom + '\'' +
                ", Giá phòng/ngày: " + price +
                ']';
    }
}
