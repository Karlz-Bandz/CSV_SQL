import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DbService;
import services.impl.DbServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DbServiceTest {

    private DbService dbService;

    @BeforeEach
    void setUp() {
        dbService = new DbServiceImpl();
    }

    @Test
    void deleteDynamicDataByFileNameTest_SUCCESS() {
        String fileName = "test669";

        dbService.deleteDynamicDataByFileName(fileName);
        List<Object[]> solution = dbService.getDynamicDataByFileName(fileName);

        assertTrue(solution.isEmpty());
    }

    @Test
    void getDynamicDataByFileNameTest_SUCCESS() {
        List<Object[]> solution = dbService.getDynamicDataByFileName("test666");
        assertEquals(6, solution.size());
    }
}
