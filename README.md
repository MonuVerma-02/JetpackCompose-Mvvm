# JetpackCompose - Android Clean Architecture

Sample app that display list of Animals.The Purpose of the project to illustrate the usage of Jetpack Compose with clean architecture.
<br/>

#### Including:
* Jetpack Compose
* MVVM Architecture
* DaggerHilt
* Coroutines
* Flow

## Application Architecture

- IDE: Android Studio
- Programming Language: Kotlin
- Architecture: MVVM architecture using Modular & Use Case 
- Third Party Libraries: Jetpack Compose, Coroutines, Flow, DaggerHilt, Navigation Component, Retrofit, Coil


## Code Structuring approach

- MVVM separates your view (i.e. Activitys and Composable) from your business logic. MVVM is enough for small projects, but when your codebase becomes huge, so this  architecture will be useful for that.
- MVVM with Clean Architecture goes one step further in separating the responsibilities of your code base.


## Jetpack Compose

Jetpack Compose is a modern UI toolkit recently launched by Google which is used for building native Android UI. It simplifies and accelerates the UI development with less code, Kotlin APIs, and powerful tools. 

   #### Some Basic Functions of Jetpack Compose
   
   1. **Composable Function:** Composable Function is represented in code by using @Composable annotation to the function name. This function will let you define your app’s UI programmatically by describing its shape and data dependencies rather than focusing on the UI construction process.
   
   2. **Preview Function:** The name of the function itself tells us that the function is used to generate the preview of the composable function. It is used to display a preview of our composable functions within our IDE rather than installing our APK in an emulator or a virtual device. The preview function is annotated by @Preview.
   
   3. **Column Function:** The column function is used to stack UI elements in a vertical manner. This function will stack all the children directly one after another in a vertical manner with no spacing between them. It is annotated with Column().
   
   4. **Row Function:** The row function is used to stack UI elements in a horizontal manner. This function will stack all the children one after the other in a horizontal manner with no spacing between them. It is annotated with Row().

   5. **Box:** A widget that is used to positioned elements one over another. It will position its children relative to its edges. The stack is used to draw the children which will overlap in the order that they are specified. It is annotated with Box().

  6. **Spacer:** It is used to give spacing between two views. We can specify the height and width of the box. It is an empty box that is used to give spacing between  the views. It is annotated with Spacer().

  7. **Lazy List:** This composable is equivalent to a recycler view in android’s view system. It is annotated with LazyColumn() or LazyRow()

<br/>

## 🚀 Learning Tips:

First of all the layers in CLEAN architecture has been separated into individual modules in a single Android project. For example android modules like **app**, **presentation**, **data** and **domain**. Notice the dependency of these modules, as per the depedency rule of CLEAN architecture, all the dependencies directly or indirectly point towards the the domain layer. The domain layer incorporates model, Use-cases and interfaces required to cross boundaries, Repository in this case. The Data layer handles data and communicates with data source remote in this case, to provides required data requested by the presentation layer. View layer will observe on the presentation layer’s stateFlow object, to get the updated data on state change.

 #### Reason for using CLEAN architecture
 
 - Your code will be even more easily testable than with plain MVVM.
 - Your code will be further decoupled.
 - The project will be even easier to maintain.
 - Your team can add new features even more quickly.
 - Inner layer module dont know about outer layer, hence, outer data formats can’t be used in inner layer
Dependencies can only point inwards.

## Screenshots
|<img src="screenshots/screen_1.jpg" width=200/>|<img src="screenshots/screen_2.jpg" width=200/>|<img src="screenshots/screen_3.jpg" width=200/>|
|:----:|:----:|:----:|
