Feature: References page displays right content

    Scenario: References page displays Create a new reference
       Given index is visited
       Then  page displays content: "Create a new reference"

    Scenario: Add book reference page is accessible from index page
       Given index is visited
       When  type: "book" is selected
       And   form is submitted
       Then  page displays content: "author"
       And   page displays content: "title"
       And   page displays content: "year"
       And   page displays content: "publisher"

    Scenario: References page displays added book
       Given index is visited
       When type: "book" is selected
       And form is submitted
       And form is filled with value: "testAuthor" for "author"
       And form is filled with value: "testTitle" for "title"
       And form is filled with value: "1955" for "year"
       And form is filled with value: "testPublisher" for "publisher"
       And form is submitted
       Then page displays value: "testAuthor"
       And page displays value: "testTitle"

    Scenario: Add article reference page is accessible from index page
       Given index is visited
       When  type: "article" is selected
       And   form is submitted
       Then  page displays content: "author"
       And   page displays content: "title"
       And   page displays content: "year"
       And   page displays content: "publisher"
       And   page displays content: "journal"
       And   page displays content: "volume"
       And   page displays content: "pages"

    Scenario: References page displays added article
       Given index is visited
       When type: "article" is selected
       And form is submitted
       And form is filled with value: "testAuthor" for "author"
       And form is filled with value: "testTitle" for "title"
       And form is filled with value: "1955" for "year"
       And form is filled with value: "testPublisher" for "publisher"
       And form is filled with value: "testJournal" for "journal"
       And form is filled with value: "1" for "volume"
       And form is filled with value: "175" for "pages"
       And form is submitted
       Then page displays value: "testAuthor"
       And page displays value: "testTitle"