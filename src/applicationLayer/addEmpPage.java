package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addEmpPage {
WebDriver driver;
public addEmpPage(WebDriver driver) {
this.driver=driver;	
}
@FindBy(xpath="//b[contains(text(),'PIM')]")
WebElement pim;
@FindBy(name="btnAdd")
WebElement addbtn;
}
