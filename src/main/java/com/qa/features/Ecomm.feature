Feature: Ecommerce Guru Site Test
 
 @First
Scenario: customer click on mobile icon
Given  customer is in home page 
Then customer click on mobile icon
Then  customer sort items by name 
And verify images and links in mobile page

@Second
Scenario: customer click on TV icon
Given customer is in home page 
Then customer click on TV icon 

@Third
Scenario: customer search on mobile phone 
Given customer is in home page 
Then customer search on an item 

@Fourth 
Scenario Outline: customer register in the site
#Given customer is in home page 
Then customer go to register page from acount icon 
Then customer fills register page details "<firstname>" and "<lastname>" and "<email address>" and "<password>" and "<confirm password>" and click register
Examples: 
|firstname| lastname| email address |password |confirm password|
|ahmed | mohamed| ahmed.mo@gmail.com| Ahmed123456|Ahmed123456|


 









