package org.saranLiveProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.saranLiveProjects.pageObjects.android.CartPage;
import org.saranLiveProjects.pageObjects.android.FormPage;
import org.saranLiveProjects.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ecommerce_4 extends  BaseClass{
	@Test(dataProvider="getData")
	public void FillForm(String name,String gender, String country) throws InterruptedException {
			Thread.sleep(4000);
			
			
			formPage.setNameField(name);
			formPage.setGender(gender);
			//formPage.setCountryOption(country);
			Assert.assertEquals(false, true);
			ProductCatalogue productCatalogue =formPage.submitForm();
			productCatalogue.addItemToCart(0);
		productCatalogue.addItemToCart(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		Thread.sleep(3000);	
		
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//	    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	    String cartpageTitle =	driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
	    System.out.println(cartpageTitle);
	    
	    double totalSum =   cartPage.getProductSum();
	    double displayFormattedSum = cartPage.getTotalAmountDisplayed();
	    Assert.assertEquals(totalSum,displayFormattedSum);
		Thread.sleep(2000);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
		}
//		@BeforeMethod
//		public void preSetup()
//		{
//			Activity activity = new Activity ("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
//			 driver.startActivity(activity);
//		}
		
		@DataProvider
		public Object[][] getData()
		{
			return new Object[][] {{"Saranya","female","Algeria"}};
		}
		
		
	

}
