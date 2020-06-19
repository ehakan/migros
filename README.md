# Software Quality & Testing HW3

[Project Repository](https://github.com/ehakan/migros)

### Group Info
- Efe Hakan Gencoglu - 150160003 - gencoglu16@itu.edu.tr
- Mehves Altay - 150160028 - altaym16@itu.edu.tr

## Notes

- All of our tests reside in `tests.purchase` class

- We use JUnit 5 instead of 4 due to issues with test classes not having their own context.
(Namely test class lifecycles and static nature of `@BeforeClass` and `@AfterClass` in JUnit 4)
This caused Selenium sessions to not work properly when running multiple tests. We had to move away from static `AbstractTest` contexts
to solve this issue. As a bonus we can run multiple test classes concurrently.
(Can be enabled in `resources/junit-platform.properties`, set the first line to true, not recommended for laptops)

- `pages` package has been refactored as `nav`. Instead of just depending on large page objects
we've also decided to use small classes that represent UI components. These components still
derive from `AbstractPage`.

- Directly opening the project in IntelliJ IDEA works. If you encounter any issues during project setup,
feel free to reach us.
