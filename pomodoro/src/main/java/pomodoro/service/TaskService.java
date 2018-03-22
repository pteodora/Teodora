package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TaskDto;
import pomodoro.entity.Task;
import pomodoro.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<TaskDto> getAll() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> tasksDto = new ArrayList<>();
        tasks.stream().forEach(task -> {
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getTaskId());
            taskDto.setName(task.getName());
            taskDto.setEmail(task.getUser().getEmail());
            tasksDto.add(taskDto);
        });
        return tasksDto;
    }

    @Transactional(readOnly = true)
    public TaskDto getById(Long taskId) {
        Task task = taskRepository.findOne(taskId);
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setName(task.getName());
        taskDto.setEmail(task.getUser().getEmail());
        return taskDto;
    }

    @Transactional
    public Task saveOrUpdate(TaskDto taskDto) {
        Task task = taskRepository.findOne(taskDto.getTaskId());
        if (task == null) {
            task = new Task();
        }
        task.setTaskId(taskDto.getTaskId());
        task.setName(taskDto.getName());
        return taskRepository.save(task);
    }

    public void delete(Long taskId) {
        taskRepository.delete(taskId);
    }

}
