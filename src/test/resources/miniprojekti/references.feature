Feature: References pages display right content

  Scenario: References page displays Create a new reference
    Given references is visited
    Then page displays content: "Create a new reference"

  Scenario: Add book reference page is accessible from references page
    Given references is visited
    When type: "Book" is selected
    Then page displays add a book reference content

  Scenario: References page displays added book
    Given references is visited
    When book with name: "referenceName", author: "testAuthor", title: "testTitle", year: "1955" and publisher: "testPublisher" is added
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  Scenario: Book with empty fields will not be added
    Given references is visited
    When book with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add a book reference content

  Scenario: Add article reference page is accessible from references page
    Given references is visited
    When type: "Article" is selected
    Then page displays add an article reference content

  Scenario: References page displays added article
    Given references is visited
    When article with name: "referenceName", author: "testAuthor", title: "testTitle", journal: "testJournal", year: "1955" and volume: "1" is added
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  Scenario: Article with empty fields will not be added
    Given references is visited
    When article with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add an article reference content

  Scenario: Add inproceedings reference page is accessible from references page
    Given references is visited
    When type: "Inproceedings" is selected
    Then page displays add an inproceedings reference content

  Scenario: References page displays added inproceedings
    Given references is visited
    When inproceedings with name: "referenceName", author: "testAuthor", title: "testTitle", book title: "testBooktitle" and year: "1955" is added
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  Scenario: Inproceedings with empty fields will not be added
    Given references is visited
    When inproceedings with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add an inproceedings reference content
