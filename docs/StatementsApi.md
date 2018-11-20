# StatementsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**statementsGet**](StatementsApi.md#statementsGet) | **GET** /statements | 
[**statementsPost**](StatementsApi.md#statementsPost) | **POST** /statements | 

<a name="statementsGet"></a>
# **statementsGet**
> ListOfStatements statementsGet()



Read statements

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StatementsApi;


StatementsApi apiInstance = new StatementsApi();
try {
    ListOfStatements result = apiInstance.statementsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StatementsApi#statementsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfStatements**](ListOfStatements.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="statementsPost"></a>
# **statementsPost**
> statementsPost(body)



Add statement

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StatementsApi;


StatementsApi apiInstance = new StatementsApi();
PostStatementDetails body = new PostStatementDetails(); // PostStatementDetails | 
try {
    apiInstance.statementsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling StatementsApi#statementsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostStatementDetails**](PostStatementDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

