package com.includestudio.tokenwall.integration;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class TokenWallStories extends JUnitStories {

    StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
            .withCodeLocation(codeLocationFromClass(TokenWallStories.class)).withFailureTrace(true)
            .withFailureTraceCompression(true).withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML);

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useFailureStrategy(new FailingUponPendingStep())
                .useStoryLoader(new LoadFromClasspath(TokenWallStories.class))
                .useStoryReporterBuilder(reporterBuilder);
    }


    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/stories/*.story"), null);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ApplicationContext context =
                new SpringApplicationContextFactory("classpath:com/includestudio/tokenwall/integration/applicationContext-steps.xml").createApplicationContext();
        return new SpringStepsFactory(configuration(), context);
    }



}
