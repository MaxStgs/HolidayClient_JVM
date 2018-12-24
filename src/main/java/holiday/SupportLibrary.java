package holiday;

import io.swagger.client.model.PutWorkerDetails;
import io.swagger.client.model.WorkerDetails;

public class SupportLibrary {

    public static PutWorkerDetails convertWorkerDetailsToPutWorkerDetails(WorkerDetails workerDetails) {
        PutWorkerDetails putWorkerDetails = new PutWorkerDetails();

        putWorkerDetails.setLogin(workerDetails.getLogin());
        putWorkerDetails.setColor(workerDetails.getColor());
        putWorkerDetails.setName(workerDetails.getName());
        putWorkerDetails.setPassportData(workerDetails.getPassportData());
        putWorkerDetails.setPassword(workerDetails.getPassword());
        putWorkerDetails.setPhone(workerDetails.getPhone());
        putWorkerDetails.setPhoto(workerDetails.getPhoto());
        putWorkerDetails.setRole(workerDetails.getRole());
        putWorkerDetails.setRating(workerDetails.getRating());

        return putWorkerDetails;
    }
}
