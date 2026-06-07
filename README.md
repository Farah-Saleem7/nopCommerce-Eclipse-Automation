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
- Screenshots on failure

## Covered Workflows
- Register valid customer
- Register validation errors
- Invalid login
- Logout
- Search existing and non-existing products
- Product details
- Add to compare
- Add to cart
- Update cart quantity
- Remove from cart
- Add/remove wishlist
- Guest checkout
- Contact Us

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
├── base
│   └── BaseTest.java
├── pages
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── RegisterPage.java
│   ├── LoginPage.java
│   ├── SearchPage.java
│   ├── ProductPage.java
│   ├── CartPage.java
│   ├── WishlistPage.java
│   ├── CheckoutPage.java
│   └── ContactUsPage.java
├── tests
│   ├── AuthenticationTests.java
│   ├── ProductTests.java
│   ├── CartAndWishlistTests.java
│   └── CheckoutTests.java
└── utils
    ├── TestData.java
    ├── ScreenshotUtils.java
    └── TestListener.java
```

## Notes
The public demo website data can change. Avoid hard assertions on prices/order totals. Prefer assertions on visibility, success messages, and workflow completion.
