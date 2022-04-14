Featrue: user login

  # you can use this when all of your scenarios have a certain prerequisite
  #background: the user is on the homepage

Scenario: successful login
Given the user is on the homepage
When the user enters correct username and password
And the user clicks the login button
Then the nav will show the user's first name

Scenario: username does not exist
Given the user is on the homepage
When the user enters an incorrect username
And the user clicks the login button


Scenario Outline: invalid input
  Given the user is on the homepage
  When the user enters the username "<username>"
  And the user enters the password "<password>"
  And the user clicks the login button
  Then an invalid input message will be displayed


  Examples:
  | username | password |
  | bitchs   | niggar   |
  | hsutt$$  | @@@      |
  |32        | asd12    |