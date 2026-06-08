# nopCommerce Demo Store - Selenium Automation Project

Ready-to-import Eclipse Maven project for automating key workflows on:
https://demo.nopcommerce.com/

## Tech Stack
- Java 17
- Selenium WebDriver 4.21.0
- TestNG 7.10.2
- Maven
- WebDriverManager
- Page Object Model

## Covered Workflows

- Valid login
- Invalid login
- Logout
- Search existing and non-existing products
- Product details
- Add to compare
- Add to cart from wishlist
- Add/remove wishlist
- Add and remove from Compare products list


## How to Run in Eclipse
1. Open Eclipse.
2. File > Import > Existing Maven Projects.
3. Select this project folder.
4. Wait until Maven downloads dependencies.
5. Right click `testng.xml` > Run As > TestNG Suite.

## How to Run from CMD
```bash
mvn clean test
```

## Project Structure
```text
src/test/java

├── pages
│   ├── baseTest.java
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── SearchPage.java
│   ├── ProductPage.java
│   ├── WishlistPage.java
│   └── ComparePage.java
├── tests
│   ├── AuthenticationWorkflowTests.java
│   ├── CatalogNavigationWorkflowTests.java
│   ├── ProductComparisonWorkflowTests.java
│   └── WishlistWorkflowTests.java

```

## Notes
The public demo website data can change. Avoid hard assertions on prices/order totals. Prefer assertions on visibility, success messages, and workflow completion.
