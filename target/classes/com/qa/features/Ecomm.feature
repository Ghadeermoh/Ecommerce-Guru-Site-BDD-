Feature: Ecommerce Guru Site Test
 
 @Day1
Scenario: verify sort of mobile products
Given  customer is in home page 
Then customer click on mobile icon
Then  customer sort items by name 
And verify images and links in mobile page

@Day2
Scenario: verify cost of product in list page and details page
Given customer is in home page
Then customer click on mobile icon
Then check the price or product in two pages and verify its same

  


@Day3
Scenario: customer add a mobile item to the cart 
Given customer is in home page 
Then customer click on mobile icon 
Then customer add mobile item to the cart and  change quantitiy to large value and update
Then customer verify error message 
Then customer empty the cart and verify it is empty 

@Day4 
Scenario: customer can compare two items 
Given  customer is in home page 
Then customer click on mobile icon 
Then customer add  items to compare and click on compare
And customer verify popup window and items in it

 


@Second
Scenario: customer click on TV icon
Given customer is in home page 
Then customer click on TV icon 

@Third
Scenario: customer search on mobile phone 
Given customer is in home page 
Then customer search on an item 

@Day5 
Scenario Outline: customer register in the site
#Given customer is in home page 
Then customer go to register page from acount icon 
Then customer fills register page details "<firstname>" and "<lastname>" and "<email address>" and "<password>" and "<confirm password>" and click register
Examples: 
|firstname| lastname| email address |password |confirm password|
|ahmed | mohamed| ahmed.mo@gmail.com| Ahmed123456|Ahmed123456|


@Login 
Scenario Outline: test login 
Given customer is in home page 
Then customer go to Myaccount page from account icon 
Then customer enter login details "<username>" and "<password>" and click login

Examples:
|username| password|
|ahmed.mo@gmail.com|Ahmed123456|

 









