import java.util.*;

public class TaskManager {
    private Map<Integer, Task> taskMap;
    private Set<User> users;
    private static int taskIdCounter = 1;  // To generate unique task IDs

    public TaskManager() {
        taskMap = new HashMap<>();
        users = new HashSet<>();
    }

    // Add a new user
    public void addUser(String username, String fullName) {
        User user = new User(username, fullName);
        users.add(user);
        System.out.println("User added: " + user);
    }

    // Create a new task and assign it to a user
    public void createTask(String title, String priority, String status, String username) {
        Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
        if (user.isPresent()) {
            Task task = new Task(title, priority, status, user.get());
            task.setId(taskIdCounter++);
            taskMap.put(task.getId(), task);
            System.out.println("Task created: " + task);
        } else {
            System.out.println("User not found!");
        }
    }

    // Update the status of a task
    public void updateTaskStatus(int taskId, String status) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            task.setStatus(status);
            System.out.println("Task updated: " + task);
        } else {
            System.out.println("Task not found!");
        }
    }

    // List tasks assigned to a user
    public void listTasksByUser(String username) {
        taskMap.values().stream()
                .filter(task -> task.getAssignedUser().getUsername().equals(username))
                .forEach(System.out::println);
    }

    // List all tasks by priority
    public void listTasksByPriority(String priority) {
        taskMap.values().stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .forEach(System.out::println);
    }

    // List all tasks with a specific status
    public void listTasksByStatus(String status) {
        taskMap.values().stream()
                .filter(task -> task.getStatus().equalsIgnoreCase(status))
                .forEach(System.out::println);
    }

    // Method to display the main menu
    public void showMenu() {
        System.out.println("\nTask Manager Menu:");
        System.out.println("1. Add User");
        System.out.println("2. Create Task");
        System.out.println("3. Update Task Status");
        System.out.println("4. List Tasks by User");
        System.out.println("5. List Tasks by Priority");
        System.out.println("6. List Tasks by Status");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            taskManager.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add User
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    taskManager.addUser(username, fullName);
                    break;

                case 2: // Create Task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task priority (Low, Medium, High): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter task status (Not Started, In Progress, Completed): ");
                    String status = scanner.nextLine();
                    System.out.print("Enter username to assign task: ");
                    String assignUser = scanner.nextLine();
                    taskManager.createTask(title, priority, status, assignUser);
                    break;

                case 3: // Update Task Status
                    System.out.print("Enter task ID to update: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new status (Not Started, In Progress, Completed): ");
                    String newStatus = scanner.nextLine();
                    taskManager.updateTaskStatus(taskId, newStatus);
                    break;

                case 4: // List Tasks by User
                    System.out.print("Enter username to list tasks: ");
                    String userToList = scanner.nextLine();
                    taskManager.listTasksByUser(userToList);
                    break;

                case 5: // List Tasks by Priority
                    System.out.print("Enter priority to filter tasks (Low, Medium, High): ");
                    String taskPriority = scanner.nextLine();
                    taskManager.listTasksByPriority(taskPriority);
                    break;

                case 6: // List Tasks by Status
                    System.out.print("Enter status to filter tasks (Not Started, In Progress, Completed): ");
                    String taskStatus = scanner.nextLine();
                    taskManager.listTasksByStatus(taskStatus);
                    break;

                case 7: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

class Task {
    private int id;
    private String title;
    private String priority;
    private String status;
    private User assignedUser;

    public Task(String title, String priority, String status, User assignedUser) {
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.assignedUser = assignedUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + "', priority='" + priority + "', status='" + status + "', assignedUser=" + assignedUser + '}';
    }
}

class User {
    private String username;
    private String fullName;

    public User(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', fullName='" + fullName + "'}";
    }
}
