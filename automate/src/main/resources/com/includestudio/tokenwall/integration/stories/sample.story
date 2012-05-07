Meta:

Narrative:
As a user
I want to see welcome message
So that I feel happy

Scenario: show welcome page
Given URL 'http://localhost:8080/tokenwall'
When I open it
Then I am on welcome page
And It says 'Welcome!'