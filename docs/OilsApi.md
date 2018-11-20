# OilsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**oilsGet**](OilsApi.md#oilsGet) | **GET** /oils | 
[**oilsOilIdDelete**](OilsApi.md#oilsOilIdDelete) | **DELETE** /oils/{oilId} | 
[**oilsOilIdGet**](OilsApi.md#oilsOilIdGet) | **GET** /oils/{oilId} | 
[**oilsOilIdPut**](OilsApi.md#oilsOilIdPut) | **PUT** /oils/{oilId} | 
[**oilsPost**](OilsApi.md#oilsPost) | **POST** /oils | 

<a name="oilsGet"></a>
# **oilsGet**
> ListOfOils oilsGet()



Read oils

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OilsApi;


OilsApi apiInstance = new OilsApi();
try {
    ListOfOils result = apiInstance.oilsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OilsApi#oilsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfOils**](ListOfOils.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oilsOilIdDelete"></a>
# **oilsOilIdDelete**
> oilsOilIdDelete(oilId)



Delete oil by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OilsApi;


OilsApi apiInstance = new OilsApi();
Integer oilId = 56; // Integer | oilId
try {
    apiInstance.oilsOilIdDelete(oilId);
} catch (ApiException e) {
    System.err.println("Exception when calling OilsApi#oilsOilIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oilId** | **Integer**| oilId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="oilsOilIdGet"></a>
# **oilsOilIdGet**
> OilDetails oilsOilIdGet(oilId)



Read oil by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OilsApi;


OilsApi apiInstance = new OilsApi();
Integer oilId = 56; // Integer | oilId
try {
    OilDetails result = apiInstance.oilsOilIdGet(oilId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OilsApi#oilsOilIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oilId** | **Integer**| oilId |

### Return type

[**OilDetails**](OilDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oilsOilIdPut"></a>
# **oilsOilIdPut**
> oilsOilIdPut(oilId, body)



Modify oil by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OilsApi;


OilsApi apiInstance = new OilsApi();
Integer oilId = 56; // Integer | oilId
PutOilDetails body = new PutOilDetails(); // PutOilDetails | 
try {
    apiInstance.oilsOilIdPut(oilId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling OilsApi#oilsOilIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **oilId** | **Integer**| oilId |
 **body** | [**PutOilDetails**](PutOilDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="oilsPost"></a>
# **oilsPost**
> oilsPost(body)



Add oil

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OilsApi;


OilsApi apiInstance = new OilsApi();
PostOilDetails body = new PostOilDetails(); // PostOilDetails | 
try {
    apiInstance.oilsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling OilsApi#oilsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostOilDetails**](PostOilDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

