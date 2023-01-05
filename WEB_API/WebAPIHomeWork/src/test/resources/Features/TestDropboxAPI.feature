Feature:
  Background:
    Given request specification is setted

  Scenario: Upload file
    When Dropbox-API-Arg header is setted
    And header parametre request content has type application/octet-stream
    And request uploading body params is setted
    And send upload POST request
    Then received response code is 200

  Scenario: Get file metadata
    When header parametre request content has type application/json
    And request getting metadata body params is setted 
    And send getMetadata POST request
    Then received response code 200

  Scenario: Delete file
    When header param request content type is application/json
    And set request body params for deleting file is setted 
    And send delete POST request
    Then received response code 200