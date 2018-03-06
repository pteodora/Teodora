package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TeamDto;
import pomodoro.entity.Team;
import pomodoro.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public List<TeamDto> getAll() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> teamsDto = new ArrayList<TeamDto>();
        teams.stream().forEach(team -> {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamId(team.getTeamId());
            teamDto.setName(team.getName());
            teamsDto.add(teamDto);
        });
        return teamsDto;
    }

    @Transactional(readOnly = true)
    public TeamDto getById(Long teamId) {
        Team team = teamRepository.findOne(teamId);
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamId(team.getTeamId());
        teamDto.setName(team.getName());
        return teamDto;
    }

    @Transactional
    public Team saveOrUpdate(TeamDto teamDto) {
        Team team = teamRepository.findOne(teamDto.getTeamId());
        if (team == null) {
            team = new Team();
        }
        team.setTeamId(teamDto.getTeamId());
        team.setName(teamDto.getName());
        return teamRepository.save(team);
    }

    public void delete(Long teamId) {
        teamRepository.delete(teamId);
    }
}
