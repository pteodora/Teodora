package pomodoro.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.TeamDetailDto;
import pomodoro.dto.TeamDto;
import pomodoro.dto.UserDto;
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
        List<TeamDto> teamsDto = new ArrayList<TeamDto>();
        teams.stream().forEach(team -> {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeamId(team.getTeamId());
            teamDto.setName(team.getName());
            teamsDto.add(teamDto);
        });
        return teamsDto;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<TeamDto> findUserTeams(Principal principal) {
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        User user = userRepository.findOne(details.get("email"));
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
    @SuppressWarnings("unchecked")
    public void saveOrUpdate(TeamDto teamDto, Principal principal) {
        Team team = null;
        if (teamDto.getTeamId() != null) {
            team = teamRepository.findOne(teamDto.getTeamId());
        }
        if (team == null) {
            team = new Team();
        }
        team.setName(teamDto.getName());
        //teamRepository.save(team);
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        User user = userRepository.findOne(details.get("email"));
        user.getTeams().add(team);
        userRepository.save(user);
    }
    
    @Transactional
    public void inviteUser(UserDto userDto) {
        
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void leaveTeam(Long teamId, Principal principal) {
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        Team team = teamRepository.findOne(teamId);
        User user = userRepository.findOne(details.get("email"));
        team.getUsers().remove(user);
        user.getTeams().remove(team);
    }

    public void delete(Long teamId) {
        teamRepository.delete(teamId);
    }
}
