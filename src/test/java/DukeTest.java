import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    Deadline testD = new Deadline("borrow books ", "12/12/2019 1900");

    @Test
    void testDeadlinegetD() {
        assertEquals("[D][\u2718] borrow books (by:12/12/2019 1900)", testD.getDescription());
    }
    @Test
    void testDeadlinegetF() {
        assertEquals("D | 0 | borrow books |12/12/2019 1900",testD.getFormat());
    }

    ToDo testT = new ToDo("borrow books");
    @Test
    void testToDogetD() {
        assertEquals("[T][\u2718] borrow books",testT.getDescription());
    }
    @Test
    void testToDogetF() {
        assertEquals("T | 0 | borrow books",testT.getFormat());
    }

    Event testE = new Event("borrow books ", "12/12/2019 1900");
    @Test
    void testEventgetD() {
        assertEquals("[E][\u2718] borrow books (at:12/12/2019 1900)", testE.getDescription());
    }
    @Test
    void testEventgetF(){
        assertEquals("E | 0 | borrow books |12/12/2019 1900",testE.getFormat());
    }

    ChangeDateFormat testcdf = new ChangeDateFormat("12/12/2019 1930");
    @Test
    void testCDF() {
        assertEquals("12th of December 2019, 7.30pm", testcdf.NewFormat("12/12/2019 1930"));
    }


}
