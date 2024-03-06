@AllRegression
Feature: Ebay Search Validation

  Background: Pre and Post conditions for all the scenarios from the current feature file
  #Given Invoke Chrome Browser
  And Navigate to Ebay Page
  
  @Smoke
  Scenario: Search product in ebay by hard coding the values from step definition file.
  When Enter the product name and Select the catagory
  And Click on Search button
  Then User should able to see the search results
 
  @Sanity @Regression
  Scenario: Search product in ebay by parametering the values from data table as a map.
  When Enter the product name and Select the catagory from the below data table as map
  | productname | productcatagory           |
  | Samsung     | Cell Phones & Accessories |
  | Lenovo      | Cell Phones & Accessories |
  And Click on Search button
  Then User should able to see the search results
  