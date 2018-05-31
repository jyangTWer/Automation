@firstSearch
Feature: Search
	Scenario: Search csdn
		Given Open the homepage
		When I click the "Clients" link
		Then I can see 11 records
