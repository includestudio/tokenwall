package com.includestudio.tokenwall.integration.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Since: 5/4/12
 */
public class SampleSteps {

    private int a;
    private int b;
    private int actual;

    @Given("number $a and $b")
    public void givenNumbers(int a, int b){
        this.a = a;
        this.b = b;
    }

    @When("I do addition")
    public void doAddition(){
        actual = a + b;
    }

    @Then("result should be $result")
    public void assertResult(int result) {
        assertThat(actual, is(result));
    }
}
