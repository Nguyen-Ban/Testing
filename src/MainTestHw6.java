import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class MainTestHw6 {
    @ParameterizedTest
    @CsvSource({
            "Xe máy, 25, false, Invalid Input",
            "Ô tô, -1, false, Invalid Input",
            "Xe đạp, 4, false, Invalid Input",
            "Xe máy, 4, false, 16000",
            "Xe máy, 10, false, 36000",
            "Xe máy, 15, false, 48000",
            "Xe máy, 15, true, 43200",
            "Ô tô, 10, true, 162000",
            "Ô tô, 15, true, 216000",
            "Ô tô, 4, false, 80000",
            "Xe máy, 10, true, 32400"
    })
    void testCalculateParkingFee(String vehicleType, double hours, boolean isMember, String expectedOutput) {
        if (expectedOutput.equals("Invalid Input")) {
            assertThrows(IllegalArgumentException.class, () -> Main.calculateParkingFee(vehicleType, hours, isMember));
        } else {
            double expectedFee = Double.parseDouble(expectedOutput);
            assertEquals(expectedFee, Main.calculateParkingFee(vehicleType, hours, isMember));
        }
    }
}
