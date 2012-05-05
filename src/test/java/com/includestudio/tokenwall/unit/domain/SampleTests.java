package com.includestudio.tokenwall.unit.domain;

import com.includestudio.tokenwall.domain.Sample;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Since: 4/27/12
 */
public class SampleTests {

    @Test
    public void should_return_5_if_add_3_and_2() throws  Exception {
        Sample sample = new Sample();
        assertThat(sample.add(3,2),is(5));
    }

}
