# SecurityApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**loginPost**](SecurityApi.md#loginPost) | **POST** /login | 

<a name="loginPost"></a>
# **loginPost**
> LoginDetails loginPost(body)



Login

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecurityApi;


SecurityApi apiInstance = new SecurityApi();
PostLoginDetails body = new PostLoginDetails(); // PostLoginDetails | 
try {
    LoginDetails result = apiInstance.loginPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityApi#loginPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostLoginDetails**](PostLoginDetails.md)|  | [optional]

### Return type

[**LoginDetails**](LoginDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

