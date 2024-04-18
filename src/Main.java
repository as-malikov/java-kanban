import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
import service.TaskManager;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = taskManager.create(new Task("Новая задача", Status.NEW, "описание"));
        System.out.println("Create task: " + task);

        Task taskFromManager = taskManager.get(task.getId());
        System.out.println("Get task: " + taskFromManager);

        taskFromManager.setTitle("New title");
        taskManager.update(taskFromManager);
        System.out.println("Update task: " + taskFromManager);

        Task taskUpdate = new Task(taskFromManager.getId(), "Новая задача Обновление", Status.DONE, taskFromManager.getDescription());

        taskManager.delete(taskFromManager.getId());
        System.out.println("Delete: " + task);

        Epic epic = taskManager.createEpic(new Epic("Новый эпик", Status.NEW, "Описание"));
        System.out.println("Create epic: " + epic);

        SubTask subTask = taskManager.createSubTask(new SubTask("Новая подзадача", Status.IN_PROGRESS, "Новое описание подзадачи", epic));
        System.out.println("Create subTask: " + subTask);

    }


}
