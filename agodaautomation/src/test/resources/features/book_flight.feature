Feature: Book Flight on Agoda

Scenario: Validate booking flight Jakarta to Singapore using AirAsia
  Given user open agoda
  When user search flight from "Jakarta" to "Singapore" for tomorrow
  And user search airline "AirAsia"
  And user chooses the cheapest available flight
  Then user should see correct airline and price on contact details page
