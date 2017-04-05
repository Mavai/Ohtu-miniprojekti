Feature: References page displays right content

    Scenario: References page displays Create a new reference
       Given index is visited
       Then  page displays create a new reference

    Scenario: Add book reference page is accessible from index page
       Given index is visited
       When  article is selected
       Then  page displays add a book reference content