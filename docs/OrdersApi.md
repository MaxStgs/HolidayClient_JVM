# OrdersApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**equipmentOrderIdGet**](OrdersApi.md#equipmentOrderIdGet) | **GET** /equipment/{orderId} | 
[**orderGet**](OrdersApi.md#orderGet) | **GET** /order | 
[**orderOrderIdGet**](OrdersApi.md#orderOrderIdGet) | **GET** /order/{orderId} | 
[**orderPost**](OrdersApi.md#orderPost) | **POST** /order | 
[**ordersGet**](OrdersApi.md#ordersGet) | **GET** /orders | 
[**ordersOrderIdGet**](OrdersApi.md#ordersOrderIdGet) | **GET** /orders/{orderId} | 
[**workersOrderIdGet**](OrdersApi.md#workersOrderIdGet) | **GET** /workers/{orderId} | 

<a name="equipmentOrderIdGet"></a>
# **equipmentOrderIdGet**
> EquipmentDetails equipmentOrderIdGet(orderId)



Read equipments by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
Integer orderId = 56; // Integer | orderId
try {
    EquipmentDetails result = apiInstance.equipmentOrderIdGet(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#equipmentOrderIdGet");
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

<a name="orderGet"></a>
# **orderGet**
> ListOfOrdersFromSite orderGet()



Read list of Orders From Site

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
try {
    ListOfOrdersFromSite result = apiInstance.orderGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#orderGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListOfOrdersFromSite**](ListOfOrdersFromSite.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="orderOrderIdGet"></a>
# **orderOrderIdGet**
> OrderFromSiteDetails orderOrderIdGet(orderId)



Read order from site by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
Integer orderId = 56; // Integer | orderId
try {
    OrderFromSiteDetails result = apiInstance.orderOrderIdGet(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#orderOrderIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Integer**| orderId |

### Return type

[**OrderFromSiteDetails**](OrderFromSiteDetails.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="orderPost"></a>
# **orderPost**
> orderPost(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
PostOrderFromSiteDetails body = new PostOrderFromSiteDetails(); // PostOrderFromSiteDetails | 
try {
    apiInstance.orderPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#orderPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostOrderFromSiteDetails**](PostOrderFromSiteDetails.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="ordersGet"></a>
# **ordersGet**
> ordersGet()



Read orders

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
try {
    apiInstance.ordersGet();
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#ordersGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="ordersOrderIdGet"></a>
# **ordersOrderIdGet**
> ordersOrderIdGet(orderId)



Read order by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
Integer orderId = 56; // Integer | orderId
try {
    apiInstance.ordersOrderIdGet(orderId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#ordersOrderIdGet");
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

<a name="workersOrderIdGet"></a>
# **workersOrderIdGet**
> workersOrderIdGet(orderId)



Read worker by order ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OrdersApi;


OrdersApi apiInstance = new OrdersApi();
Integer orderId = 56; // Integer | orderId
try {
    apiInstance.workersOrderIdGet(orderId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#workersOrderIdGet");
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

