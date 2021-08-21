Feature: Validate request/response to Users API
  @AddOnly
  Scenario Outline: Should be able to add a user
    Given Add User payload
    When User calls "POST_USER_REQUEST" with "<name>,<job>"
    Then API call should return status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"

    Examples:
      | name     | job          |
      | morpheus | leader       |
      | mobius   | practitioner |

  @AddAndDelete
  Scenario Outline: Should be able to delete a user
    Given Add User payload
    And User calls "POST_USER_REQUEST" with "<name>,<job>"
    When User calls "DELETE_USER_REQUEST" with "390"
    Then API call should return status code 204
    Examples:
      | name     | job    |
      | morpheus | leader |

  @Add_Delete
  Scenario Outline: Should be able to add a user
    Given User have valid endpoint "POST_USER_REQUEST"
    When User calls "POST_USER_REQUEST" with "<name>,<job>"
    Then API call should return status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"
    When User calls "DELETE_USER_REQUEST" with "390"
    Then API call should return status code 204

    Examples:
      | name  | job    |
      | Ayush | leader |

