package MyTestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGClass4 {
  @Test
  public void a() {
	  Assert.assertTrue("Sachin"=="Sachin");
  }
  @Test(dependsOnMethods="a")
  public void b() {
	  Assert.assertFalse("Sachin"=="Naik");
  }
}
