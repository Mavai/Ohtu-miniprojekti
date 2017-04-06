Feature: GetBibtex page displays right content

  Scenario: Added book is found on bibtex page
    Given references is visited
    And book is added
    And getbibtex is visited
    Then page displays content: "authorName"
    And page displays content: "titleOfTheBook"
    And page displays content: "1994"
    And page displays content: "publisherName"
