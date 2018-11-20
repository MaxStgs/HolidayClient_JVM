# OutsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**outsGet**](OutsApi.md#outsGet) | **GET** /outs | 
[**outsOutIdDelete**](OutsApi.md#outsOutIdDelete) | **DELETE** /outs/{outId} | 
[**outsOutIdGet**](OutsApi.md#outsOutIdGet) | **GET** /outs/{outId} | 
[**outsOutIdPut**](OutsApi.md#outsOutIdPut) | **PUT** /outs/{outId} | 
[**outsPost**](OutsApi.md#outsPost) | **POST** /outs | 

<a name="outsGet"></a>
# **outsGet**
> ListOfOuts outsGet()



Reading list of outs

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OutsApi;


OutsApi apiInstance = new OutsApi();
try {
    ListOfOuts result = apiInstance.outsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OutsApi#outsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfOuts**](ListOfOuts.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="outsOutIdDelete"></a>
# **outsOutIdDelete**
> outsOutIdDelete(outId)



Delete out by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OutsApi;


OutsApi apiInstance = new OutsApi();
Integer outId = 56; // Integer | outId
try {
    apiInstance.outsOutIdDelete(outId);
} catch (ApiException e) {
    System.err.println("Exception when calling OutsApi#outsOutIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **outId** | **Integer**| outId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="outsOutIdGet"></a>
# **outsOutIdGet**
> OutDetails outsOutIdGet(outId)



Get out by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OutsApi;


OutsApi apiInstance = new OutsApi();
Integer outId = 56; // Integer | outId
try {
    OutDetails result = apiInstance.outsOutIdGet(outId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OutsApi#outsOutIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **outId** | **Integer**| outId |

### Return type

[**OutDetails**](OutDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="outsOutIdPut"></a>
# **outsOutIdPut**
> outsOutIdPut(outId, body)



Modify out

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OutsApi;


OutsApi apiInstance = new OutsApi();
Integer outId = 56; // Integer | outId
PutOutDetails body = new PutOutDetails(); // PutOutDetails | 
try {
    apiInstance.outsOutIdPut(outId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling OutsApi#outsOutIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **outId** | **Integer**| outId |
 **body** | [**PutOutDetails**](PutOutDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="outsPost"></a>
# **outsPost**
> outsPost(body)



Add out

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OutsApi;


OutsApi apiInstance = new OutsApi();
PostOutDetails body = new PostOutDetails(); // PostOutDetails | 
try {
    apiInstance.outsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling OutsApi#outsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostOutDetails**](PostOutDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

