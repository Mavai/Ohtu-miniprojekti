Feature: Bibtex file can be downloaded

  #  Scenario: Added book is found on bibtex page
  #    Given references is visited
  #    And book is added
  #    And getbibtex is visited
  #    Then page displays content: "authorName"
  #    And page displays content: "titleOfTheBook"
  #    And page displays content: "1994"
  #    And page displays content: "publisherName"
  Scenario: Added books bibtex file can be downloaded from bibtex page
    Given references is visited
    And book is added with name: "referenceName", author: "authorName", title: "titleOfTheBook", year: "1994" and publisher: "publisherName"
    When getbibtex file named "bibtexFile" is downloaded
    Then file contains content: "authorName"
    And file contains content: "titleOfTheBook"
    And file contains content: "1994"
    And file contains content: "publisherName"

  Scenario: Deleted book is not found in downloaded bibtex file
    Given references is visited
    And book is added with name: "referenceToBeDeleted", author: "authorToBeDeleted", title: "titleToBeDeleted", year: "1555" and publisher: "publisherToBeDeleted"
    And book with name: "referenceToBeDeleted" is deleted
    When getbibtex file named "bibtexFile" is downloaded
    Then file does not contain content: "authorToBeDeleted"
    And file does not contain content: "titleToBeDeleted"
    And file does not contain content: "1555"
    And file does not contain content: "publisherToBeDeleted"