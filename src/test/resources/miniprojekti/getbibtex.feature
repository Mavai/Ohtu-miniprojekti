#
#Feature: GetBibtex page displays right content
#
##  Scenario: Added book is found on bibtex page
##    Given references is visited
##    And book is added
##    And getbibtex is visited
##    Then page displays content: "authorName"
##    And page displays content: "titleOfTheBook"
##    And page displays content: "1994"
##    And page displays content: "publisherName"
#
#  Scenario: Added books bibtex.txt file can be downloaded from bibtex page
#    Given references is visited
#    And book is added
#    When getbibtex file is downloaded
#    Then file contains content: "authorName"
#    And file contains content: "titleOfTheBook"
#    And file contains content: "1994"
#    And file contains content: "publisherName"