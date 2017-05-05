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
    When book with name: "referenceNameForBookReferenceFeature", author: "testAuthorForBookReferenceFeature", editor: "testEditorForBookReferenceFeature", title: "testTitleForBookReferenceFeature", year: "1955" and publisher: "testPublisherForBookReferenceFeature" is added
    Then page displays content: "referenceNameForBookReferenceFeature"
    And page displays content: "testAuthorForBookReferenceFeature"
    And page displays content: "testTitleForBookReferenceFeature"
    And page displays content: "testEditorForBookReferenceFeature"
    And page displays content: "1955"
    And page displays content: "testPublisherForBookReferenceFeature"

  Scenario: Book with empty required fields will not be added
    Given references is visited
    When book with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add a book reference content

  Scenario: Book can be edited
    Given references is visited
    And book is added with name: "referenceNameForBookToBeEditedForBookReferenceFeature", author: "uneditedAuthorForBookReferenceFeature", editor: "uneditedEditorForBookReferenceFeature", title: "uneditedTitleForBookReferenceFeature", year: "1234" and publisher: "publisherToBeEditedForBookReferenceFeature"
    When book named "referenceNameForBookToBeEditedForBookReferenceFeature" is edited with name: "newReferenceNameForBookForBookReferenceFeature", author: "newAuthorForBookForBookReferenceFeature", editor: "newEditorForBookForBookReferenceFeature", title: "newTitleForBookForBookReferenceFeature", year: "1984" and publisher: "newPublisherForBookReferenceFeature"
    Then page does not display content: "referenceNameForBookToBeEditedForBookReferenceFeature"
    And page does not display content: "uneditedAuthorForBookReferenceFeature"
    And page does not display content: "uneditedEditorForBookReferenceFeature"
    And page does not display content: "uneditedTitleForBookReferenceFeature"
    And page does not display content: "1234"
    And page does not display content: "publisherToBeEditedForBookReferenceFeature"
    And page displays content: "newReferenceNameForBookForBookReferenceFeature"
    And page displays content: "newAuthorForBookForBookReferenceFeature"
    And page displays content: "newTitleForBookForBookReferenceFeature"
    And page displays content: "newEditorForBookForBookReferenceFeature"
    And page displays content: "1984"
    And page displays content: "newPublisherForBookReferenceFeature"

  Scenario: Book can be deleted
    Given references is visited
    And book is added with name: "referenceNameForBookToBeDeleted", author: "authorForBookToBeDeleted", editor: "editorForBookToBeDeleted", title: "titleForBookToBeDeleted", year: "2011" and publisher: "publisherForBookToBeDeleted"
    When book named "referenceNameForBookToBeDeleted" is deleted
    Then page does not display content: "referenceNameForBookToBeDeleted"
    And page does not display content: "authorForBookToBeDeleted"
    And page does not display content: "titleForBookToBeDeleted"
    And page does not display content: "editorForBookToBeDeleted"
    And page does not display content: "2011"
    And page does not display content: "publisherForBookToBeDeleted"

  Scenario: Add article reference page is accessible from references page
    Given references is visited
    When type: "Article" is selected
    Then page displays add an article reference content

  Scenario: References page displays added article
    Given references is visited
    When article with name: "referenceNameForArticleReferenceFeature", author: "testAuthorForArticleReferenceFeature", title: "testTitleForArticleReferenceFeature", journal: "testJournalForArticleReferenceFeature", year: "1955" and volume: "187" is added
    Then page displays content: "referenceNameForArticleReferenceFeature"
    And page displays content: "testAuthorForArticleReferenceFeature"
    And page displays content: "testTitleForArticleReferenceFeature"
    And page displays content: "testJournalForArticleReferenceFeature"
    And page displays content: "1955"
    And page displays content: "187"

  Scenario: Article with empty required fields will not be added
    Given references is visited
    When article with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add an article reference content

  Scenario: Article can be edited
    Given references is visited
    And article is added with name: "referenceNameForArticleToBeEdited", author: "uneditedAuthorForArticleToBeEdited", title: "uneditedTitleForArticleToBeEdited", journal: "uneditedJournalForArticleToBeEdited", year: "2111" and volume: "912"
    When article named "referenceNameForArticleToBeEdited" is edited with name: "newReferenceNameForArticle", author: "newAuthorForArticle", title: "newTitleForArticle", journal: "newJournalForArticle", year: "1984" and volume: "101"
    Then page does not display content: "referenceNameForArticleToBeEdited"
    And page does not display content: "uneditedAuthorForArticleToBeEdited"
    And page does not display content: "uneditedTitleForArticleToBeEdited"
    And page does not display content: "uneditedJournalForArticleToBeEdited"
    And page does not display content: "2111"
    And page does not display content: "912"
    And page displays content: "newReferenceNameForArticle"
    And page displays content: "newAuthorForArticle"
    And page displays content: "newTitleForArticle"
    And page displays content: "newJournalForArticle"
    And page displays content: "1984"
    And page displays content: "101"

  Scenario: Article can be deleted
    Given references is visited
    And article is added with name: "referenceNameForArticleToBeDeleted", author: "authorForArticleToBeDeleted", title: "titleForArticleToBeDeleted", journal: "journalForArticleToBeDeleted", year: "1966" and volume: "721"
    When article named "referenceNameForArticleToBeDeleted" is deleted
    Then page does not display content: "referenceNameForArticleToBeDeleted"
    And page does not display content: "authorForArticleToBeDeleted"
    And page does not display content: "titleForArticleToBeDeleted"
    And page does not display content: "journalForArticleToBeDeleted"
    And page does not display content: "1966"
    And page does not display content: "721"

  Scenario: Add inproceedings reference page is accessible from references page
    Given references is visited
    When type: "Inproceedings" is selected
    Then page displays add an inproceedings reference content

  Scenario: References page displays added inproceedings
    Given references is visited
    When inproceedings with name: "referenceNameForInproceedingsReferenceFeature", author: "testAuthorForInproceedingsReferenceFeature", title: "testTitleForInproceedingsReferenceFeature", book title: "testBooktitleForInproceedingsReferenceFeature" and year: "1925" is added
    Then page displays content: "referenceNameForInproceedingsReferenceFeature"
    And page displays content: "testAuthorForInproceedingsReferenceFeature"
    And page displays content: "testTitleForInproceedingsReferenceFeature"
    And page displays content: "testBooktitleForInproceedingsReferenceFeature"
    And page displays content: "1925"

  Scenario: Inproceedings with empty required fields will not be added
    Given references is visited
    When inproceedings with author: "authorWithOtherFieldsEmpty" is added
    Then page displays add an inproceedings reference content

  Scenario: Inproceedings can be edited
    Given references is visited
    And inproceedings is added with name: "referenceNameForInproceedingsToBeEdited", author: "uneditedAuthorForInproceedingsToBeEdited", title: "uneditedTitleForInproceedingsToBeEdited", book title: "uneditedBookTitleForInproceedingsToBeEdited" and year: "1657"
    When inproceedings named "referenceNameForInproceedingsToBeEdited" is edited with name: "newReferenceNameForInproceedings", author: "newAuthorForInproceedings", title: "newTitleForInproceedings", book title: "newBookTitle" and year: "1984"
    Then page does not display content: "referenceNameForInproceedingsToBeEdited"
    And page does not display content: "uneditedAuthorForInproceedingsToBeEdited"
    And page does not display content: "uneditedTitleForInproceedingsToBeEdited"
    And page does not display content: "uneditedBookTitleForInproceedingsToBeEdited"
    And page does not display content: "1657"
    And page displays content: "newReferenceNameForInproceedings"
    And page displays content: "newAuthorForInproceedings"
    And page displays content: "newTitleForInproceedings"
    And page displays content: "newBookTitle"
    And page displays content: "1984"

  Scenario: Inproceedings can be deleted
    Given references is visited
    And inproceedings is added with name: "referenceNameForInproceedingsToBeDeleted", author: "authorForInproceedingsToBeDeleted", title: "titleForInproceedingsToBeDeleted", book title: "bookTitleForInproceedingsToBeDeleted" and year: "1777"
    When article named "referenceNameForInproceedingsToBeDeleted" is deleted
    Then page does not display content: "referenceNameForInproceedingsToBeDeleted"
    And page does not display content: "authorForInproceedingsToBeDeleted"
    And page does not display content: "titleForInProceedingsToBeDeleted"
    And page does not display content: "bookTitleForInproceedingsToBeDeleted"
    And page does not display content: "1777"
