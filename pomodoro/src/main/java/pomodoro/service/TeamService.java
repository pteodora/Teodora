package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TeamDTO;
import pomodoro.entity.Team;
import pomodoro.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public List<TeamDTO> getAll() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamsDTO = new ArrayList<TeamDTO>();
        for (Team team : teams) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setTeamID(team.getTeamID());
            teamDTO.setTeamName(team.getTeamName());
            teamsDTO.add(teamDTO);
        }
        return teamsDTO;
    }

    @Transactional(readOnly = true)
    public TeamDTO getById(int teamId) {
        Team team = teamRepository.findOne(teamId);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamID(team.getTeamID());
        teamDTO.setTeamName(team.getTeamName());
        return teamDTO;
    }

    @Transactional
    public Team saveOrUpdate(TeamDTO teamDTO) {
        Team team = teamRepository.findOne(teamDTO.getTeamID());
        if (team == null) {
            team = new Team();
        }
        team.setTeamID(teamDTO.getTeamID());
        team.setTeamName(teamDTO.getTeamName());
        return teamRepository.save(team);
    }

    public void delete(int teamID) {
        teamRepository.delete(teamID);
    }
}
