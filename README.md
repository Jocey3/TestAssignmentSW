Terms of Reference

Develop an Android application that interacts with StarWars API, performs search functions, and adds favorites to a list. API documentation: https://swapi.dev/documentation

Functional requirements
General requirements

The app should consist of 3 functional screens:
1) character search;
2) list of favorite characters;
3) detailed information about a character.

- There must be BottomNavigationView on the main screen to switch between the search screen and the list of favorite characters.
- Characters can be added to/removed from favorites on all the screens (search, detailed information about a character, list of favorite characters).
- The character details screen should display general information and a list of movies that character is in.


Additional task
- Display character photo

Technical requirements
- In Kotlin
- Use Retrofit or Ktor to work with Rest API
- Display errors (for example, No internet connection)
- The list of Favorites must be accessible offline (use Room).
- Use Kotlin Coroutines to work with multithreading (optional)
- minSdkVersion 26


Additional recommendations
- Feel free to use third party libraries and frameworks.
- Follow the guidelines and existing best practices for user interface and software design.
- Use styles and resources.
- Upload your source code to a public Github repository.

Score Card


1) Implementation of search (live search, input delay)
2) Ability to add to Favorites
3) Working with DB
4) Working with UI
5) Application architecture
6) Displaying the character photo 

