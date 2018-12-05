package holiday.controller.subcontroller;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.SubtasksApi;
import io.swagger.client.api.TasksApi;
import io.swagger.client.model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Task implements Initializable {

    public VBox Task_VBox_List;
    public AnchorPane Task_Pane;
    public ChoiceBox Task_ChoiceBox_TaskChoice;
    public ProgressBar Task_ProgressBar_TaskProgress;
    public ComboBox Task_ComboBox_TaskWorker;
    public TextArea Task_TextArea_TaskDescription;
    public DatePicker Task_DatePicker_TaskDate;
    public TextField Task_TextField_TaskName;

    private int taskId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Task_ChoiceBox_TaskChoice
                .getSelectionModel()
                .selectedIndexProperty()
                .addListener(this::taskChoiceUpdate);

        initListOfTasks();

        clearSubtasks();

        addSubtask("Купить деталей", "Купить деталей для машины в специальном магазине для животных", true, -1);
        addSubtask("Принести детали", "Task_02", false, -2);
        addSubtask("Установить", "Task_03", true, -3);

        for(int i = 0; i < 15; i++)
            addSubtask(String.valueOf(i), "Task_" + i, true, i);
    }

    private void addSubtask(String taskName, String taskDescription, Boolean taskStatus, int Id) {
        HBox hBox = new HBox();

        Label labelName = new Label();
        labelName.setText(taskName);

        TextField textDesc = new TextField();
        textDesc.setText(taskDescription);

        textDesc.onActionProperty().setValue(event -> UpdateSubtask());

        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(taskStatus);
        checkBox.setId(String.valueOf(Id));

        checkBox.onActionProperty().setValue(event -> {
            System.out.println(((CheckBox) event.getSource()).getId());
            UpdateSubtask();
        });

        Button button = new Button();
        button.setText("Удалить");
        button.onActionProperty().setValue(event -> {
            Task_VBox_List.getChildren().remove(((Button) event.getTarget()).getParent());
            UpdateSubtask();
        });

        hBox.getChildren().add(labelName);
        hBox.getChildren().add(textDesc);
        hBox.getChildren().add(checkBox);
        hBox.getChildren().add(button);

        Task_VBox_List.getChildren().add(hBox);
    }

    private void UpdateSubtask() {
        SubtasksApi api = new SubtasksApi();
        // Todo: After swagger1update implement UpdateSubtask
    }

    private void initListOfTasks() {
        TasksApi tasksApi = new TasksApi();
        try {
            tasksApi.tasksGetAsync(new ApiCallback<ListOfTasks>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Task.initListOfTasks was Failure. Code: " + String.valueOf(statusCode));
                }

                @Override
                public void onSuccess(ListOfTasks result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Task.initListOfTasks was Success");
                    fillTaskChoice(result);
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

    private void fillTaskChoice(ListOfTasks list) {
        for (int i = 0; i < list.getList().size(); i++) {
            // TODO: Need show Name, not Description. After Swagger fixing
            // TODO: ChoiceBox use bad solution like 'ID:Name'
            TaskDetails item = list.getList().get(i);
            Task_ChoiceBox_TaskChoice.getItems().add(String.valueOf(item.getId()) + ":" + item.getDescription());
        }
    }

    private void clearSubtasks() {
        Task_VBox_List.getChildren().remove(0, Task_VBox_List.getChildren().size());
    }

    private void taskChoiceUpdate(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        String[] values = Task_ChoiceBox_TaskChoice.getItems().get(newValue.intValue()).toString().split(":");
        int taskId = Integer.valueOf(values[0]);

        TaskDetails details;
        TasksApi tasksApi = new TasksApi();
        try {
            this.taskId = taskId;
            details = tasksApi.tasksTaskIdGet(taskId);
        } catch (ApiException e) {
            System.out.println("Task.taskChoiceUpdate.tasksApi.tasksTaskIdGet call Error");
            this.taskId = -1;
            return;
        }
        fillTaskData(details);



        ListOfSubtasks list;
        SubtasksApi subtasksApi = new SubtasksApi();
        try {
            list = subtasksApi.tasksTaskIdSubtasksGet(taskId);
        } catch (ApiException e) {
            e.printStackTrace();
            return;
        }
        fillSubtaskData(list);
    }

    private void fillTaskData(TaskDetails details) {
        // TODO: After swagger1update. Set text to details.getName();
        Task_TextField_TaskName.setText("It is name");
        Task_TextArea_TaskDescription.setText(details.getDescription());
        // TODO: Make list of Workers
        //Task_ChoiceBox_TaskChoice.setItems();
        // TODO: Make Date
        //Task_DatePicker_TaskDate.setConverter(new LocalDateStringConverter(details.getDate()));

    }

    private void fillSubtaskData(ListOfSubtasks list) {
        clearSubtasks();

        for(int i = 0; i < list.getList().size(); i++) {
            SubtaskDetails details = list.getList().get(i);
            // TODO: After swagger1update. Change 'Here must be name' to details.getName()
            addSubtask("Here must be name", details.getDescription(), details.isStatus(), details.getId());
        }
    }

    public void Task_AddSubtask(ActionEvent actionEvent) {
        SubtasksApi api = new SubtasksApi();
        // Todo: Add Subtask haven't API for this

    }

    public void Task_DeleteTask(ActionEvent actionEvent) {
        TasksApi api = new TasksApi();
        // Todo: Delete task haven't API for this
    }

    public void Task_UpdateTask(ActionEvent actionEvent) {
        TasksApi api = new TasksApi();

        PutTaskDetails details = new PutTaskDetails();
        //details.setIdWorker(Integer.parseInt(Task_ComboBox_TaskWorker.getValue().toString()));

        try {
            api.tasksTaskIdPutAsync(taskId, details, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {

                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {

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
