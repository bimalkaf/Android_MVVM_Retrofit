# Weather App - Android


The Weather App is a simple Android application that allows users to check the current weather conditions for a specific location. It demonstrates the usage of the MVVM architecture, Retrofit for API calls, Glide for image loading, and clean code organization. This README will provide an overview of the project, its components, and how to set it up.


## Key Technologies and Principles  

- **MVVM Architecture (Model-View-ViewModel):**
  - Model: Data and business logic.
  - View: UI elements and layout.
  - ViewModel: Intermediary for UI logic.

- **Retrofit:**
  - Type-Safe HTTP clients.
  - Easy network requests and JSON handling.
  - Integration with libraries like Gson.

- **Glide:**
  - Efficient image loading and caching.
  - Reduced bandwidth usage and improved performance.
  - Seamless integration with ImageView.

- **Dagger and Hilt:**
  - Dependency injection for modular code.
  - Simplified dependency injection with Hilt.

- **Clean Code and Clean Architecture:**
  - Maintainable, easy-to-read code.
  - Highly testable and scalable.
  - Separation of concerns for flexibility.


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


