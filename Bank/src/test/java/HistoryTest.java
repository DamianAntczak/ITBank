import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by krzysztof on 23/03/2017.
 */
public class HistoryTest {

    @Test
    public void getInstance() throws Exception {
        assertNotNull(History.getInstance());
    }
}