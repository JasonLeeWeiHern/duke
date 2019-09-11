import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    Deadline testD = new Deadline("borrow books ", "12/12/2019 1900");
    @Test
    void testDeadlinegetD() {
        assertEquals(testD.getDescription(), "[D][\u2718] borrow books (by:12/12/2019 1900)");
    }
    @Test
    void testDeadlinegetF() {
        assertEquals(testD.getFormat(),"D | 0 | borrow books |12/12/2019 1900");
    }

    ToDo testT = new ToDo("borrow books");
    @Test
    void testToDogetD() {
        assertEquals(testT.getDescription(),"[T][\u2718] borrow books");
    }
    @Test
    void testToDogetF() {
        assertEquals(testT.getFormat(),"T | 0 | borrow books");
    }

    Event testE = new Event("borrow books ", "12/12/2019 1900");
    @Test
    void testEventgetD() {
        assertEquals(testE.getDescription(), "[E][\u2718] borrow books (at:12/12/2019 1900)");
    }
    @Test
    void testEventgetF(){
        assertEquals(testE.getFormat(),"E | 0 | borrow books |12/12/2019 1900");
    }
}
