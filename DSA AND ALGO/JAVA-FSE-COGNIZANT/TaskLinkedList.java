class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskLinkedList {
    private Task head = null;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
            return;
        }
        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newTask;
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.taskId == taskId) {
            head = head.next;
            return true;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public void traverseTasks() {
        Task current = head;
        if (current == null) {
            System.out.println("No tasks found.");
            return;
        }
        while (current != null) {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.addTask(101, "Design Database", "In Progress");
        list.addTask(102, "Develop API", "Pending");
        list.addTask(103, "Write Unit Tests", "Pending");

        System.out.println("Initial Task List:");
        list.traverseTasks();
        System.out.println();

        System.out.println("Searching for task 102...");
        Task found = list.searchTask(102);
        if (found != null) {
            System.out.println("Found: " + found.taskName + " [" + found.status + "]");
        } else {
            System.out.println("Task not found.");
        }
        System.out.println();

        System.out.println("Deleting task 102...");
        list.deleteTask(102);
        System.out.println();

        System.out.println("Updated Task List:");
        list.traverseTasks();
    }
}