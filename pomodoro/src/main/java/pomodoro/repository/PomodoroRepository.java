package pomodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pomodoro.entity.Pomodoro;

@Repository
public interface PomodoroRepository extends JpaRepository<Pomodoro, Long> {

}
