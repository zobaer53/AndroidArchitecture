# AndroidArchitecture
Practice of MVC,MCP,MVVM architecture with JAVA

Let me share my learnings from the course:



What is architectural pattern?

- it is the separation of programs into modules, making code development, update, and reuse easier and faster.



1.  MVC: model-view-controller

view is an android component, controller has business logic and model is a blueprint for data.

when view needs info it calls controller calls model gets it from API or database. 



Pros:  view is separated from business logic.



Cons:  MVC has a very tight coupling between the controller and view so the problem is you can not basically have requirements change, you can not swap in a new viewer for the same controller. you have to change the view and controller, you have to go into code and change many things, for small projects it's okay but for large projects it's an issue.



2. MVP: model-view-presenter

in MVP presenter gets info from the model, model gets from API or database. The presenter does not know which view it's talking to, it just sends information and transmits

 it to an interface view and whichever view is there picks it up and handles it by implementing the interface view.



Pros:  so if requirements change that we can swap the view in and out as we please.



Cons:  MVP has a strong connection with the presenter so if requirements change then we have to change the presenter.



3. MVVM : model-view-ViewModel



difference between ViewModel and model:

the model doesn't call or demand that the ViewModel handle the information straight away.it lets the view model handle it whenever it can.



In MVVM  ViewModel talks to the model and the model basically reply with an observable(it is basically some object that you can subscribe to).

when something happens the model will notify you. so they don't call the model directly it's not synchronous, it emits events and the model handles those events.





ViewModel emits events and view handles those events it can or wants. so view calls to ViewModel and ViewModel tells view that there is an observable which is going to emit events

ViewModel does not call back to view it just updates the observable. view gets the information from observable. so view can handle events when it wants

without a specific call from ViewModel. 



pros: this separates the view from ViewModel, ViewModel is non-android so unit testing is efficient here.

cons: This can confuse the developer and make the development or debugging process complicated.
