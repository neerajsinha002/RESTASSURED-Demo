Feature: Call Web API to get response

  @consistent
  Scenario: User wants to test GET method of the api
    Given user calls the web service
    Then user gets the response
    And user gets th response code as "200"