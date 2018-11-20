# SubtasksApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**tasksTaskIdSubtaskIdGet**](SubtasksApi.md#tasksTaskIdSubtaskIdGet) | **GET** /tasks/{taskId}/{subtaskId} | 
[**tasksTaskIdSubtasksGet**](SubtasksApi.md#tasksTaskIdSubtasksGet) | **GET** /tasks/{taskId}/subtasks | 

<a name="tasksTaskIdSubtaskIdGet"></a>
# **tasksTaskIdSubtaskIdGet**
> SubtaskDetails tasksTaskIdSubtaskIdGet(taskId, subtaskId)



Read subtask by task ID and subtask ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubtasksApi;


SubtasksApi apiInstance = new SubtasksApi();
Integer taskId = 56; // Integer | The Task Id
Integer subtaskId = 56; // Integer | The Subtask Id
try {
    SubtaskDetails result = apiInstance.tasksTaskIdSubtaskIdGet(taskId, subtaskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubtasksApi#tasksTaskIdSubtaskIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **Integer**| The Task Id |
 **subtaskId** | **Integer**| The Subtask Id |

### Return type

[**SubtaskDetails**](SubtaskDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="tasksTaskIdSubtasksGet"></a>
# **tasksTaskIdSubtasksGet**
> ListOfSubtasks tasksTaskIdSubtasksGet(taskId)



Read subtasks by task ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SubtasksApi;


SubtasksApi apiInstance = new SubtasksApi();
Integer taskId = 56; // Integer | taskId
try {
    ListOfSubtasks result = apiInstance.tasksTaskIdSubtasksGet(taskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubtasksApi#tasksTaskIdSubtasksGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **Integer**| taskId |

### Return type

[**ListOfSubtasks**](ListOfSubtasks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

