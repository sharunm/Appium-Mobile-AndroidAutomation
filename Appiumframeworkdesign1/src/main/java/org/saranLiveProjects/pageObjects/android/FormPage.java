package org.saranLiveProjects.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.saranLiveProjects.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dora");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Algeria\"));"));
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Algeria']")).click();
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Algeria']")
	private WebElement algeria;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void setGender(String gender)
	{
		if(gender.contains("female"))
		
			femaleOption.click();
		else 
        maleOption.click();
	}
	public void setCountryOption(String countryName) 
	
	{
		countryOption.click();
		scrollToText(countryName);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return new ProductCatalogue(driver);
	}
	
	
	
	
	
	
}
