Feature: User Interface for Sending Notifications
	As a help desk analyst, 
	I want to be able to select from a list of templates 
	So that I can choose a pre-formatted template to use to create a notification.

Scenario: Tree view as a menu of templates
	When the application starts
	Then I see a tree view
	And I see "Email Templates"
	
Scenario: Combobox for searching for a specific template
	When the application starts
	Then I should see a field to use for searching templates
	
Scenario: Button to apply template
	When the application starts
	Then I should see a button labeled "Apply"
	