package com.includestudio.tokenwall.domain;

import org.springframework.stereotype.Component;

/**
 * Since: 4/27/12
 */
@Component("sample")
public class Sample {

    public int add(int a, int b) {
        return a+b;
    }
}
