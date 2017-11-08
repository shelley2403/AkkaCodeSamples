* Problem Shared Mutable State
- A large number of stateful objects whose state can be changed by multiple parts of your application
- Solve this problem by preventing multiple threads from mutating data simultaneously 

* Actor Model
- We need objects that can handle non-blocking operations and save this internal state from external objects.
- An actor is a computation entity that in response to a message it receives can concurrently send finite number of messages
to other actors, create finite number of new actors, designate the behavior to be used for the next message it receives.
- This means actor was designed to communicate throw messages and depending on the message it can change its state and
maybe change its behaviour to handle specific message.

* Concepts and Terminology

* Concurrency versus Parallelism
- Concurrency is when two tasks may start, run, and complete with overlapping time periods (Multi-tasking on single core machine)
- Parallelism is when tasks literally run at the same time (Multi-threads on Multicore processor)

* Asynchronous vs Synchronous
- A method is called synchronous if the called cannot make progress until the method returns a value or throws an exception
- A method call is asynchronous if the caller can make progress after a finite number of steps, 
and the completion of the method may be signaled via some additional mechanism (callback, future or message) 
 
* Non-Blocking vs Blocking
- Blocking is when if delay of one thread can indefinitely delay some of the other threads
- Non-blocking means that no thread is able to indefinitely delay others

* Race Condition
- When multiples have a shared mutable state. In fact, problems only arise if one or more of the threads try to change this state at the same time.
- Actors are safe from the race condition as they receive messages one by one.

