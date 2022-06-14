package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[id^='headerNav']")
    public List<WebElement> mainMenuItems;

    @FindBy(css = "ul[class*='BookTravel-bookTravel'] h2")
    public List<WebElement> bookTravelMenuItems;

    @FindBy(id = "roundtrip")
    public WebElement roundTripInputBox;

    @FindBy(css = "label[for='roundtrip']")
    public WebElement roundTripLabel;

    @FindBy(id = "oneway")
    public WebElement oneWayTripInputBox;

    @FindBy(css = "label[for='oneway']")
    public WebElement onewayTripLabel;

    @FindBy(css = "div[class*='checkboxWrapper']>input")
    public List<WebElement> checkBoxInputs;

    @FindBy(css = "div[class*='checkboxWrapper']>label")
    public List<WebElement> checkBoxLabels;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement departDateInputBox;

    @FindBy(css = "#passengerSelector>button")
    public WebElement passengerSelectorButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addOneMoreAdultButton;

    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdown;

    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinTypeOptions;

    public void clickOnCabinTypeOption(String optionText){
        for(WebElement element : cabinTypeOptions){
            if(element.getText().equals(optionText)){
                element.click();
                break;
            }
        }
    }

    @FindBy(css = "button[class*='bookFlightForm__findFlightBtn']")
    public WebElement findFlightsButton;
}