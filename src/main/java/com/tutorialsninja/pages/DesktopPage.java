package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;


public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement deskTopsText;
    @CacheLookup
    @FindBy(xpath = "//h4/a" )
    List<WebElement>productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    public String getDeskTopsText(){
        CustomListeners.test.log(Status.PASS,"Get desktop text "+deskTopsText);
        Reporter.log("Get desktop text "+ deskTopsText.toString());
        return getTextFromElement(deskTopsText);
    }
    public ArrayList<String> getProductsNameList(){
        CustomListeners.test.log(Status.PASS,"Get product "+productsList);
        Reporter.log("Select option from "+ productsList.toString());
        List<WebElement> products =getListOfElements(productsList);
        ArrayList<String> originalProductName = new ArrayList<>();
            for (WebElement e:products){
                originalProductName.add(e.getText());
            }
            return originalProductName;
        }
        public void selectProductByName(String product){
        CustomListeners.test.log(Status.PASS,"Select product "+productsList);
        Reporter.log("Select option from" + productsList.toString());
            List<WebElement> products =getListOfElements(productsList);
            for (WebElement e:products){
                if (e.getText().equals(product)){
                    e.click();
                    break;
                }
            }
        }
        public void selectSortByOption(String option){
        selectByVisibleTextFromDropDown(sortBy,option);
        CustomListeners.test.log(Status.PASS,"Select "+option);
    Reporter.log("Select "+option+"to sort by "+sortBy.toString());
    }
    }

