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
import io.swagger.client.model.ListOfOuts;
import io.swagger.client.model.OutDetails;
import io.swagger.client.model.PostOutDetails;
import io.swagger.client.model.PutOutDetails;
import org.junit.Test;
import org.junit.Ignore;
import org.threeten.bp.OffsetDateTime;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OutsApi
 */
@Ignore
public class OutsApiTest {

    private final OutsApi api = new OutsApi();

    /**
     * 
     *
     * Reading list of outs
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void outsGetTest() throws ApiException {
        ListOfOuts response = api.outsGet();

        // TODO: test validations
    }
    /**
     * 
     *
     * Delete out by ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void outsOutIdDeleteTest() throws ApiException {
        Integer outId = null;
        api.outsOutIdDelete(outId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Get out by ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void outsOutIdGetTest() throws ApiException {
        Integer outId = null;
        OutDetails response = api.outsOutIdGet(outId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Modify out
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void outsOutIdPutTest() throws ApiException {
        Integer outId = null;
        PutOutDetails body = null;
        api.outsOutIdPut(outId, body);

        // TODO: test validations
    }
    /**
     * 
     *
     * Add out
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void outsPostTest() throws ApiException {
        String comments = "comments_example";
        OffsetDateTime date = OffsetDateTime.now();
        Float total = 3.4F;
        File photo = new File("photo_example");
        Integer idStatement = 56;
        //comments, date, total, photo, idStatement
        PostOutDetails body = new PostOutDetails();
        body.setTotal(total);
        body.setIdStatement(idStatement);
        body.setComments(comments);
        body.setDate(date);
        body.setPhoto(photo);
        api.outsPost(body);

        // TODO: test validations
    }
}
