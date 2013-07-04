Feature: User Interface for Sending Notifications
	As a help desk analyst, 
	I want to be able to select from a list of templates 
	So that I can choose a pre-formatted template to use to create a notification.

Scenario: Tree view as a menu of templates
	When the application starts
	Then I see a tree view
	And I see "Email Templates"
	