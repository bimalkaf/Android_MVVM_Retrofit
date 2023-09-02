# Weather App - Android


The Weather App is a simple Android application that allows users to check the current weather conditions for a specific location. It demonstrates the usage of the MVVM architecture, Retrofit for API calls, Glide for image loading, and clean code organization. This README will provide an overview of the project, its components, and how to set it up.


## Key Technologies and Principles

### MVVM Architecture (Model-View-ViewModel)

MVVM is chosen as the architectural pattern for the Weather App because it offers a clear separation of concerns, making the codebase more maintainable and testable. In this pattern:

- **Model**: Represents the data and business logic. In the Weather App, the Model includes the weather data models and the repository.

- **View**: Represents the UI elements and their layout. Activities and fragments in the app serve as the Views.

- **ViewModel**: Acts as an intermediary between the Model and View. It holds the UI-related data and logic, ensuring that the View remains decoupled from the underlying data sources. In the Weather App, the MainViewModel serves this purpose, making it easy to update the UI when weather data changes.

### Retrofit

Retrofit is utilized for making API requests to the WeatherAPI. Here's why Retrofit is a great choice:

- **Type-Safe**: Retrofit generates HTTP clients for your API endpoints at compile time, making it type-safe. This helps catch API-related errors early in development.

- **Ease of Use**: It simplifies the process of creating network requests, handling responses, and converting JSON data into Java/Kotlin objects.

- **Integration**: Retrofit can be easily integrated with other libraries, such as Gson for JSON serialization/deserialization.

### Glide

Glide is used for efficient loading and caching of weather condition images in the Weather App. Here's why Glide is beneficial:

- **Image Optimization**: Glide handles image loading efficiently, resizing and caching images to reduce bandwidth usage and improve app performance.

- **Integration**: It integrates seamlessly with Android's ImageView and supports features like placeholder images and error handling, enhancing the user experience.

### Dagger and Hilt

The Weather App now incorporates Dagger and Hilt for dependency injection:

- **Dagger**: Dagger is used to manage dependencies and enable efficient, modular code design.

- **Hilt**: Hilt simplifies dependency injection in Android apps, making it easier to provide and inject dependencies while following best practices.


### Clean Code and Clean Architecture

The project follows clean architecture principles to maintain a clean and modular codebase. Here's why clean code is crucial:

- **Maintainability**: Clean code is easy to read, understand, and modify. It reduces the likelihood of introducing bugs when making changes.

- **Testability**: A clean and modular codebase is highly testable, allowing for automated testing to catch issues early in development.

- **Scalability**: Clean architecture separates concerns, making it easier to scale and extend the application with new features or modules.

By leveraging these technologies and adhering to best practices, the Weather App ensures code quality, performance, and developer productivity, ultimately delivering a better experience to users.



## Features

- Display current weather conditions for a user-specified location.
- Dynamic background changes based on the time of day (day or night).
- Real-time updates using the WeatherAPI.

## How to run 
1 Clone this repo 

`git clone https://github.com/bimalkaf/Android_Retrofit`

2 In the RetrofitHelper class located in the np.com.bimalkafle.api package, replace YOUR_API_KEY with your actual API key:

`private const val API_KEY = "YOUR_API_KEY"`

Get api key from https://www.weatherapi.com/

3. Build and Run:
   
   Open the project in Android Studio or your preferred Android development environment. Build and run the application on an Android emulator or a physical Android device.

## Branches

This repository includes multiple branches to demonstrate various stages of development:

- **retrofit_mvvm**: The base branch showcasing the implementation of MVVM architecture with Retrofit for API requests.
  
- **retrofit_mvvm+dagger**: Extends the base branch with Dagger for dependency injection.
  
- **retrofit_mvvm+dagger+hilt**: Further enhances the previous branch by replacing Dagger with Hilt for dependency injection.

- **main**: The main branch where the latest features and enhancements from the other branches are merged.

You can switch between branches to explore the different stages of development and see how Retrofit, MVVM, Dagger, and Hilt are integrated into the Weather App.


## Screenshots

![Untitled design](https://github.com/bimalkaf/Android_Retrofit/assets/60041910/b63a1f88-88f4-441c-bad4-a928b3451f1c)


