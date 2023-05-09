package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class ComponentsPage extends Utility {
  @CacheLookup
  @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentText;
  public String getComponentsText(){
      CustomListeners.test.log(Status.PASS,"Get component "+componentText);
      Reporter.log("Get component text "+componentText.toString());
      return getTextFromElement(componentText);
  }
}


