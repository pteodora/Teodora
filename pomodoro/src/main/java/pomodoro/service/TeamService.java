package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TeamDetailDto;
import pomodoro.dto.TeamDto;
import pomodoro.entity.Team;
import pomodoro.entity.User;
import pomodoro.repository.TeamRepository;
import pomodoro.repository.UserRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<TeamDto> getAll() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> teamsDto = new ArrayList<>();
        teams.stream().forEach(team -> {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamId(team.getTeamId());
            teamDto.setName(team.getName());
            teamsDto.add(teamDto);
        });
        return teamsDto;
    }

    @Transactional
    public List<TeamDto> findUserTeams(String email) {
        User user = userRepository.findOne(email);
        List<TeamDto> teamsDto = new ArrayList<>();
        for (Team team : user.getTeams()) {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamId(team.getTeamId());
            teamDto.setName(team.getName());
            teamsDto.add(teamDto);
        }
        return teamsDto;
    }

    @Transactional(readOnly = true)
    public TeamDetailDto getById(Long teamId) {
        Team team = teamRepository.findOne(teamId);
        TeamDetailDto teamDetailDto = new TeamDetailDto(team);
        return teamDetailDto;
    }

    @Transactional
    public void saveOrUpdate(TeamDto teamDto, String email) {
        Team team = null;
        if (teamDto.getTeamId() != null) {
            team = teamRepository.findOne(teamDto.getTeamId());
        }
        if (team == null) {
            team = new Team();
        }
        team.setName(teamDto.getName());
        User user = userRepository.findOne(email);
        user.getTeams().add(team);
        userRepository.save(user);
    }

    @Transactional
    public void inviteUser(Long teamId, String email) {
        Team team = teamRepository.findOne(teamId);
        User user = null;
        if (userRepository.findOne(email) != null) {
            user = userRepository.findOne(email);
            user.getTeams().add(team);
            userRepository.save(user);
        }
    }

    @Transactional
    public void leaveTeam(Long teamId, String email) {
        Team team = teamRepository.findOne(teamId);
        User user = userRepository.findOne(email);
        team.getUsers().remove(user);
        user.getTeams().remove(team);
    }

    public void delete(Long teamId) {
        teamRepository.delete(teamId);
    }
}
