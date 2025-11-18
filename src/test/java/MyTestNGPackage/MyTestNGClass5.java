package MyTestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGClass5 {
  @Test(groups="sanity") 
  public void a() {
	  String q="Sachin";
	  Assert.assertFalse(q.equals("Sachin"));
  }
  @Test(dependsOnGroups="sanity")
  public void b() {
	  Assert.assertTrue("Sachin"=="Naik");
  }
}
