class TodoList {

    Map<Integer, List<Integer>> data;
    AtomicInteger counter;
    Map<Integer, Task> taskMap;

    public TodoList() {
        data = new ConcurrentHashMap<>(100);
        taskMap = new ConcurrentHashMap<>(100);
        counter = new AtomicInteger(1);
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        int id = counter.getAndIncrement();
        Task task = new Task(id, taskDescription, dueDate, tags);
        taskMap.put(id, task);
        data.computeIfAbsent(userId, user -> new ArrayList<>(100));
        List<Integer> taskList = data.get(userId);
        taskList.add(id);
        return id;
    }

    private Stream<Task> getTask(int userId) {
        return data.getOrDefault(userId, new ArrayList<Integer>()).stream().map(id -> taskMap.get(id))
                .sorted((t1, t2) -> t1.dueDate - t2.dueDate).filter(task -> task.status == 0);
    }

    public List<String> getAllTasks(int userId) {
        return getTask(userId).map(task -> task.desc).collect(Collectors.toList());
    }

    public List<String> getTasksForTag(int userId, String tag) {
        return getTask(userId).filter(task -> task.tags.contains(tag)).map(task -> task.desc)
                .collect(Collectors.toList());
    }

    public void completeTask(int userId, int taskId) {
        if (data.containsKey(userId) && data.get(userId).contains(taskId) && taskMap.get(taskId).status == 0) {
            Task task = taskMap.get(taskId);
            task.status = 1;
            // data.get(userId).remove(Integer.valueOf(taskId));
        }
    }
}

class Task {

    Integer id;
    String desc;
    List<String> tags;
    Integer dueDate;
    int status;

    public Task(int id, String taskDescription, int due, List<String> tags) {
        this.id = id;
        this.tags = tags;
        this.dueDate = due;
        this.desc = taskDescription;
    }
}