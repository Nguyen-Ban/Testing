public class Main {
    public static String INVALID_INPUT = "Invalid Input";

    public static double calculateParkingFee(String vehicleType, double hours, boolean isMember) {
        // Định nghĩa giá theo từng loại xe
        double rate;
        double baseFee;
        if (vehicleType.equals("Xe máy")) {
            rate = 4000;
        } else if (vehicleType.equals("Ô tô")) {
            rate = 20000;
        } else {
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        // Kiểm tra thời gian hợp lệ
        if (hours <= 0 || hours > 24) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        if (hours <= 6) {
            baseFee = rate * hours;
        } else if (hours <= 12) {
            baseFee = (rate * 6) + (rate * (hours - 6) * 0.75);
        } else {
            baseFee = (rate * 12) + (rate * (hours - 12) * 0.5);
        }

        // Giảm giá 10% nếu có thẻ thành viên
        if (isMember) {
            baseFee *= 0.9;
        }

        return baseFee;
    }

    public static void main(String[] args) {
        System.out.println("Phí gửi xe: " + calculateParkingFee("Ô tô", 10, true) + " VND");
    }
}
