- Threads and Runnable are part of Basic APIs of Java SE edition.
- Limitations
  - Threads or Runnable are sufficient for low level and basic tasks.
  - Developer responsible for all the threads for the system/application in addition to business logic.
    - These basic APIs need solid and careful parallelism logic. Lot of factors need to be considered.
    For example, `what are the jobs that should be executed by threads?`, `when is a thread supposed to starts its execution?`, 
    `what happens when there is an error in the execution?`, `what happens when there is an interruption in the execution?`,
    `How to make sure that all the threads of my application are terminated when my application shuts down?`
    - For large scale applications, thread creation and management becomes tedious task with these APIs.
    - Additional requirements(Eg: jobs scheduling at certain intervals using these basic APIs) for managing thread scheduling will further force developers to write logic for it.
  

- Executor Framework: 
To overcome the above limitations in Java SE, we have Executor Advanced APIs.
  - Decouples thread creation & management from the application business logic.
    - Smooth coordination between the thread submitting the task and a thread executing the job.
    - provides clean shutdown of all tasks.
    - Helps check output of the completed task.
    - Helps schedule threads for certain jobs.
    - Framework automatically creates **Thread pools**, which helps spawn threads.
    - Callable (to return from thread) and Future (to store the returned value from thread) are provided
    - Allows thread run to throw Exceptions.
    - Works with both Runnable and Callable objects.
