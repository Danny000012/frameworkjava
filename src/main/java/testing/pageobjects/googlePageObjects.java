package testing.pageobjects;

import org.openqa.selenium.By;

public class googlePageObjects {

    public static String url() {return "https://www.google.com/";}
    public static By searchBar() {return By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input");}
    public static By searchButton() {return By.xpath("//*[@id='tsf']/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]");}
    public static By validateSearch(String term) {return By.xpath("//input[@value='Inspired Testing'])[1]");}
    
}
