Feature: books

  @books
  Scenario: create book success
    Given a book with ISBN "9424674979620" exists in the database
    And BOOK table allows insertion of a row with ISBN "5307585688871"
    And AUTHOR table allows insertion of a row with FULL_NAME "Charles Dickens"
    And BIBLIOGRAPHY table allows insertion of a row
    And GENRE table allows insertion of a row with GENRE_NAME "THRILLER"
    And BOOK_GENRE table allows insertion
    And AUTHOR_GENRE table allows insertion
    And kafka allows publishing of event
    When create books API is called with the following payload
    """json
    {
        "title": "Pickwick Papers",
        "isbn": "5307585688871",
        "summary": "Pickwick Papers",
        "published_on": "1877",
        "pages": "200",
        "authors": [
            {
                "name": "Charles Dickens",
                "about": "Charles Dickens"
            }
        ],
        "genres": [
            "THRILLER",
            "SCI-FI",
            "FICTION"
        ]
    }
    """
    Then response of create books API should be 201
    And a row with ISBN "5307585688871" and TITLE "Pickwick Papers" should be added to the BOOK table
    And a row with FULL_NAME "Charles Dickens" should be added to the AUTHOR table
    And a row should be added to the BIBLIOGRAPHY table
    And rows with the following GENRE_NAME should be added to the GENRE table
      | SCI-FI   |
      | THRILLER |
      | FICTION  |
    And 3 rows should be added to the BOOK_GENRE table
    And 3 rows should be added to the AUTHOR_GENRE table
    And an event should be published to kafka
