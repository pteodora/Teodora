package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TaskDTO;
import pomodoro.entity.Task;
import pomodoro.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskDTO> getAll() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTaskID(task.getTaskID());
            taskDTO.setTaskName(task.getTaskName());
            tasksDTO.add(taskDTO);
        }
        return tasksDTO;
    }

    @Transactional(readOnly = true)
    public TaskDTO getById(int taskID) {
        Task task = taskRepository.findOne(taskID);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskID(task.getTaskID());
        taskDTO.setTaskName(task.getTaskName());
        return taskDTO;
    }

    @Transactional
    public Task saveOrUpdate(TaskDTO taskDTO) {
        Task task = taskRepository.findOne(taskDTO.getTaskID());
        if (task == null) {
            task = new Task();
        }
        task.setTaskID(taskDTO.getTaskID());
        task.setTaskName(taskDTO.getTaskName());
        return taskRepository.save(task);
    }

    public void delete(int taskID) {
        taskRepository.delete(taskID);
    }

}
