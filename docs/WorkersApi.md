# WorkersApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**workersGet**](WorkersApi.md#workersGet) | **GET** /workers | 
[**workersOrderIdGet**](WorkersApi.md#workersOrderIdGet) | **GET** /workers/{orderId} | 
[**workersPost**](WorkersApi.md#workersPost) | **POST** /workers | 
[**workersWorkerIdGet**](WorkersApi.md#workersWorkerIdGet) | **GET** /workers/{workerId} | 
[**workersWorkerIdPut**](WorkersApi.md#workersWorkerIdPut) | **PUT** /workers/{workerId} | 

<a name="workersGet"></a>
# **workersGet**
> ListOfWorkers workersGet()



Read workers

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WorkersApi;


WorkersApi apiInstance = new WorkersApi();
try {
    ListOfWorkers result = apiInstance.workersGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkersApi#workersGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfWorkers**](ListOfWorkers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="workersOrderIdGet"></a>
# **workersOrderIdGet**
> workersOrderIdGet(orderId)



Read worker by order ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WorkersApi;


WorkersApi apiInstance = new WorkersApi();
Integer orderId = 56; // Integer | orderId
try {
    apiInstance.workersOrderIdGet(orderId);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkersApi#workersOrderIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Integer**| orderId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="workersPost"></a>
# **workersPost**
> workersPost(body)



Add worker

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WorkersApi;


WorkersApi apiInstance = new WorkersApi();
PostWorkerDetails body = new PostWorkerDetails(); // PostWorkerDetails | 
try {
    apiInstance.workersPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkersApi#workersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostWorkerDetails**](PostWorkerDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="workersWorkerIdGet"></a>
# **workersWorkerIdGet**
> WorkerDetails workersWorkerIdGet(workerId)



Read worker by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WorkersApi;


WorkersApi apiInstance = new WorkersApi();
Integer workerId = 56; // Integer | workerId
try {
    WorkerDetails result = apiInstance.workersWorkerIdGet(workerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkersApi#workersWorkerIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workerId** | **Integer**| workerId |

### Return type

[**WorkerDetails**](WorkerDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="workersWorkerIdPut"></a>
# **workersWorkerIdPut**
> workersWorkerIdPut(workerId, body)



Modify worker by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WorkersApi;


WorkersApi apiInstance = new WorkersApi();
Integer workerId = 56; // Integer | workerId
PutWorkerDetails body = new PutWorkerDetails(); // PutWorkerDetails | 
try {
    apiInstance.workersWorkerIdPut(workerId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkersApi#workersWorkerIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **workerId** | **Integer**| workerId |
 **body** | [**PutWorkerDetails**](PutWorkerDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

