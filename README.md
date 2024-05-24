# Simply Spend API

## Overview

Goal of the API is the provided a secured functionality set to monitor user spending

The underlying library integrating swagger to SpringBoot is [springdoc-openapi](https://github.com/springdoc/springdoc-openapi)
Start your server as an simple java application  
You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/

## Build & run project:

inside the root folder run the following commands:

```
    mvn clean package
    java -jar .\target\simply-spend-api.jar
```

## Consume API

Following Endpoints are available:

- /v1/users (e.g. http://localhost:8080/v1/users)
