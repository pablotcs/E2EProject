Feature: Login into application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome 
And Navigate to "https://rahulshettyacademy.com/#/index" site
And Click on Login link in home page to land on Secure sign in page 
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in

Examples: 
|username						|password	|
|"test99@gmail.com" |"123456" |
|"asd..asd"					|"1211123"|




