package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base{
    /*
    Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                	  |
    |MY TRIPS            	  |
    |TRAVEL INFO         	  |
    |MILEAGEPLUS® PROGRAM     |
    |DEALS               	  |
    |HELP                	  |
     */
    @Test(priority = 1, description = "Test Case 1: Validate \"Main menu\" navigation items")
    public void testMainMenuItems(){
        driver.get("https://www.united.com/en/us");

        String[] expectedTexts = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < 6; i++) {
            softAssert.assertEquals(homePage.mainMenuItems.get(i).getText(), expectedTexts[i]);
        }
    }

    /*
    Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
    |Book               |
    |Flight status      |
    |Check-in           |
    |My trips           |
     */

    @Test(priority = 2, description = "Test Case 2: Validate \"Book travel menu\" navigation items")
    public void testBookTravelItems(){
        driver.get("https://www.united.com/en/us");

        String[] expectedTexts = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(homePage.bookTravelMenuItems.get(i).getText(), expectedTexts[i]);
        }
    }

    /*
    Test Case 3: Validate "Round-trip" and "One-way" radio buttons
    Given user is on "https://www.united.com/en/us"
    Then validate "Roundtrip" radio button is displayed, is enabled and is selected
    And validate "One-way" radio button is displayed, is enabled but is not selected
    When user clicks on "One-way" radio button
    Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
     */

    @Test(priority = 3, description = "Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRadioButtons(){
        driver.get("https://www.united.com/en/us");
        Waiter.pause(2);
        softAssert.assertTrue(homePage.roundTripLabel.isDisplayed());
        softAssert.assertTrue(homePage.roundTripInputBox.isEnabled());
        softAssert.assertTrue(homePage.roundTripInputBox.isSelected());

        softAssert.assertTrue(homePage.onewayTripLabel.isDisplayed());
        softAssert.assertTrue(homePage.oneWayTripInputBox.isEnabled());
        softAssert.assertFalse(homePage.oneWayTripInputBox.isSelected());

        homePage.onewayTripLabel.click();
        Waiter.pause(2);
        softAssert.assertFalse(homePage.roundTripInputBox.isSelected());
        softAssert.assertTrue(homePage.oneWayTripInputBox.isSelected());
    }

    /*
    Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
    Given user is on "https://www.united.com/en/us"
    Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
    And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
    When user clicks both checkboxes
    Then validate both checkboxes are selected
    When user clicks on both selected checkboxes again
    Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = " Test Case 4: Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void testCheckboxes(){
        driver.get("https://www.united.com/en/us");

        softAssert.assertTrue(homePage.checkBoxLabels.get(0).isDisplayed());
        softAssert.assertTrue(homePage.checkBoxInputs.get(0).isEnabled());
        softAssert.assertFalse(homePage.checkBoxInputs.get(0).isSelected());

        softAssert.assertTrue(homePage.checkBoxLabels.get(1).isDisplayed());
        softAssert.assertTrue(homePage.checkBoxInputs.get(1).isEnabled());
        softAssert.assertFalse(homePage.checkBoxInputs.get(1).isSelected());

        homePage.checkBoxLabels.get(0).click();
        homePage.checkBoxLabels.get(1).click();

        softAssert.assertTrue(homePage.checkBoxInputs.get(0).isSelected());
        softAssert.assertTrue(homePage.checkBoxInputs.get(1).isSelected());


        homePage.checkBoxLabels.get(0).click();
        homePage.checkBoxLabels.get(1).click();

        softAssert.assertFalse(homePage.checkBoxInputs.get(0).isSelected());
        softAssert.assertFalse(homePage.checkBoxInputs.get(1).isSelected());
    }

    /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)\"")
    public void testOneWaySearchResult(){
        driver.get("https://www.united.com/en/us");

        homePage.onewayTripLabel.click();
        homePage.fromInputBox.clear();
        homePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        homePage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        homePage.departDateInputBox.clear();
        homePage.departDateInputBox.sendKeys("Jan 30");
        homePage.departDateInputBox.click();
        homePage.passengerSelectorButton.click();
        homePage.addOneMoreAdultButton.click();
        homePage.cabinTypeDropdown.click();
        homePage.clickOnCabinTypeOption("Business or First");
        homePage.findFlightsButton.click();

        Assert.assertEquals(flightsPage.flightHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");

    }

}