# soccer

250625
Set Player, Team, League class. 

250627
What i want to do:
1. Register Player to ArrayList<Player> -> Success!
2. Register Team to ArrayList<Team> 
3. Register League to ArrayList<League>
4. Compare player's overall(power) by position - important!!!!
5. Compare Team's average overall in same league

So i divide player to forward, midfielder, back, goalkeeper

250627
But normal football simulator game like fm, usually give same type of 
stat. So reset to Player (one class). Like fm, all abilities are in Player class.

ALL ABILITIES LIST
1. Player (3)
name, age, country

2. Technical skills (7)
shooting, passing, dribbling, crossing, tackling, heading, ballControl

3. Mental skills (7)
vision, composure(침착성), decisionMaking, workRate, leadership, positioning, offtheball

4. Physical skills (5)
pace 스피드 (속도 + 가속도), stamina(체력), strength, jumping, agility(민첩성)

5. Only GK (2)
saving, buildupPlay


And I make **FootballManager class** to deal with player's, team's, league's interaction
-> factory pattern!

Last, FootballManager can read and register player('s info, ability) by players.txt -> chapter10. File I/O

250628
Fix Main method to use do-while loop, switch-case.
(i want to use GUI, but to do it, many things have to change.. so i drop it)





