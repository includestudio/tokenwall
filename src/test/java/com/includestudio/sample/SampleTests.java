package com.includestudio.sample;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 4/27/12
 */
public class SampleTests {

    @Test
    public void should_return_hello() throws Exception {
        Sample sample = new Sample();
        assertThat("hello", is(sample.say()));
    }

}
