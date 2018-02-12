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



Streaming:

Current Big data solution is batch processing.
Akka Streams library helps to implement the application in a bounded buffer fashion and not cause out of memory error.

Problems:
1. Blocking
2. Back Pressure

Blocking: Happen in pull based system when there is no data to pull. Consumer pulls data from the producer and blocking happens when there is no data to pull.
Safe for consumer and will not run out of the memory. Systems builds on such a logic are slow based on pulling data.

Back Pressure: It may be too fast. Happens in push based system. Producers when working with pushing data in pull system is not needed.
THe need arises when producer wants to create more data that the consumer can handle causing the consumer to crash.

Ex Source of water and sink and pipes between them. If we put pump in the end, it will still work even if there is no water at the source.
If pump is moved at start, it will still push if sink is filled and water will overflow.
Solution

Put the pump at the source and a CAP at the sink
Pump will work when the source contains water, when Sink is filled it will create backpressure and indicate the pump to stop working.

Akka Streams is similar and work on - Asynchronous dynamic push, pull and back pressure


3 Components
~Source
~sink
~flow

Runnable flow: When connecting source to sink

Materializer: It is just like project manager, cares only about making plans, he needs the results not the actual progress, cares least about resources/scedule of plan
Allocates his plan to the team lead who in turn allocate resources.
Sink, Source and Flow are plan, leader materializes it, which is StreamMaterializer, into set of worker Actors, and allocate resources to execute the plan  

Keep Left, Right or Both
toMat is the same as viaMat but for sinks, it lets you keep the materialized value from the left (source/flow) ; or right (sink) side ; or both
Keep.both is just an alias for (a:A,b:B) => (a, b), that is a function that takes the two input parameters and return them as a tuple. 
It's used to have the materialized value of both left and right side when combining two flows (or source and flow {1S1F} or flow and sink{1F1S} etc)




