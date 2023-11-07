Feature: books

  @books
  Scenario: books
    Given a book with ISBN "9424674979620" exists in the database
    When create books API is called with the following payload
    """json
    {
        "title": "Pickwick Papers",
        "isbn": "1234567890",
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
            "SCI-FI",
            "THRILLER"
        ]
    }
    """
    Then response of create books API should be 201
    And a row with ISBN "1245052270932" and TITLE "Animal Farm" should be added to the BOOK table
    And a row with FULL_NAME "George Orwell" should be added to the AUTHOR table
    And a row should be added to the BIBLIOGRAPHY table
    And a row with GENRE_NAME "Humour" should be added to the GENRE table
    And a row should be added to the BOOK_GENRE table
    And a row should be added to the AUTHOR_GENRE table
