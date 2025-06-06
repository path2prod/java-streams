Repo to help mastering Java streams. It's split in multiple sections to deal with different challenges. 
Each section has its own path with 2 folders:

* `tdd` contains tests to be completed and minimum compilation set up. This approach follows TDD therefore none test must pass
* `complete` contains full code for further assistance, every test pass.

The purpose of this repo is not to complete every challenge, as nowadays any AI is able to do it in a blink. I'm playing with them to:
* Better understand functional programming
* Enhance my JAVA API searching and documentation reading skills
* Experiment with less frequently used classes
* Gain wider knowledge on Collectors and Comparators


## Notes
* Disabling Copilot autocomplete is recommended.
* Test classes must not changed
* On a test file replace `tdd` import with `complete` to run original tests
* Install jdk23
* Enable preview to run individual tests on your IDE. `Build.gradle` already contains it although this only works when tests are delegated to Gradle

## Topics 
* Fundamental Operations: Creation, mapping, filtering, and reduction.
* Intermediate and Advanced Transformations: Grouping, partitioning, custom collectors, and stream composition.
* Performance Optimization: Using specialized streams, benchmarking, and short-circuiting.
* Exception Handling and Debugging: Strategies for logging, testing, and managing errors.
* Integration with Other Java Features: Combining streams with NIO, JDBC, reflection, CompletableFuture, and more.
* Handling Edge Cases: Null values, infinite streams, order dependencies, and side effects.
* Bonus Challenges: Building mini query engines, recommendation systems, DSLs, and data migration tools.

## Sections

### 1 - Basic Stream Operations

* Create a stream of integers 1-10 and filter out all even numbers.
* Convert a list of strings to uppercase using map().
* Sum all numbers in an array using reduce().
* Find the maximum value in a list of integers.
* Check none element in a list of strings contains the letter 'a'.
* Check if any element in a list of strings contains the letter 'a'.

### 2 - Intermediate Operations

* Filter a list of Person objects to find all adults (age >= 18). Input: List<Person> where Person has name and age fields.
* Transform a list of Product objects to just their names. Input: List<Product> where Product has name and price fields.
* Sort a list of strings alphabetically, then convert to lowercase.
* Sort reversed a list of strings alphabetically, then convert to uppercase.
* Remove duplicate elements from a list.
* Skip the first 5 elements of a stream and limit the result to 10 elements.
* Use Stream.iterate() to create a Fibonacci sequence.

### 3 - Advanced Stream Processing

* Group a list of employees by department - using Gather API. Input: List<Employee> where Employee has name and department fields.
* Group a list of employees by department - using Collectors. Input: List<Employee> where Employee has name and department fields.
* Partition total students into passing and failing based on grades (passing >= 60). Input: List<Student> with name and grade fields.
* Calculate the average of all numbers in a list.
* Find the top 2 most expensive products. Input: List<Product> with name and price fields.
* Concatenate multiple streams into a single stream.

### 4 - Stream Collectors

* Group books by author and count books per author. Input: List<Book> with title and author fields.
* Find the sum, average, min, and max price of all products. Input: List<Product> with price field.
* Group transactions by currency and calculate the sum for each currency. Input: List<Transaction> with amount and currency fields.

### 5 - Parallel Streams

* Calculate the sum of a large array of numbers plus 5.
* Find all prime numbers in a range using parallel streams.
* Create a stream from a text file and count "lorem" word frequency. Input: Path to a text file.


### 6 - Specialized Streams

* Use IntStream to find the sum of all integers from 1 to 100.
* Generate a DoubleStream of random values and find their average.
* Use a LongStream to check if a number is prime.

### 7 - Complex Operations

* Define a custom collector for enhancing decimal coordeantes transforming to DMM format and joining with colon and wrapped by square brackets. Tip: use StringJoiner and `formatCoordinates` for getting expected result.
* Process a CSV file of sales data and calculate total revenue by product category. Input: CSV file with columns for product, category, price, quantity.
* Find the most frequently occurring word in a text file. Input: Path to text file.
* Flatten a list of lists into a single list using flatMap(). Input: List<List<Integer>>

### 8 - Terminal Operations

