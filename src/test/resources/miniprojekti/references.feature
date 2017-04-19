Feature: References pages display right content

  Scenario: References page displays Create a new reference
    Given references is visited
    Then page displays content: "Create a new reference"

  Scenario: Add book reference page is accessible from references page
    Given references is visited
    When type: "Book" is selected
    And form is submitted
    Then page displays content: "Reference name"
    And page displays content: "Author"
    And page displays content: "Title"
    And page displays content: "Year"
    And page displays content: "Publisher"

  Scenario: References page displays added book
    Given references is visited
    When type: "Book" is selected
    And form is submitted
    And form is filled with value: "referenceName" for "name"
    And form is filled with value: "testAuthor" for "author"
    And form is filled with value: "testTitle" for "title"
    And form is filled with value: "1955" for "year"
    And form is filled with value: "testPublisher" for "publisher"
    And form is submitted
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  #
  Scenario: Book with empty fields will not be added
    Given references is visited
    When type: "Book" is selected
    And form is submitted
    And form is filled with value: "authorWithOtherFieldsEmpty" for "author"
    And form is submitted
    Then page displays content: "Add an article reference"

  Scenario: Add article reference page is accessible from references page
    Given references is visited
    When type: "Article" is selected
    And form is submitted
    Then page displays content: "Reference name"
    And page displays content: "Author"
    And page displays content: "Title"
    And page displays content: "Year"
    And page displays content: "Journal"
    And page displays content: "Volume"
    And page displays content: "Pages"
    And page displays content: "Number"

  Scenario: References page displays added article
    Given references is visited
    When type: "Article" is selected
    And form is submitted
    And form is filled with value: "referenceName" for "name"
    And form is filled with value: "testAuthor" for "author"
    And form is filled with value: "testTitle" for "title"
    And form is filled with value: "1955" for "year"
    And form is filled with value: "testJournal" for "journal"
    And form is filled with value: "1" for "volume"
    And form is filled with value: "175" for "pages"
    And form is filled with value: "2" for "number"
    And form is submitted
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  Scenario: Article with empty fields will not be added
    Given references is visited
    When type: "Article" is selected
    And form is submitted
    And form is filled with value: "authorWithOtherFieldsEmpty" for "author"
    And form is submitted
    Then page displays content: "Add a book reference"

  Scenario: Add inproceedings reference page is accessible from references page
    Given references is visited
    When type: "Inroceedings" is selected
    And form is submitted
    Then page displays content: "Reference name"
    And page displays content: "Author"
    And page displays content: "Title"
    And page displays content: "Booktitle"
    And page displays content: "Year"
    And page displays content: "Pages"
    And page displays content: "Publisher"

  Scenario: References page displays added inproceedings
    Given references is visited
    When type: "Inproceeding" is selected
    And form is submitted
    And form is filled with value: "referenceName" for "name"
    And form is filled with value: "testAuthor" for "author"
    And form is filled with value: "testTitle" for "title"
    And form is filled with value; "testBooktitle" for "booktitle"
    And form is filled with value: "1955" for "year"
    And form is filled with value: "255" for "pages"
    And form is filled with value: "testPublisher" for "publisher"
    And form is submitted
    Then page displays content: "testAuthor"
    And page displays content: "testTitle"

  Scenario: Inproceedings with empty fields will not be added
    Given references is visited
    When type: "Inproceedings" is selected
    And form is submitted
    And form is filled with value: "authorWithOtherFieldsEmpty" for "author"
    And form is submitted
    Then page displays content: "Add an inproceedings reference"
