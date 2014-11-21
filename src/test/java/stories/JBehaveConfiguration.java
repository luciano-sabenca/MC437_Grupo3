package stories;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;

public class JBehaveConfiguration extends JUnitStories {

	private final CrossReference xref = new CrossReference();

	public JBehaveConfiguration() {
		configuredEmbedder().embedderControls()
				.doGenerateViewAfterStories(true)
				.doIgnoreFailureInStories(false).doIgnoreFailureInView(true)
				.doVerboseFailures(true).useThreads(2)
				.useStoryTimeoutInSecs(60);
		// configuredEmbedder().useEmbedderControls(new
		// PropertyBasedEmbedderControls());
	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		viewResources.put("reports", "ftl/jbehave-reports-with-totals.ftl");

		return new MostUsefulConfiguration()
				.useStoryControls(
						new StoryControls().doDryRun(false)
								.doSkipScenariosAfterFailure(false))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryParser(new RegexStoryParser())
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(
										CodeLocations
												.codeLocationFromClass(embeddableClass))
								.withDefaultFormats()

								.withViewResources(viewResources)

								.withFailureTrace(true)
								.withFailureTraceCompression(true)
								.withCrossReference(xref))

				.useStepMonitor(xref.getStepMonitor());
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),
				new ResultaDosTestesSteps());
	}

	@Override
	protected List<String> storyPaths() {
		// Specify story paths as URLs
		String codeLocation = CodeLocations.codeLocationFromClass(
				this.getClass()).getFile();
		return new StoryFinder().findPaths(codeLocation,
				Arrays.asList("**/*.story"), Arrays.asList(""));
	}

}
