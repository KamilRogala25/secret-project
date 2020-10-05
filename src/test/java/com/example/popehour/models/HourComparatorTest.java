package com.example.popehour.models;

import com.example.popehour.model.HourComparator;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class HourComparatorTest {

    private static HourComparator hourComparator;


    @Test public void testHourComparator(){
        assertEquals(HourComparator.howMuchLeftTest(15,29),"6:8");
        assertEquals(HourComparator.howMuchLeftTest(21,0),"37");
        assertEquals(HourComparator.howMuchLeftTest(22,37),"23");
        assertEquals(HourComparator.howMuchLeftTest(23,36),"22:1");
        assertEquals(HourComparator.howMuchLeftTest(23,37),"22");
        assertEquals(HourComparator.howMuchLeftTest(21,38),"23:59");
        assertEquals(HourComparator.howMuchLeftTest(20,51),"1:46");
        assertEquals(HourComparator.howMuchLeftTest(23,9),"22:28");
    }


}
