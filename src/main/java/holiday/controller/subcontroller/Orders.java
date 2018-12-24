package holiday.controller.subcontroller;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.OrdersApi;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Orders implements Initializable {
    public GridPane Orders_GridPane_Root;
    public VBox Orders_VBox_ListOrders;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAllOrders();
        loadAllOrders();
        System.out.println("Orders initialized");
    }

    private void clearAllOrders() {
        Orders_VBox_ListOrders.getChildren().remove(0, Orders_VBox_ListOrders.getChildren().size());
    }

    private void loadAllOrders() {
        OrdersApi ordersApi = new OrdersApi();
        try {
            ordersApi.ordersGetAsync(new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Orders.loadAllOrders.onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Orders.loadAllOrders.onSuccess");

                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

                }
            });
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
