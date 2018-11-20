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

import io.swagger.client.ApiException;
import io.swagger.client.model.ListOfSubtasks;
import io.swagger.client.model.SubtaskDetails;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SubtasksApi
 */
@Ignore
public class SubtasksApiTest {

    private final SubtasksApi api = new SubtasksApi();

    /**
     * 
     *
     * Read subtask by task ID and subtask ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tasksTaskIdSubtaskIdGetTest() throws ApiException {
        Integer taskId = null;
        Integer subtaskId = null;
        SubtaskDetails response = api.tasksTaskIdSubtaskIdGet(taskId, subtaskId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Read subtasks by task ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tasksTaskIdSubtasksGetTest() throws ApiException {
        Integer taskId = null;
        ListOfSubtasks response = api.tasksTaskIdSubtasksGet(taskId);

        // TODO: test validations
    }
}