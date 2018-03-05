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
    public List<TeamDTO> getAll(){
        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamsDTO = new ArrayList<TeamDTO>();
        for(Team team : teams){
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setTeamID(team.getTeamID());
            teamDTO.setTeamName(team.getTeamName());
            teamsDTO.add(teamDTO);
        }
        return teamsDTO;
    }
}