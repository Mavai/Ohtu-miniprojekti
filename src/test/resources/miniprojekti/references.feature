#Feature: References pages display right content
#
#  Scenario: References page displays Create a new reference
#    Given references is visited
#    Then page displays content: "Create a new reference"
#
#  Scenario: Add book reference page is accessible from references page
#    Given references is visited
#    When type: "Book" is selected
#    Then page displays add a book reference content
#
#  Scenario: References page displays added book
#    Given references is visited
#    When book with name: "referenceNameForBookReferenceFeature", author: "testAuthorForBookReferenceFeature", editor: "testEditorForBookReferenceFeature", title: "testTitleForBookReferenceFeature", year: "1955" and publisher: "testPublisherForBookReferenceFeature" is added
#    Then page displays content: "testAuthorForBookReferenceFeature"
#    And page displays content: "testTitleForBookReferenceFeature"
#
#  Scenario: Book with empty fields will not be added
#    Given references is visited
#    When book with author: "authorWithOtherFieldsEmpty" is added
#    Then page displays add a book reference content
#
#  Scenario: Book can be edited
#    Given references is visited
#    And book is added with name: "referenceNameForBookToBeEditedForBookReferenceFeature", author: "uneditedAuthorForBookReferenceFeature", editor: "uneditedEditorForBookReferenceFeature", title: "uneditedTitleForBookReferenceFeature", year: "1234" and publisher: "publisherToBeEditedForBookReferenceFeature"
#    When book named "referenceNameForBookToBeEditedForBookReferenceFeature" is edited with name: "newReferenceNameForBookForBookReferenceFeature", author: "newAuthorForBookForBookReferenceFeature", editor: "newEditorForBookForBookReferenceFeature", title: "newTitleForBookForBookReferenceFeature", year: "1984" and publisher: "newPublisherForBookReferenceFeature"
#    Then page displays content: "newAuthorForBookForBookReferenceFeature"
#    And page displays content: "newTitleForBookForBookReferenceFeature"
#
#  Scenario: Book can be deleted
#    Given references is visited
#    And book is added with name: "referenceNameForBookToBeDeleted", author: "authorForBookToBeDeleted", editor: "editorForBookToBeDeleted", title: "titleForBookToBeDeleted", year: "2011" and publisher: "publisherForBookToBeDeleted"
#    When book named "referenceNameForBookToBeDeleted" is deleted
#    Then page does not display content: "authorForBookToBeDeleted"
#    And page does not display content: "titleForBookToBeDeleted"
#
#  Scenario: Add article reference page is accessible from references page
#    Given references is visited
#    When type: "Article" is selected
#    Then page displays add an article reference content
#
#  Scenario: References page displays added article
#    Given references is visited
#    When article with name: "referenceNameForArticleReferenceFeature", author: "testAuthorForArticleReferenceFeature", title: "testTitleForArticleReferenceFeature", journal: "testJournalForArticleReferenceFeature", year: "1955" and volume: "1" is added
#    Then page displays content: "testAuthorForArticleReferenceFeature"
#    And page displays content: "testTitleForArticleReferenceFeature"
#
#  Scenario: Article with empty fields will not be added
#    Given references is visited
#    When article with author: "authorWithOtherFieldsEmpty" is added
#    Then page displays add an article reference content
#
#  Scenario: Article can be edited
#    Given references is visited
#    And article is added with name: "referenceNameForArticleToBeEdited", author: "uneditedAuthor", title: "uneditedTitle", journal: "uneditedJournal", year: "1234" and volume: "9"
#    When article named "referenceNameForArticleToBeEdited" is edited with name: "newReferenceNameForArticle", author: "newAuthorForArticle", title: "newTitleForArticle", year: "1984" and publisher: "newPublisher"
#    Then page displays content: "newAuthor"
#    And page displays content: "newTitle"
#
#  Scenario: Article can be deleted
#    Given references is visited
#    And article is added with name: "referenceNameForArticleToBeDeleted", author: "authorForArticleToBeDeleted", title: "titleForArticleToBeDeleted", journal: "journalForArticleToBeDeleted", year: "1966" and volume: "7"
#    When article named "referenceNameForArticleToBeDeleted" is deleted
#    Then page does not display content: "authorForArticleToBeDeleted"
#    And page does not display content: "titleForArticleToBeDeleted"
#
#  Scenario: Add inproceedings reference page is accessible from references page
#    Given references is visited
#    When type: "Inproceedings" is selected
#    Then page displays add an inproceedings reference content
#
#  Scenario: References page displays added inproceedings
#    Given references is visited
#    When inproceedings with name: "referenceNameForInproceedingsReferenceFeature", author: "testAuthorForInproceedingsReferenceFeature", title: "testTitleForInproceedingsReferenceFeature", book title: "testBooktitleForInproceedingsReferenceFeature" and year: "1955" is added
#    Then page displays content: "testAuthor"
#    And page displays content: "testTitle"
#
#  Scenario: Inproceedings with empty fields will not be added
#    Given references is visited
#    When inproceedings with author: "authorWithOtherFieldsEmpty" is added
#    Then page displays add an inproceedings reference content
#
#  Scenario: Inproceedings can be edited
#    Given references is visited
#    And inproceedings is added with name: "referenceNameForInproceedingsToBeEdited", author: "uneditedAuthor", title: "uneditedTitle", book title: "uneditedBookTitle" and year: "1657"
#    When inproceedings named "referenceNameForInproceedingsToBeEdited" is edited with name: "newReferenceNameForInproceedings", author: "newAuthorForInproceedings", title: "newTitleForInproceedings", book title: "newBookTitle" and year: "1984"
#    Then page displays content: "newAuthorForInproceedings"
#    And page displays content: "newTitleForInproceedings"
#
#  Scenario: Inproceedings can be deleted
#    Given references is visited
#    And inproceedings is added with name: "referenceNameForInproceedingsToBeDeleted", author: "authorForInproceedingsToBeDeleted", title: "titleForInproceedingsToBeDeleted", book title: "bookTitleForInproceedingsToBeDeleted" and year: "1777"
#    When article named "referenceNameForInproceedingsToBeDeleted" is deleted
#    Then page does not display content: "authorForInproceedingsToBeDeleted"
#    And page does not display content: "titleForInProceedingsToBeDeleted"