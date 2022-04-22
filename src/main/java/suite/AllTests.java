package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TestCase.TestCase1_AddToCart;
import TestCase.TestCase2_CheckOut;
import TestCase.TestCase3_Register;

@RunWith(Suite.class)
@SuiteClasses({TestCase1_AddToCart.class, TestCase2_CheckOut.class, TestCase3_Register.class})
public class AllTests {

}
