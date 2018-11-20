# TasksApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**tasksGet**](TasksApi.md#tasksGet) | **GET** /tasks | 
[**tasksPost**](TasksApi.md#tasksPost) | **POST** /tasks | 
[**tasksTaskIdGet**](TasksApi.md#tasksTaskIdGet) | **GET** /tasks/{taskId} | 
[**tasksTaskIdPut**](TasksApi.md#tasksTaskIdPut) | **PUT** /tasks/{taskId} | 

<a name="tasksGet"></a>
# **tasksGet**
> ListOfTasks tasksGet()



Read tasks

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TasksApi;


TasksApi apiInstance = new TasksApi();
try {
    ListOfTasks result = apiInstance.tasksGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#tasksGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfTasks**](ListOfTasks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="tasksPost"></a>
# **tasksPost**
> tasksPost(body)



Add task

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TasksApi;


TasksApi apiInstance = new TasksApi();
PostTaskDetails body = new PostTaskDetails(); // PostTaskDetails | 
try {
    apiInstance.tasksPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#tasksPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostTaskDetails**](PostTaskDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="tasksTaskIdGet"></a>
# **tasksTaskIdGet**
> TaskDetails tasksTaskIdGet(taskId)



Read task by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Integer taskId = 56; // Integer | taskId
try {
    TaskDetails result = apiInstance.tasksTaskIdGet(taskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#tasksTaskIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **Integer**| taskId |

### Return type

[**TaskDetails**](TaskDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="tasksTaskIdPut"></a>
# **tasksTaskIdPut**
> tasksTaskIdPut(taskId, body)



Modify task by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Integer taskId = 56; // Integer | taskId
PutTaskDetails body = new PutTaskDetails(); // PutTaskDetails | 
try {
    apiInstance.tasksTaskIdPut(taskId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#tasksTaskIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **Integer**| taskId |
 **body** | [**PutTaskDetails**](PutTaskDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

