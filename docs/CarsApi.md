# CarsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**carsCarIdGet**](CarsApi.md#carsCarIdGet) | **GET** /cars/{carId} | 
[**carsCarIdPut**](CarsApi.md#carsCarIdPut) | **PUT** /cars/{carId} | 
[**carsGet**](CarsApi.md#carsGet) | **GET** /cars | 
[**carsPost**](CarsApi.md#carsPost) | **POST** /cars | 

<a name="carsCarIdGet"></a>
# **carsCarIdGet**
> CarDetails carsCarIdGet(carId)



Read car by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
Integer carId = 56; // Integer | carId
try {
    CarDetails result = apiInstance.carsCarIdGet(carId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsCarIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **carId** | **Integer**| carId |

### Return type

[**CarDetails**](CarDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="carsCarIdPut"></a>
# **carsCarIdPut**
> carsCarIdPut(carId, body)



Modify car by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
Integer carId = 56; // Integer | carId
PutCarDetails body = new PutCarDetails(); // PutCarDetails | 
try {
    apiInstance.carsCarIdPut(carId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsCarIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **carId** | **Integer**| carId |
 **body** | [**PutCarDetails**](PutCarDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="carsGet"></a>
# **carsGet**
> ListOfCars carsGet()



Read cars

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
try {
    ListOfCars result = apiInstance.carsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfCars**](ListOfCars.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="carsPost"></a>
# **carsPost**
> carsPost(body)



Add car

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
PostCarDetails body = new PostCarDetails(); // PostCarDetails | 
try {
    apiInstance.carsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostCarDetails**](PostCarDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

