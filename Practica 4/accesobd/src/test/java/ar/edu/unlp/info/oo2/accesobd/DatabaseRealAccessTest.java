package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseRealAccessTest {
	private DatabaseAccess database;


    @BeforeEach
    void setUp() throws Exception {
        // viejo test
        // this.database = new DatabaseRealAccess();
        // nuevo test
        database = new DatabaseProxy(new DatabaseRealAccess());
    }

    @Test
    void testGetSearchResults() {
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.database.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.database.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testInsertNewRow() {
        assertEquals(3, this.database.insertNewRow(Arrays.asList("Patoruz�", "La flor")));
        assertEquals(Arrays.asList("Patoruz�", "La flor"), this.database.getSearchResults("select * from comics where id=3"));
    }

}
