package runner;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "cydeo/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
