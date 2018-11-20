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
import io.swagger.client.model.CarDetails;
import io.swagger.client.model.ListOfCars;
import io.swagger.client.model.PostCarDetails;
import io.swagger.client.model.PutCarDetails;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CarsApi
 */
@Ignore
public class CarsApiTest {

    private final CarsApi api = new CarsApi();

    /**
     * 
     *
     * Read car by ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void carsCarIdGetTest() throws ApiException {
        Integer carId = null;
        CarDetails response = api.carsCarIdGet(carId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Modify car by ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void carsCarIdPutTest() throws ApiException {
        Integer carId = null;
        PutCarDetails body = null;
        api.carsCarIdPut(carId, body);

        // TODO: test validations
    }
    /**
     * 
     *
     * Read cars
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void carsGetTest() throws ApiException {
        ListOfCars response = api.carsGet();

        // TODO: test validations
    }
    /**
     * 
     *
     * Add car
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void carsPostTest() throws ApiException {
        PostCarDetails body = null;
        api.carsPost(body);

        // TODO: test validations
    }
}