* Return if a stream of integer contains only odd numbers.
* Return if a stream of integer contains any odd numbers.
* Return if a stream of integer contains none odd numbers.
* Count total distinct words using collect(). Tip: Create a local collector variable
* Find both the minimum and maximum value in a single stream pass. Tip: Create a local collector variable for MinMaxCollector

### 9 - Exception Handling

* Builds a pipeline that converts strings to numbers, handling various format exceptions.
* Build a parallel stream of JSON products and parse them, properly logging parsing exceptions.
* Sanitise a shopping basket. Input: List<BasketItem> with <Product> and quantity, WireMock stubbed endpoints for each product returning avalaible stock `resources/mapping/section9_3.json`

### 10 - Optional Values

* Create a generic data validator that returns Optional results for different validation rules. Hint: Creating a validator builder acepting multiple validation rules and returning a functional interface validator with method validate.
* Build An Either pattern implementation for functional error handling implementing a lift pattern.
* Extract all valid phone numbers from profiles that have contact information. Input: List<UserProfile> with user and contact details

### 11 - Date/Time API Integration

* Process a stream of dates to find the earliest and latest dates. Input: List<LocalDate>

### 12 - Advanced Collectors

* Find the longest sequence of consecutive integers in a list of unsorted numbers. Input: List<Integer> containing unsorted numbers.
* Implement a custom comparator to sort products by price, then by name if prices are equal. Input: List<Product> with name and price fields.
* Create a frequency map of characters in a string, ignoring case and non-alphabetic characters. Input: Any string.
* Write a collector that performs hierarchical grouping (e.g., by year, then by month, then by day). Input: List<Event> with dateTime field.

### 13 - Functional Interfaces with Streams

* Calculate Body Mass Index implementing a currying function (BMI =W [kg]/H [m2])
* Chaining functional operations for adding title for person over 18. Input: List<Person> with name

### 14 - Combining with Other Java Features

* Use streams with CompletableFuture to process data asynchronously. Input: List<URL> to fetch data from.
* Integrate streams with Java NIO to list files in this section. Input: Directory path containing multiple files.
* Mask sensitive fields using reflection. Input: List<Person> with first and lastname.

### 15 - Advanced Stream Sources

* Create a stream from a recursive directory structure and process all files. Input: Root directory path.
* Generate a stream from a custom Iterator implementation.
* Convert third-party collection libraries (Guava, Apache Commons) to Java streams.
* Create a stream from a Socket connection to process incoming data. Input: Socket connection details.
* Implement a custom Spliterator for a specialized data source.

### 16 - Stream Composition and Reuse

* Create reusable stream transformers that can be composed together.
* Implement the decorator pattern with streams to add functionality to existing stream operations.
* Build a pipeline of stream operations that can be executed conditionally based on runtime parameters.
* Create a stream processing framework that allows dynamic addition or removal of processing steps.
* Implement function composition with streams to create complex transformations from simple ones.

### 17 - Edge Cases and Corner Scenarios

* Handle null values at various points in stream operations safely.
* Process streams with infinite elements while avoiding OutOfMemoryError.
* Manage side effects in stream operations correctly.
* Handle exceptions that occur in parallel streams appropriately.
* Deal with order-dependent operations in parallel streams.

### 18 - Real-World Applications

* Implement a search function that filters products based on multiple criteria. Input: List<Product> with name, category, price fields, and search parameters.
* Parse a log file and extract error messages, grouped by error type. Input: Path to log file.
* Process JSON data with streams using Jackson or Gson. Input: JSON string representing a collection of objects.
* Build a data transformation pipeline that processes, filters, and exports data. Input: Source data collection and transformation specifications.
* Implement a document clustering algorithm using streams and functional programming. Input: Collection of text documents.
* Build a recommendation engine that uses streams to find similar items. Input: User preferences and item catalog.
* Process time-series data to detect patterns and anomalies. Input: Stream of timestamped values.
* Implement a custom DSL (Domain Specific Language) that leverages streams for data processing.
* Create a data validation framework using streams to apply multiple validation rules. Input: Object to validate and validation rules.

### 19 - Bonus Challenges

* Create a reactive stream processing system using Java streams and CompletableFuture.
* Implement MapReduce patterns using Java streams for distributed data processing simulations.
* Build a text search engine with ranking using streams and functional programming concepts. Input: Corpus of documents and search query.
* Create a data migration tool that uses streams to transform data between different schemas. Input: Source data and transformation rules.
