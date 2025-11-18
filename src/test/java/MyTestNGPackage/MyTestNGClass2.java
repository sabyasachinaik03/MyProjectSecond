package MyTestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGClass2 {
  @Test
  public void f() {
	  Assert.assertEquals("Sabya", "Sabya");
  }	  
  @Test
  public void e() {
	  Assert.assertEquals("Sabya", "Naik");
  }
}
