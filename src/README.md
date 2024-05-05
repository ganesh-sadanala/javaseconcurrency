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
- ExecutorService Demo Usecase:
  - Read user information from a file, process them, and insert a record for each user into a database.
  ![ExecutorServiceArch.png](main%2Fresources%2FExecutorServiceArch.png)
- ScheduledExecutorService Demo Usecase:
  - Housekeeping job for the application.
  - Pick a folder, list all the files from it and check if they are older than a specific time limit; if so delete them;
  schedule a job for this periodic check.
- ThreadFactory
  - Custom thread factory allows to break the default implementation



- **Need for Java Enterprise Edition(JEE) concurrency APIs**
  - Java EE applications work within an underlying container or an application server.
  - Containers provide runtime support for application components like EJBs and Servlets 
    (they provide a layer between application component code and platform resources and services).
  - Java EE servers provide central resource management(Resources like JDBC DataSources, connection pooling, transaction management, ).
  - Management environment set up by the container.
  - In such an environment, application integrity is important. When we have a management environment like that
    applications can co-exist without causing any harm to the overall system.
  - When you have a thread running a job in an enterprise environment, the container is going to expect that the thread gets all the 
    container's supplied objects and resources to run the asynchronous task.
  - Another thing is the thread is required to access the Standard Enterprise Edition services, like 
    JMS, EJB, etc. For this contextual information(directory interface naming, class loader information, security context)
    of container need to be propagated to the threads 
    to access standard JEE services.
  - It is very important that container propagates this information to all the threads executing the jobs for you.
  - **If we try to create our own threads, using the Java SE then the container will not be aware/wouldn't have knowledge
    on any of these thread resources. In that case, it will be a problem because it will not be able to provide correctly the contextual information needed
    to access the Java Enterprise services.**
  - It will be wiser for the container to manage those threads instead of us managing them.