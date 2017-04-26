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
    And book is added with name: "referenceNameForGetBibtexFeature", author: "authorNameForGetBibtexFeature", editor: "editorNameForGetBibtexFeature", title: "titleOfTheBookForGetBibtexFeature", year: "1994" and publisher: "publisherNameForGetBibtexFeature"
    When getbibtex file named "bibtexFile" is downloaded
    Then file contains content: "referenceNameForGetBibtexFeature"
    And file contains content: "authorNameForGetBibtexFeature"
    And file contains content: "editorNameForGetBibtexFeature"
    And file contains content: "titleOfTheBookForGetBibtexFeature"
    And file contains content: "1994"
    And file contains content: "publisherNameForGetBibtexFeature"

#Scenario: Edited books new fields are found in downloaded bibtex file
#    Given references is visited
#    And And book is added with name: "referenceToBeEditedForGetBibtexFeature", author: "authorToBeEdited"ForGetBibtexFeature, editor: "editorToBeEditedForGetBibtexFeature", title: "titleToBeEditedForGetBibtexFeature", year: "1555" and publisher: "publisherToBeEditedForGetBibtexFeature"
#    And book with name "referenceToBeEditedForGetBibtexFeature" is edited with name: "newNameForGetBibtexFeature", author: "newAuthorForGetBibtexFeature", editor: "newEditorForGetBibtexFeature", title: "newTitleForGetBibtexFeature", year: "1111" and publisher: "newPublisherForGetBibtexFeature"
#    When getbibtex file named "bibtexFile" is downloaded
#    Then file does not contain content: "referenceToBeEditedForGetBibtexFeature"
#    And file does not contain content: "authorToBeEditedForGetBibtexFeature"
#    And file does not contain content: "editorToBeEditedForGetBibtexFeature"
#    And file does not contain content: "titleToBeEditedForGetBibtexFeature"
#    And file does not contain content: "1555"
#    And file does not contain content: "publisherToBeEditedForGetBibtexFeature"
#    And file contains content: "newNameForGetBibtexFeature"
#    And file contains content: "newAuthorForGetBibtexFeature"
#    And file contains content: "newEditorForGetBibtexFeature"
#    And file contains content: "newTitleForGetBibtexFeature"
#    And file contains content: "1111"
#    And file contains content: "newPublisherForGetBibtexFeature"

  Scenario: Deleted book is not found in downloaded bibtex file
    Given references is visited
    And book is added with name: "referenceToBeDeletedForGetBibtexFeature", author: "authorToBeDeletedForGetBibtexFeature", title: "titleToBeDeletedForGetBibtexFeature", year: "1555" and publisher: "publisherToBeDeletedForGetBibtexFeature"
    And book with name: "referenceToBeDeletedForGetBibtexFeature" is deleted
    When getbibtex file named "bibtexFile" is downloaded
    Then file does not contain content: "referenceToBeDeletedForGetBibtexFeature"
    And file does not contain content: "authorToBeDeletedForGetBibtexFeature"
    And file does not contain content: "titleToBeDeletedForGetBibtexFeature"
    And file does not contain content: "1555"
    And file does not contain content: "publisherToBeDeleted"
