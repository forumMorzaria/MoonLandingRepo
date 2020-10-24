import com.test.exception.BackendException;
import com.test.domain.DirectionEnum;
import com.test.service.NavigationService;
import com.test.service.NavigationServiceImpl;
import com.test.domain.Position;
import com.test.domain.PositionBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * @author forum
 * @since 23-10-2020.
 */
public class NavigationServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private NavigationService navigationService = new NavigationServiceImpl(5, 5);
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testNavigation1() {
        char[] instructionList = "LMLMLMLMM".toCharArray();
        Position p = new PositionBuilder()
                .withX(1)
                .withY(2)
                .withDirectionEnum(DirectionEnum.N)
                .build();
        navigationService.processInstructions(p, instructionList);
        assertEquals(DirectionEnum.N, p.getDirectionEnum());
        assertEquals(1, p.getX());
        assertEquals(3, p.getY());
    }

    @Test
    public void testNavigation2() {
        char[] instructionList = "MMRMMRMRRM".toCharArray();
        Position p = new PositionBuilder()
                .withX(3)
                .withY(3)
                .withDirectionEnum(DirectionEnum.E)
                .build();
        navigationService.processInstructions(p, instructionList);
        assertEquals(DirectionEnum.E, p.getDirectionEnum());
        assertEquals(5, p.getX());
        assertEquals(1, p.getY());
    }

    @Test
    public void testNavigation3() {
        char[] instructionList = "MMRMMRMRRMM".toCharArray();
        Position p = new PositionBuilder()
                .withX(3)
                .withY(3)
                .withDirectionEnum(DirectionEnum.E)
                .build();
        exception.expect(BackendException.class);
        exception.expectMessage("The current position is out of the grid!");
        navigationService.processInstructions(p, instructionList);
    }

    @Test
    public void testNavigation4() {
        char[] instructionList = "MMRMMRMRRMM".toCharArray();
        Position p = new PositionBuilder()
                .withX(6)
                .withY(3)
                .withDirectionEnum(DirectionEnum.E)
                .build();
        exception.expect(BackendException.class);
        exception.expectMessage("The current position is out of the grid!");
        navigationService.processInstructions(p, instructionList);
    }

    @Test
    public void testNavigation5() {
        char[] instructionList = "MMRSMMRMRRMM".toCharArray();
        Position p = new PositionBuilder()
                .withX(2)
                .withY(3)
                .withDirectionEnum(DirectionEnum.E)
                .build();
        exception.expect(BackendException.class);
        exception.expectMessage("Incorrect Input instruction!");
        navigationService.processInstructions(p, instructionList);
    }

}
