package MyTestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGClass1 {
  @Test
  public void f() {
	  Assert.assertEquals("Sachin", "Sachin");
  }	  
  @Test
  public void e() {
	  Assert.assertEquals("Sachin", "Naik");
  }
}
