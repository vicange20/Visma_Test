Feature: Test Ghost UI for clicks and search

  @UiTest
  Scenario: Test Ghost Site Features
    Given I navigate to ghost.org site
    When I navigate to resources section
    And I click on start here section
    And I type 'create new blog'
    And I select the 10th result from the search
    And I click on pricing section
    And I increased audience slider
    Then The prices will increase