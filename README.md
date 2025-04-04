Repo to help mastering java streams. It's split in multiple sections to deal with different challenges. 
Each section has its own path with 2 folders:

* `tdd` contains tests to be completed and minimum compilation set up. This approach follows TDD therefore none test must pass
* `complete` contains full code for further assistance, every test pass.

## Notes
* disabling Copilot autocomple
* test classes must not changed
* on a test file replace `tdd` import with `complete` to run original tests
* install jdk23
* enable preview to run individual tests on your IDE. `Build.gradle` already contains it although this only works when tests are delegated to Gradle

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

### 6 - Stream Sources

* Create streams from different sources: arrays, collections, values, files.
* Generate an infinite stream of random numbers and limit to the first 10.
* Create a stream from a text file and count word frequency. Input: Path to a text file.
* Use Stream.iterate() to create a Fibonacci sequence.

### 7 - Specialized Streams

* Use IntStream to find the sum of all integers from 1 to 100.
* Generate a DoubleStream of random values and find their average.
* Use a LongStream to check if a number is prime.

### 8 - Complex Operations

* Implement a custom collector that builds a balanced binary search tree.
* Process a CSV file of sales data and calculate total revenue by product category. Input: CSV file with columns for product, category, price, quantity.
* Find the most frequently occurring word in a text file. Input: Path to text file.
* Implement a sliding window algorithm using streams to find the moving average. Input: Array of prices and window size.
* Flatten a list of lists into a single list using flatMap(). Input: List<List<Integer>>

### 9 - Terminal Operations

* Use the allMatch(), anyMatch(), and noneMatch() operations with predicates.
* Implement a custom stream reduction with the collect() method.
* Count elements that satisfy a certain condition without using the count() method.
* Find both the minimum and maximum value in a single stream pass.
* Use the peek() method to debug intermediate stream operations.

### 10 - Exception Handling

* Implement proper exception handling in stream operations.
* Write a custom function that safely handles exceptions in a stream.

### 11 - Optional Values

* Use Optional with streams to handle null values safely.
* Chain multiple Optional operations after finding an element in a stream.

### 12 - Date/Time API Integration

* Process a stream of dates to find the earliest and latest dates. Input: List<LocalDate>
* Group events by month and count events per month. Input: List<Event> with title and dateTime fields.

### 13 - Complex Data Transformations

* Given a nested structure of departments with employees, calculate the average salary per department. Input: List<Department> where Department has name and List<Employee>, Employee has name and salary.
* Transform a stream of transactions into a summary report showing monthly totals. Input: List<Transaction> with date, amount, and category fields.
* Implement a custom comparator to sort products by price, then by name if prices are equal. Input: List<Product> with name and price fields.
* Create a frequency map of characters in a string, ignoring case and non-alphabetic characters. Input: Any string.
* Find the longest sequence of consecutive integers in a list of unsorted numbers. Input: List<Integer> containing unsorted numbers.

### 14 - Advanced Collectors

* Create a custom collector that builds a balanced tree map from a stream of entries.
* Implement a collector that calculates statistical summary (count, sum, min, max, average) in a single pass.
* Write a collector that performs hierarchical grouping (e.g., by year, then by month, then by day). Input: List<Event> with dateTime field.
* Create a collector that performs a running total on a stream of financial transactions. Input: List<Transaction> with amount field.
* Implement a collector that creates a histogram from a stream of values. Input: List<Double> and number of bins.

### 15 - Stream Performance and Optimization

* Compare the performance of different stream operations (filter, map, etc.) with large datasets.
* Optimize a stream pipeline that processes millions of records by reordering operations.
* Use the appropriate specialized stream type (IntStream, LongStream, DoubleStream) to improve performance.
* Implement short-circuiting operations to improve performance when finding first matches.
* Measure and optimize memory usage in stream operations that process large data sets.

### 16 - Functional Interfaces with Streams

* Create and use custom functional interfaces with streams beyond the standard ones.
* Implement a stream operation using all four standard functional interfaces (Function, Predicate, Consumer, Supplier).
* Use method references (static, instance, constructor) in different stream operations.
* Chain multiple functional operations together in a complex data processing pipeline.
* Implement currying with streams to create reusable stream transformations.

### 17 - Combining with Other Java Features

* Use streams with CompletableFuture to process data asynchronously. Input: List<URL> to fetch data from.
* Integrate streams with Java NIO to process files efficiently. Input: Directory path containing multiple files.
* Combine streams with reflection to dynamically process object properties. Input: Object and list of property names.
* Use streams with JUnit to generate test cases dynamically.
* Integrate streams with JDBC to efficiently process database query results. Input: SQL query and database connection.

### 18 - Advanced Stream Sources

* Create a stream from a recursive directory structure and process all files. Input: Root directory path.
* Generate a stream from a custom Iterator implementation.
* Convert third-party collection libraries (Guava, Apache Commons) to Java streams.
* Create a stream from a Socket connection to process incoming data. Input: Socket connection details.
* Implement a custom Spliterator for a specialized data source.

### 19 - Stream Debugging and Testing

* Add logging at different points in a stream pipeline without affecting the result.
* Test stream operations with JUnit, including parallel streams.
* Implement proper exception handling and error recovery in stream operations.
* Create a utility to visualize the intermediate results of a stream pipeline.
* Track and measure resource usage (memory, CPU) during stream processing.


### 20 - Stream Composition and Reuse

* Create reusable stream transformers that can be composed together.
* Implement the decorator pattern with streams to add functionality to existing stream operations.
* Build a pipeline of stream operations that can be executed conditionally based on runtime parameters.
* Create a stream processing framework that allows dynamic addition or removal of processing steps.
* Implement function composition with streams to create complex transformations from simple ones.

### 21 - Edge Cases and Corner Scenarios

* Handle null values at various points in stream operations safely.
* Process streams with infinite elements while avoiding OutOfMemoryError.
* Manage side effects in stream operations correctly.
* Handle exceptions that occur in parallel streams appropriately.
* Deal with order-dependent operations in parallel streams.

### 22 - Real-World Applications

* Implement a search function that filters products based on multiple criteria. Input: List<Product> with name, category, price fields, and search parameters.
* Parse a log file and extract error messages, grouped by error type. Input: Path to log file.
* Process JSON data with streams using Jackson or Gson. Input: JSON string representing a collection of objects.
* Build a data transformation pipeline that processes, filters, and exports data. Input: Source data collection and transformation specifications.
* Implement a document clustering algorithm using streams and functional programming. Input: Collection of text documents.
* Build a recommendation engine that uses streams to find similar items. Input: User preferences and item catalog.
* Process time-series data to detect patterns and anomalies. Input: Stream of timestamped values.
* Implement a custom DSL (Domain Specific Language) that leverages streams for data processing.
* Create a data validation framework using streams to apply multiple validation rules. Input: Object to validate and validation rules.

### 23 - Bonus Challenges

* Create a reactive stream processing system using Java streams and CompletableFuture.
* Implement MapReduce patterns using Java streams for distributed data processing simulations.
* Build a text search engine with ranking using streams and functional programming concepts. Input: Corpus of documents and search query.
* Create a data migration tool that uses streams to transform data between different schemas. Input: Source data and transformation rules.
