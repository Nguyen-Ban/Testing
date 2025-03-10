import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'Ô tô', 5, true, 90000",
            "'Ô tô', 10, false, 180000",
            "'Ô tô', 18, false, 270000"
    })
    void testCalculateParkingFee(String vehicleType, double hours, boolean isMember, double expectedFee) {
        assertEquals(expectedFee, Main.calculateParkingFee(vehicleType, hours, isMember));
    }

    @ParameterizedTest
    @CsvSource({
            "'Xe đạp', 5, false",
            "'Xe máy', 0, false",
    })
    void testInvalidInputs(String vehicleType, double hours, boolean isMember) {
        assertThrows(IllegalArgumentException.class, () -> Main.calculateParkingFee(vehicleType, hours, isMember));
    }
}
