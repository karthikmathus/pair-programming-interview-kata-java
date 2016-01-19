package tests;


import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class Tests {

    @Test
    public void testTrue() {
        assertThat(true, equals(true));
    }

}

