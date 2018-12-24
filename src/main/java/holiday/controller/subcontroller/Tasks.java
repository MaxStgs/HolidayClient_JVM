package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.SubtasksApi;
import io.swagger.client.api.TasksApi;
import io.swagger.client.api.WorkersApi;
import io.swagger.client.model.*;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Tasks implements Initializable {

    public VBox Tasks_VBox_List;
    public ChoiceBox Tasks_ChoiceBox_TaskChoice;
    public ProgressBar Tasks_ProgressBar_TaskProgress;
    public ChoiceBox WorkerChoice;
    public Label Name;
    public Label Description;

    private int taskId;

    private ListOfSubtasks list;
    private WorkerDetails currentWorker;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearForm();
        clearAllSubtasks();
        loadAllTasks();
        loadAllWorkers();

        Tasks_ChoiceBox_TaskChoice
                .getSelectionModel()
                .selectedIndexProperty()
                .addListener(this::taskChoiceUpdate);

        WorkerChoice
                .getSelectionModel()
                .selectedIndexProperty()
                .addListener(this::workerChoiceUpdate);

        System.out.println("Tasks initialized");

        Tasks_ProgressBar_TaskProgress.setProgress(0.0);
//        ((Label) Tasks_ChoiceBox_TaskChoice.getChildrenUnmodifiable().get(0)).setFont(new Font(18.0));

        Platform.runLater(() -> ((Label)Tasks_ChoiceBox_TaskChoice.getChildrenUnmodifiable().get(0)).setFont(new Font(15.0)));
    }

    private void clearForm() {
        Name.setText("");
        Description.setText("");
    }

    private void loadAllWorkers() {
        WorkersApi workersApi = new WorkersApi();
        try {
            workersApi.workersGetAsync(new ApiCallback<ListOfWorkers>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Tasks.loadAllWorkers was Failure. Code: " + String.valueOf(statusCode));
                    Singleton.singleton.callErrorDialog("Ошибка",
                            "Ошибка загрузки списка",
                            "Произошла ошибка во время загрузки списка работников");
                }

                @Override
                public void onSuccess(ListOfWorkers result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Tasks.loadAllTasks was Success");
                    fillWorkerChoice(result.getList());
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

    private void fillWorkerChoice(List<WorkerDetails> list) {
        for (WorkerDetails workerDetails: list) {
            WorkerChoice.getItems().add(String.valueOf(workerDetails.getName()));
        }
    }

    private void workerChoiceUpdate(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        /*boolean result = Singleton.singleton.loadConfirmDialog("Подтверждение изменений",
                "Данное действие не отменить",
                "Вы действительно хотите изменить ответственного с " + currentWorker.getName() + " на " + newWorker.getName() + "?");
        if(result) {
            currentWorker = newWorker;
            WorkerChoice.setValue(currentWorker.getName());
        }*/
    }

    private void loadAllTasks() {
        TasksApi tasksApi = new TasksApi();
        try {
            tasksApi.tasksGetAsync(new ApiCallback<ListOfTasks>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Tasks.loadAllTasks was Failure. Code: " + String.valueOf(statusCode));
                    Singleton.singleton.callErrorDialog("Ошибка",
                            "Произошла ошибка во время загрузки списка работников",
                            "Код ошибки: " + statusCode + "\n" +
                            "Сообщение: " + e.getMessage());
                    return;
                }

                @Override
                public void onSuccess(ListOfTasks result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Tasks.loadAllTasks was Success");
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

    private void clearAllSubtasks() {
        Tasks_VBox_List.getChildren().remove(0, Tasks_VBox_List.getChildren().size());
    }

    private void taskChoiceUpdate(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        String[] values = Tasks_ChoiceBox_TaskChoice.getItems().get(newValue.intValue()).toString().split(":");
        int taskId = Integer.valueOf(values[0]);

        TaskDetails details;
        TasksApi tasksApi = new TasksApi();
        try {
            this.taskId = taskId;
            details = tasksApi.tasksTaskIdGet(taskId);
        } catch (ApiException e) {
            System.out.println("Tasks.taskChoiceUpdate.tasksApi.tasksTaskIdGet call Error");
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

    private void fillTaskChoice(ListOfTasks list) {
        for(TaskDetails taskDetails : list.getList()) {
            Tasks_ChoiceBox_TaskChoice.getItems().add(String.valueOf(taskDetails.getId()) + ":" + taskDetails.getDescription());
        }
    }

    private void fillTaskData(TaskDetails details) {
        // Todo: change getDescription to getName
        Name.setText(details.getDescription());
        Description.setText(details.getDescription());
        // TODO: Make list of Workers
        //Task_ChoiceBox_TaskChoice.setItems();
        // TODO: Make Date
        //Task_DatePicker_TaskDate.setConverter(new LocalDateStringConverter(details.getDate()));

        WorkersApi workersApi = new WorkersApi();
        try {
            currentWorker = workersApi.workersWorkerIdGet(details.getIdWorker());
            WorkerChoice.setValue(currentWorker.getName());
        } catch (ApiException e) {
            e.printStackTrace();
            Singleton.singleton.callErrorDialog("Ошибка",
                    "Ошибка загрузки списка",
                    "Произошла ошибка во время загрузки списка работников");
            return;
        }
    }

    private void fillSubtaskData(ListOfSubtasks list) {
        this.list = list;
        clearAllSubtasks();
        for(SubtaskDetails subtaskDetails : list.getList()) {
            addSubtaskToScreen(subtaskDetails);
        }
        mathProgressBar();
    }

    private void mathProgressBar() {
        int plus = 0;
        for(SubtaskDetails subtaskDetails : list.getList()) {
            plus += subtaskDetails.isStatus() ? 1 : 0;
        }
        Tasks_ProgressBar_TaskProgress.setProgress((double)plus / list.getList().size());
    }

    private void addSubtaskToScreen(SubtaskDetails subtaskDetails) {
        HBox hBox = new HBox();

        Label labelName = new Label();
        labelName.setText(subtaskDetails.getDescription());
        labelName.setStyle(".label-middle");

        /*TextField textDesc = new TextField();
        textDesc.setText(subtaskDetails.getDescription());*/
        Label labelDesk = new Label();
        labelDesk.setText(subtaskDetails.getDescription());
        labelDesk.setStyle(".label-middle");

        //textDesc.onActionProperty().setValue(event -> UpdateSubtask());

        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(subtaskDetails.isStatus());
        checkBox.setId(String.valueOf(subtaskDetails.getId()));

        checkBox.setOnAction(event -> Tasks_UpdateSubtask(subtaskDetails));

        Button editButton = new Button();
        editButton.setText("Редактировать");
        editButton.setOnAction(event -> Tasks_EditSubtask_OnAction(event, subtaskDetails));

        Button deleteButton = new Button();
        deleteButton.setText("Удалить");
        deleteButton.setOnAction(event -> Tasks_DeleteSubtask_OnAction(event ,subtaskDetails));

        hBox.getChildren().addAll(checkBox, labelName, labelDesk, editButton, deleteButton);

        Tasks_VBox_List.getChildren().add(hBox);
    }

    public void Tasks_Button_AddTask_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Task", "Tasks", Singleton.EActionStates.Add, null);
    }

    public void Tasks_Button_AddSubtask_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Subtask", "Tasks", Singleton.EActionStates.Add, null);
    }

    private void Tasks_EditSubtask_OnAction(ActionEvent event, SubtaskDetails subtaskDetails) {
        Singleton.singleton.loadWindowByName("Subtask", "Tasks", Singleton.EActionStates.Edit, subtaskDetails);
        mathProgressBar();
        for(Node node : ((HBox)((Button)event.getSource()).getParent()).getChildren()) {
            if ((CheckBox)node != null) {
                ((CheckBox)node).setSelected(subtaskDetails.isStatus());
                break;
            }
        }
    }

    private void Tasks_DeleteSubtask_OnAction(ActionEvent event, SubtaskDetails subtaskDetails) {
        boolean result = Singleton.singleton.loadConfirmDialog("Подтверждение перехода",
                "Вы не сможете отменить это действие",
                "Вы действительно хотите удалить подзадачу " + subtaskDetails.getDescription());
        if(result) {
            list.getList().remove(subtaskDetails);
            mathProgressBar();
            Platform.runLater(() -> Tasks_VBox_List.getChildren().remove(((Button)(event.getSource())).getParent()));
        }
    }

    private void Tasks_UpdateSubtask(SubtaskDetails subtaskDetails) {
        subtaskDetails.setStatus(!subtaskDetails.isStatus());
        mathProgressBar();
    }
}
