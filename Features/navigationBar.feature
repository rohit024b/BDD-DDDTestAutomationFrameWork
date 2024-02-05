Feature: navigationBar Of AI University Course Finder Webfold

  Scenario: Verify that the Navigation Bar/Menu is working and navigate to the correct pages.
    
    Given verify the title as "University Course Finder - Search Best Courses to Study Abroad" is displayed
    When user clicks on navigation button "About Us"
    Then verify the title as "About Leverage Edu - Empowering Your Study Abroad Journey"
    When user clicks on navigation button "Our Experts"
    Then verify the title as "Meet Our Team of Study Abroad Experts | Leverage Edu"
    
    
    
