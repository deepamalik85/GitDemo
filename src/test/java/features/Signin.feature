Feature: Application Login

Scenario Outline: Negative Login application
Given Initalize the chrome browser
And Navigate to "http://www.qaclickacademy.com/" website
And click on Login button
When user login with <username> and <password>
Then Invalid email or password error displayed

Examples:
|username     |password|
|deepamalik85 |12345   |
|nsaroha616   |67890   |