package pomodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pomodoro.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}