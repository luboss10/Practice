Feature: getting through amazon
  Background: log in to amazon
    Given home page is loaded

    @Amazon
    Scenario: Login
      Then user logs in to own profile
      Then user verifies URL route for Amazon home page
      Then user verifies breadcrumb for Amazon home page

