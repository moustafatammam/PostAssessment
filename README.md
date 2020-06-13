 ### Post Assessment Application
 (Android) (Java)

An application that list, edit, delete, and create posts from a fake API.
Post are saved to the database using room when needed.

### Prerequisites

The Application Uses:

CLean Architecture

MVVP

Modularization

Android Jetback Component (Room, DataBinding, LiveData, and ViewModel)

RXJava

Dagger 2

Navigation Component

Retrofit

Gson

RecyclerView

Fragments

Constraint_Layout

### Architecture Description

The app uses Clean Architecture, it consists of,

Domain Layer: a pure java layer that is in the centre of the architecure, it consists of UseCases (InterActors) for each task,
to add a new task, just implement ObservableUseCase or CompletableUseCase and add your functionality.
it has a PostRepositoy interface which is its boundary and how the other layers communicate with it.

Data Layer: which is the single source of truth, it decides how to deal with the date.
it has PostCache interface that communicates with cache layer, and PostRemote interface that deals with the API.
it contains also DataSources that defines the opertation done in both the database and the server.

Cache Layer: the database layer using Room, it has the implementation of the PostCache that uses the Room dao to insert, delete, update and get data.

Remote Layer: contains the service client using retrofit and a GSon converter for Json, it has the implementation of the PostRemote.

Presentation Layer: the actual presenters that is responsible for using the UseCases Implemented in the Domain layer using ViewModels,
each UseCase has a ViewModel using them.
The ViewModel is created using a custom ViewModel Factory to be able to inject them to the fragments using Dagger 2.
The ViewModel lifecycle spans until onCleared(), so no data is lost in configuraion changes.

UI Layer: One activity multible Fragment Philosophy, each fragment uses a ViewModel associated with the Usecase that will save and handle UI related data.
it also contains a fragment factory to create and inject fragment using Dagger.
it has dagger modules to provide and bind dependencies when needed.

The whole application is build upon the observable pattern using RXJava's Observables and Completables.

Each layer has its model and a mapper interface to map each model to their respective layer.
