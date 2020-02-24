package testing.pageobjects;


import org.openqa.selenium.By;

public class BitnamiObjects 
{
    public static String url() {return "http://gts-training.dvt.co.za:81/sugarcrm/index.php?action=Login&module=Users";}
    public static By Username() {return By.xpath("//*[@id='user_name']");}
    public static By Password() {return By.xpath("//*[@id='user_password']");}
    public static By LoginButton() {return By.xpath("//*[@id='login_button']");}
    public static By MarketingTab() {return By.xpath("//*[@id='grouptab_1']");}
    public static By ClickTargets() {return By.xpath("//*[@id='moduleTab_1_Targets']");}
    public static By CreateTarget() {return By.xpath("//*[@id='shortcuts']/span/span[1]/a/span");}
    public static By FirstName() {return By.xpath("//*[@id='first_name']");}
    public static By LastName() {return By.xpath("//*[@id='last_name']");}
    public static By AddressStreet() {return By.xpath("//*[@id='primary_address_street']");}
    public static By AddressCity() {return By.xpath("//*[@id='primary_address_city']");}
    public static By AddressState() {return By.xpath("//*[@id='primary_address_state']");}
    public static By AddressPostalCode() {return By.xpath("//*[@id='primary_address_postalcode']");}
    public static By AddressCountry() {return By.xpath("//*[@id='primary_address_country']");}
    public static By SaveTargets() {return By.xpath("//*[@id='SAVE_FOOTER']");}
    public static By TargetListTab() {return By.xpath("//*[@id='moduleTab_1_Target Lists']");}
    public static By CreateTargetList() {return By.xpath("//*[@id='shortcuts']/span/span[1]/a/span");}
    public static By TargetListName() {return By.xpath("//*[@id='name']");}
    public static By TargetListDescription() {return By.xpath("//*[@id='description']");}
    public static By SaveTargetList() {return By.xpath("//*[@id='SAVE_HEADER']");}
    public static By DropSelect() {return By.xpath("//*[@id='list_subpanel_prospects']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/ul/li/span");}
    public static By SelectButton() {return By.xpath("//*[@id='prospect_list_prospects_select_button']");}
    public static By SelectAll() {return By.xpath("//*[@id='massall_top']");}
    public static By TickAllTargets() {return By.xpath("//*[@id='MassUpdate_select_button']");}
    public static By SelectAllTargets() {return By.xpath("//*[@id='massall_top']");}
    public static By DeleteAllTargets() {return By.xpath("//*[@id='delete_listview_bottom']");}
    public static By SelectAllTargetLists() {return By.xpath("//*[@id='massall_top']");}
    public static By DeleteAllTargetList() {return By.xpath("//*[@id='delete_listview_bottom']");}
    public static By Logout() {return By.xpath("//*[@id='logout_link']");}
}
