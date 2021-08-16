Feature: Validate request/response to Users API

  Scenario Outline: Should be able to add a user
    Given Add User payload
    When User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
    Then API call should be successful with status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"

    Examples:
      | name     | job          |
      | morpheus | leader       |
      | mobius   | practitioner |

  Scenario Outline: Should be able to delete a user
    Given Add User payload
    And User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
    When User calls ReqRes api with "DELETE_USER_REQUEST" to delete the user
    Then API call should be successful with status code 204
    Examples:
      | name     | job    |
      | morpheus | leader |

  @AddUser
  Scenario Outline: Should be able to add a user
    Given User have valid endpoint "<AddUser>"
    When User request with json request payload for "AddUser.json"
    Then User should receive the following response value "name" should be "<name>", "job" should be "<job>" and 201 statusCode
    When User calls "<deleteEndpoint>" to delete newly created user for "<deleteKey>"
    Then API call should be successful with status code 204

    Examples:
      | AddUser     | name  | job    | deleteEndpoint  |deleteKey|
      | /api/users/ | Ayush | leader | /api/users/{id} |id       |

