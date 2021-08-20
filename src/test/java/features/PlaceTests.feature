Feature: Validate request/response to Users API
  @AddOnly
  Scenario Outline: Should be able to add a user
    Given Add User payload
    When User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
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
    And User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
    When User calls ReqRes api with "DELETE_USER_REQUEST" to delete the user
    Then API call should return status code 204
    Examples:
      | name     | job    |
      | morpheus | leader |

  @Add_Delete
  Scenario Outline: Should be able to add a user
    Given User have valid endpoint "POST_USER_REQUEST"
    When User request with json request payload for "<name>" and "<job>"
    Then API call should return status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"
    When User calls "DELETE_USER_REQUEST" to delete newly created user for "<deleteKey>"
    Then API call should return status code 204

    Examples:
      | name  | job    | deleteKey |
      | Ayush | leader | id        |

