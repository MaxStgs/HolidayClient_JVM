# ComingsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**comingsComingIdDelete**](ComingsApi.md#comingsComingIdDelete) | **DELETE** /comings/{comingId} | 
[**comingsComingIdGet**](ComingsApi.md#comingsComingIdGet) | **GET** /comings/{comingId} | 
[**comingsComingIdPut**](ComingsApi.md#comingsComingIdPut) | **PUT** /comings/{comingId} | 
[**comingsGet**](ComingsApi.md#comingsGet) | **GET** /comings | 
[**comingsPost**](ComingsApi.md#comingsPost) | **POST** /comings | 

<a name="comingsComingIdDelete"></a>
# **comingsComingIdDelete**
> comingsComingIdDelete(comingId)



Delete some coming

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ComingsApi;


ComingsApi apiInstance = new ComingsApi();
Integer comingId = 56; // Integer | comingId
try {
    apiInstance.comingsComingIdDelete(comingId);
} catch (ApiException e) {
    System.err.println("Exception when calling ComingsApi#comingsComingIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **comingId** | **Integer**| comingId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="comingsComingIdGet"></a>
# **comingsComingIdGet**
> ComingDetails comingsComingIdGet(comingId)



Reading coming by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ComingsApi;


ComingsApi apiInstance = new ComingsApi();
Integer comingId = 56; // Integer | comingId
try {
    ComingDetails result = apiInstance.comingsComingIdGet(comingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ComingsApi#comingsComingIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **comingId** | **Integer**| comingId |

### Return type

[**ComingDetails**](ComingDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="comingsComingIdPut"></a>
# **comingsComingIdPut**
> comingsComingIdPut(comingId, body)



Modify coming

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ComingsApi;


ComingsApi apiInstance = new ComingsApi();
Integer comingId = 56; // Integer | comingId
PutComingDetails body = new PutComingDetails(); // PutComingDetails | 
try {
    apiInstance.comingsComingIdPut(comingId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ComingsApi#comingsComingIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **comingId** | **Integer**| comingId |
 **body** | [**PutComingDetails**](PutComingDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="comingsGet"></a>
# **comingsGet**
> ListOfComings comingsGet()



Reading list of comings

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ComingsApi;


ComingsApi apiInstance = new ComingsApi();
try {
    ListOfComings result = apiInstance.comingsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ComingsApi#comingsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfComings**](ListOfComings.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="comingsPost"></a>
# **comingsPost**
> comingsPost(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ComingsApi;


ComingsApi apiInstance = new ComingsApi();
PostComingDetails body = new PostComingDetails(); // PostComingDetails | 
try {
    apiInstance.comingsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling ComingsApi#comingsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostComingDetails**](PostComingDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

