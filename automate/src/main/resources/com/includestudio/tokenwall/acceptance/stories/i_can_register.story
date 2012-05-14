Meta:

Narrative:
As 非注册用户
I want to 注册成为用户
In order to 使用系统

Scenario: register successfully
Given I am on register page
When I input username testuser
And I input password pa33w0rd
And I confirm password pa33w0rd
And I submit
Then I am on page with title 'Register Success'

Scenario: confirm password not matching
Given I am on register page
When I input username testuser
And I input password pa33w0rd
And I confirm password pa33w0r4
And I submit
Then I am on page with title 'Register Failed'