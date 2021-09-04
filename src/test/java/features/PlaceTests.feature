Feature: Validate request/response to Users API

  @Add_User
  Scenario Outline: Should be able to add a user
    When User calls "POST_USER_REQUEST" with "<name>" and "<job>"
    Then API call should return status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"

    Examples:
      | name | job    |
      | Test | leader |

