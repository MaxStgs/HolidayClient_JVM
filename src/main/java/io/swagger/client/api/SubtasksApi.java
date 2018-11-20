/*
 * HolidayAPI
 * My API work College Work
 *
 * OpenAPI spec version: 0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.ListOfSubtasks;
import io.swagger.client.model.SubtaskDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtasksApi {
    private ApiClient apiClient;

    public SubtasksApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SubtasksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for tasksTaskIdSubtaskIdGet
     * @param taskId The Task Id (required)
     * @param subtaskId The Subtask Id (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call tasksTaskIdSubtaskIdGetCall(Integer taskId, Integer subtaskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/tasks/{taskId}/{subtaskId}"
            .replaceAll("\\{" + "taskId" + "\\}", apiClient.escapeString(taskId.toString()))
            .replaceAll("\\{" + "subtaskId" + "\\}", apiClient.escapeString(subtaskId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tasksTaskIdSubtaskIdGetValidateBeforeCall(Integer taskId, Integer subtaskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling tasksTaskIdSubtaskIdGet(Async)");
        }
        // verify the required parameter 'subtaskId' is set
        if (subtaskId == null) {
            throw new ApiException("Missing the required parameter 'subtaskId' when calling tasksTaskIdSubtaskIdGet(Async)");
        }
        
        com.squareup.okhttp.Call call = tasksTaskIdSubtaskIdGetCall(taskId, subtaskId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * Read subtask by task ID and subtask ID
     * @param taskId The Task Id (required)
     * @param subtaskId The Subtask Id (required)
     * @return SubtaskDetails
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubtaskDetails tasksTaskIdSubtaskIdGet(Integer taskId, Integer subtaskId) throws ApiException {
        ApiResponse<SubtaskDetails> resp = tasksTaskIdSubtaskIdGetWithHttpInfo(taskId, subtaskId);
        return resp.getData();
    }

    /**
     * 
     * Read subtask by task ID and subtask ID
     * @param taskId The Task Id (required)
     * @param subtaskId The Subtask Id (required)
     * @return ApiResponse&lt;SubtaskDetails&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubtaskDetails> tasksTaskIdSubtaskIdGetWithHttpInfo(Integer taskId, Integer subtaskId) throws ApiException {
        com.squareup.okhttp.Call call = tasksTaskIdSubtaskIdGetValidateBeforeCall(taskId, subtaskId, null, null);
        Type localVarReturnType = new TypeToken<SubtaskDetails>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Read subtask by task ID and subtask ID
     * @param taskId The Task Id (required)
     * @param subtaskId The Subtask Id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tasksTaskIdSubtaskIdGetAsync(Integer taskId, Integer subtaskId, final ApiCallback<SubtaskDetails> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tasksTaskIdSubtaskIdGetValidateBeforeCall(taskId, subtaskId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubtaskDetails>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for tasksTaskIdSubtasksGet
     * @param taskId taskId (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call tasksTaskIdSubtasksGetCall(Integer taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/tasks/{taskId}/subtasks"
            .replaceAll("\\{" + "taskId" + "\\}", apiClient.escapeString(taskId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tasksTaskIdSubtasksGetValidateBeforeCall(Integer taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling tasksTaskIdSubtasksGet(Async)");
        }
        
        com.squareup.okhttp.Call call = tasksTaskIdSubtasksGetCall(taskId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * Read subtasks by task ID
     * @param taskId taskId (required)
     * @return ListOfSubtasks
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ListOfSubtasks tasksTaskIdSubtasksGet(Integer taskId) throws ApiException {
        ApiResponse<ListOfSubtasks> resp = tasksTaskIdSubtasksGetWithHttpInfo(taskId);
        return resp.getData();
    }

    /**
     * 
     * Read subtasks by task ID
     * @param taskId taskId (required)
     * @return ApiResponse&lt;ListOfSubtasks&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ListOfSubtasks> tasksTaskIdSubtasksGetWithHttpInfo(Integer taskId) throws ApiException {
        com.squareup.okhttp.Call call = tasksTaskIdSubtasksGetValidateBeforeCall(taskId, null, null);
        Type localVarReturnType = new TypeToken<ListOfSubtasks>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Read subtasks by task ID
     * @param taskId taskId (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tasksTaskIdSubtasksGetAsync(Integer taskId, final ApiCallback<ListOfSubtasks> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tasksTaskIdSubtasksGetValidateBeforeCall(taskId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ListOfSubtasks>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}