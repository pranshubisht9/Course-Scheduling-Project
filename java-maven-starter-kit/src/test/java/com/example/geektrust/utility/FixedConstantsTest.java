package com.example.geektrust.utility;

import com.example.geektrust.utility.Constants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FixedConstantsTest {
    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",Constants.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",Constants.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",Constants.ACCEPTED);
    }
}
