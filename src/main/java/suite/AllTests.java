package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TestCase.TestCase_AllCase;

@RunWith(Suite.class)
@SuiteClasses({TestCase_AllCase.class})
public class AllTests {

}
