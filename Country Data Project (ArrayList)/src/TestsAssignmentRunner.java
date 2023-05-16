import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestsAssignmentRunner
{
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestsAssignment.class);
        if (result.getFailureCount() > 0)
            System.out.println("\nProgram did not pass all unit tests.  Tests that failed are:");
		for (Failure fail : result.getFailures())
		{
			System.out.println(fail.toString()+"\n");
		}
		if (result.wasSuccessful())
		{
			System.out.println("All Assignment Library tests finished successfully...");
		}
	}
}