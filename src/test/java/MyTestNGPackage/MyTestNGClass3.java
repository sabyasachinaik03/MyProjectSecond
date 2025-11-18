package MyTestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGClass3 {
  @Test(priority=1, groups={"sanity"})
  public void a() {
	  Assert.assertEquals("Sabya", "Sabya");
  }	  
  @Test(priority=2, groups= {"regression"})
  public void b() {
	  Assert.assertEquals("Sabya", "Naik");
  }
  @Test(priority=3, groups= {"sanity"})
  public void c() {
	  Assert.assertEquals("Virat", "Virat");
  }	  
}
