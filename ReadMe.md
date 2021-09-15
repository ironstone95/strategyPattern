# strategyPattern
In the application https://jsonplaceholder.typicode.com/ json placeholder api were used.

## What is this about?
The program implements the strategy pattern in a repository. The repository has three interfaces they are:
1. IPostWriter -> Writes given post or posts
2. IPostReader -> Reads post or posts
3. ExceptionHandler -> Handles exceptions in the repository

Also, in the program there are five classes that implements a specific interface, they are:
1. NetworkPostWriter -> Writes given post or posts to the API using retrofit.
2. NetworkPostReader -> Reads post or posts from the API using retrofit.
3. FilePostWriter -> Writes given post or posts to a file.
4. FilePostReader -> Reads post or posts from a file.
5. LogExceptionHandler -> Handles exceptions only by logging them using Exception::printStackTrace

# Features
In the repository each service can be replaced with another one. In example, the posts can be read from API and written to a file. Also, these behaviors can be changed at runtime.

# Unit Tests
For all services 'currently 2 services' unit tests were handled using jUnit.
