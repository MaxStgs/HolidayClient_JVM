# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.CarsApi;

import java.io.File;
import java.util.*;

public class CarsApiExample {

    public static void main(String[] args) {
        
        CarsApi apiInstance = new CarsApi();
        Integer carId = 56; // Integer | carId
        try {
            CarDetails result = apiInstance.carsCarIdGet(carId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CarsApi#carsCarIdGet");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:5000*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CarsApi* | [**carsCarIdGet**](docs/CarsApi.md#carsCarIdGet) | **GET** /cars/{carId} | 
*CarsApi* | [**carsCarIdPut**](docs/CarsApi.md#carsCarIdPut) | **PUT** /cars/{carId} | 
*CarsApi* | [**carsGet**](docs/CarsApi.md#carsGet) | **GET** /cars | 
*CarsApi* | [**carsPost**](docs/CarsApi.md#carsPost) | **POST** /cars | 
*ComingsApi* | [**comingsComingIdDelete**](docs/ComingsApi.md#comingsComingIdDelete) | **DELETE** /comings/{comingId} | 
*ComingsApi* | [**comingsComingIdGet**](docs/ComingsApi.md#comingsComingIdGet) | **GET** /comings/{comingId} | 
*ComingsApi* | [**comingsComingIdPut**](docs/ComingsApi.md#comingsComingIdPut) | **PUT** /comings/{comingId} | 
*ComingsApi* | [**comingsGet**](docs/ComingsApi.md#comingsGet) | **GET** /comings | 
*ComingsApi* | [**comingsPost**](docs/ComingsApi.md#comingsPost) | **POST** /comings | 
*EquipmentsApi* | [**equipmentEquipmentIdGet**](docs/EquipmentsApi.md#equipmentEquipmentIdGet) | **GET** /equipment/{equipmentId} | 
*EquipmentsApi* | [**equipmentEquipmentIdPut**](docs/EquipmentsApi.md#equipmentEquipmentIdPut) | **PUT** /equipment/{equipmentId} | 
*EquipmentsApi* | [**equipmentGet**](docs/EquipmentsApi.md#equipmentGet) | **GET** /equipment | 
*EquipmentsApi* | [**equipmentOrderIdGet**](docs/EquipmentsApi.md#equipmentOrderIdGet) | **GET** /equipment/{orderId} | 
*EquipmentsApi* | [**equipmentPost**](docs/EquipmentsApi.md#equipmentPost) | **POST** /equipment | 
*OilsApi* | [**oilsGet**](docs/OilsApi.md#oilsGet) | **GET** /oils | 
*OilsApi* | [**oilsOilIdDelete**](docs/OilsApi.md#oilsOilIdDelete) | **DELETE** /oils/{oilId} | 
*OilsApi* | [**oilsOilIdGet**](docs/OilsApi.md#oilsOilIdGet) | **GET** /oils/{oilId} | 
*OilsApi* | [**oilsOilIdPut**](docs/OilsApi.md#oilsOilIdPut) | **PUT** /oils/{oilId} | 
*OilsApi* | [**oilsPost**](docs/OilsApi.md#oilsPost) | **POST** /oils | 
*OrdersApi* | [**equipmentOrderIdGet**](docs/OrdersApi.md#equipmentOrderIdGet) | **GET** /equipment/{orderId} | 
*OrdersApi* | [**orderGet**](docs/OrdersApi.md#orderGet) | **GET** /order | 
*OrdersApi* | [**orderOrderIdGet**](docs/OrdersApi.md#orderOrderIdGet) | **GET** /order/{orderId} | 
*OrdersApi* | [**orderPost**](docs/OrdersApi.md#orderPost) | **POST** /order | 
*OrdersApi* | [**ordersGet**](docs/OrdersApi.md#ordersGet) | **GET** /orders | 
*OrdersApi* | [**ordersOrderIdGet**](docs/OrdersApi.md#ordersOrderIdGet) | **GET** /orders/{orderId} | 
*OrdersApi* | [**workersOrderIdGet**](docs/OrdersApi.md#workersOrderIdGet) | **GET** /workers/{orderId} | 
*OutsApi* | [**outsGet**](docs/OutsApi.md#outsGet) | **GET** /outs | 
*OutsApi* | [**outsOutIdDelete**](docs/OutsApi.md#outsOutIdDelete) | **DELETE** /outs/{outId} | 
*OutsApi* | [**outsOutIdGet**](docs/OutsApi.md#outsOutIdGet) | **GET** /outs/{outId} | 
*OutsApi* | [**outsOutIdPut**](docs/OutsApi.md#outsOutIdPut) | **PUT** /outs/{outId} | 
*OutsApi* | [**outsPost**](docs/OutsApi.md#outsPost) | **POST** /outs | 
*SecurityApi* | [**loginPost**](docs/SecurityApi.md#loginPost) | **POST** /login | 
*StatementsApi* | [**statementsGet**](docs/StatementsApi.md#statementsGet) | **GET** /statements | 
*StatementsApi* | [**statementsPost**](docs/StatementsApi.md#statementsPost) | **POST** /statements | 
*SubtasksApi* | [**tasksTaskIdSubtaskIdGet**](docs/SubtasksApi.md#tasksTaskIdSubtaskIdGet) | **GET** /tasks/{taskId}/{subtaskId} | 
*SubtasksApi* | [**tasksTaskIdSubtasksGet**](docs/SubtasksApi.md#tasksTaskIdSubtasksGet) | **GET** /tasks/{taskId}/subtasks | 
*TasksApi* | [**tasksGet**](docs/TasksApi.md#tasksGet) | **GET** /tasks | 
*TasksApi* | [**tasksPost**](docs/TasksApi.md#tasksPost) | **POST** /tasks | 
*TasksApi* | [**tasksTaskIdGet**](docs/TasksApi.md#tasksTaskIdGet) | **GET** /tasks/{taskId} | 
*TasksApi* | [**tasksTaskIdPut**](docs/TasksApi.md#tasksTaskIdPut) | **PUT** /tasks/{taskId} | 
*WorkersApi* | [**workersGet**](docs/WorkersApi.md#workersGet) | **GET** /workers | 
*WorkersApi* | [**workersOrderIdGet**](docs/WorkersApi.md#workersOrderIdGet) | **GET** /workers/{orderId} | 
*WorkersApi* | [**workersPost**](docs/WorkersApi.md#workersPost) | **POST** /workers | 
*WorkersApi* | [**workersWorkerIdGet**](docs/WorkersApi.md#workersWorkerIdGet) | **GET** /workers/{workerId} | 
*WorkersApi* | [**workersWorkerIdPut**](docs/WorkersApi.md#workersWorkerIdPut) | **PUT** /workers/{workerId} | 

## Documentation for Models

 - [CarDetails](docs/CarDetails.md)
 - [ComingDetails](docs/ComingDetails.md)
 - [EquipmentDetails](docs/EquipmentDetails.md)
 - [ListOfCars](docs/ListOfCars.md)
 - [ListOfComings](docs/ListOfComings.md)
 - [ListOfEquipments](docs/ListOfEquipments.md)
 - [ListOfOils](docs/ListOfOils.md)
 - [ListOfOrdersFromSite](docs/ListOfOrdersFromSite.md)
 - [ListOfOuts](docs/ListOfOuts.md)
 - [ListOfStatements](docs/ListOfStatements.md)
 - [ListOfSubtasks](docs/ListOfSubtasks.md)
 - [ListOfTasks](docs/ListOfTasks.md)
 - [ListOfWorkers](docs/ListOfWorkers.md)
 - [LoginDetails](docs/LoginDetails.md)
 - [OilDetails](docs/OilDetails.md)
 - [OrderFromSiteDetails](docs/OrderFromSiteDetails.md)
 - [OutDetails](docs/OutDetails.md)
 - [PostCarDetails](docs/PostCarDetails.md)
 - [PostComingDetails](docs/PostComingDetails.md)
 - [PostEquipmentDetails](docs/PostEquipmentDetails.md)
 - [PostLoginDetails](docs/PostLoginDetails.md)
 - [PostOilDetails](docs/PostOilDetails.md)
 - [PostOrderFromSiteDetails](docs/PostOrderFromSiteDetails.md)
 - [PostOutDetails](docs/PostOutDetails.md)
 - [PostStatementDetails](docs/PostStatementDetails.md)
 - [PostTaskDetails](docs/PostTaskDetails.md)
 - [PostWorkerDetails](docs/PostWorkerDetails.md)
 - [PutCarDetails](docs/PutCarDetails.md)
 - [PutComingDetails](docs/PutComingDetails.md)
 - [PutEquipmentDetails](docs/PutEquipmentDetails.md)
 - [PutOilDetails](docs/PutOilDetails.md)
 - [PutOutDetails](docs/PutOutDetails.md)
 - [PutTaskDetails](docs/PutTaskDetails.md)
 - [PutWorkerDetails](docs/PutWorkerDetails.md)
 - [StatementDetails](docs/StatementDetails.md)
 - [SubtaskDetails](docs/SubtaskDetails.md)
 - [TaskDetails](docs/TaskDetails.md)
 - [UnauthorizedError](docs/UnauthorizedError.md)
 - [WorkerDetails](docs/WorkerDetails.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


