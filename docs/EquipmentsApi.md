# EquipmentsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**equipmentEquipmentIdGet**](EquipmentsApi.md#equipmentEquipmentIdGet) | **GET** /equipment/{equipmentId} | 
[**equipmentEquipmentIdPut**](EquipmentsApi.md#equipmentEquipmentIdPut) | **PUT** /equipment/{equipmentId} | 
[**equipmentGet**](EquipmentsApi.md#equipmentGet) | **GET** /equipment | 
[**equipmentOrderIdGet**](EquipmentsApi.md#equipmentOrderIdGet) | **GET** /equipment/{orderId} | 
[**equipmentPost**](EquipmentsApi.md#equipmentPost) | **POST** /equipment | 

<a name="equipmentEquipmentIdGet"></a>
# **equipmentEquipmentIdGet**
> EquipmentDetails equipmentEquipmentIdGet(equipmentId)



Read equipment by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EquipmentsApi;


EquipmentsApi apiInstance = new EquipmentsApi();
Integer equipmentId = 56; // Integer | Equipment ID
try {
    EquipmentDetails result = apiInstance.equipmentEquipmentIdGet(equipmentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EquipmentsApi#equipmentEquipmentIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **equipmentId** | **Integer**| Equipment ID |

### Return type

[**EquipmentDetails**](EquipmentDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="equipmentEquipmentIdPut"></a>
# **equipmentEquipmentIdPut**
> equipmentEquipmentIdPut(equipmentId, body)



Modify equipment by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EquipmentsApi;


EquipmentsApi apiInstance = new EquipmentsApi();
Integer equipmentId = 56; // Integer | Equipment ID
PutEquipmentDetails body = new PutEquipmentDetails(); // PutEquipmentDetails | 
try {
    apiInstance.equipmentEquipmentIdPut(equipmentId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling EquipmentsApi#equipmentEquipmentIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **equipmentId** | **Integer**| Equipment ID |
 **body** | [**PutEquipmentDetails**](PutEquipmentDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="equipmentGet"></a>
# **equipmentGet**
> ListOfEquipments equipmentGet()



Read equipments

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EquipmentsApi;


EquipmentsApi apiInstance = new EquipmentsApi();
try {
    ListOfEquipments result = apiInstance.equipmentGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EquipmentsApi#equipmentGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfEquipments**](ListOfEquipments.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="equipmentOrderIdGet"></a>
# **equipmentOrderIdGet**
> EquipmentDetails equipmentOrderIdGet(orderId)



Read equipments by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EquipmentsApi;


EquipmentsApi apiInstance = new EquipmentsApi();
Integer orderId = 56; // Integer | orderId
try {
    EquipmentDetails result = apiInstance.equipmentOrderIdGet(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EquipmentsApi#equipmentOrderIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Integer**| orderId |

### Return type

[**EquipmentDetails**](EquipmentDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="equipmentPost"></a>
# **equipmentPost**
> equipmentPost(body)



Add equipment

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EquipmentsApi;


EquipmentsApi apiInstance = new EquipmentsApi();
PostEquipmentDetails body = new PostEquipmentDetails(); // PostEquipmentDetails | 
try {
    apiInstance.equipmentPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling EquipmentsApi#equipmentPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostEquipmentDetails**](PostEquipmentDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

