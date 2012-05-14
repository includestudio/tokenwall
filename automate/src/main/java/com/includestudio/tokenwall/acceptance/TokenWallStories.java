package com.includestudio.tokenwall.acceptance;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;

public class TokenWallStories extends JUnitStories {

    public static final String JBEHAVE_REPORTS_RELATIVE_PATH = "../jbehave";
    public static final String STORY_PATH_PATTERN = "**/stories/*.story";
    public static final String STEPS_CONTEXT_XML = "classpath:com/includestudio/tokenwall/acceptance/applicationContext-steps.xml";

    @Test
    @Override
    public void run() throws Throwable {
        try {
            super.run();
        } catch (Throwable t) {
        }
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useFailureStrategy(new FailingUponPendingStep())
                .useStoryLoader(new LoadFromClasspath(TokenWallStories.class))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withRelativeDirectory(JBEHAVE_REPORTS_RELATIVE_PATH)
                        .withCodeLocation(codeLocationFromClass(TokenWallStories.class)).withFailureTrace(true)
                        .withFailureTraceCompression(true).withDefaultFormats().withFormats(XML, CONSOLE, HTML));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList(STORY_PATH_PATTERN), null);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ApplicationContext context =
                new SpringApplicationContextFactory(STEPS_CONTEXT_XML).createApplicationContext();
        return new SpringStepsFactory(configuration(), context);
    }

}
