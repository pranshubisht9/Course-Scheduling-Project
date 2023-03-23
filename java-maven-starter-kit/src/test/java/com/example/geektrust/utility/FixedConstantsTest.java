package com.example.geektrust.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FixedConstantsTest {
    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",FixedConstants.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",FixedConstants.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",FixedConstants.ACCEPTED);
    }
}
