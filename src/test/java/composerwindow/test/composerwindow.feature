Feature: User Interface for Sending Notifications
	As a help desk analyst, 
	I want to be able to select from a list of templates 
	So that I can choose a pre-formatted template to use to create a notification.

Scenario: Validate UI Elements Exist
	When the application starts
	Then I see a tree view
	And I see "Email Templates"
	And I should see a field to use for searching templates
	And I should see a button labeled "Apply"
	And I should see the email editor
	And I should see a button labeled "Preview"
	And I should see a button labeled "Send"
	And I should see the email header
	
Scenario: Apply Template
	Given the application starts
	And I see a tree view
	When I apply a template
	Then the appropriate template is displayed in the Email Editor
	
Scenario: Edit Email Header
	Given the application starts
	When I edit the email header
	Then the email header displays my edit
	
	