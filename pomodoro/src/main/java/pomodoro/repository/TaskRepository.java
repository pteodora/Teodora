package pomodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pomodoro.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}