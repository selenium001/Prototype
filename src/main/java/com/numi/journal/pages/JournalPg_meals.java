package com.numi.journal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.numi.qa.base.baseClass;

public class JournalPg_meals extends baseClass{
	
	@FindBy(xpath="//div[@id=\"meal1\"]//div[@food_categories=\"NS_ENTREE\"]")
	WebElement bkfast_entree;

}
