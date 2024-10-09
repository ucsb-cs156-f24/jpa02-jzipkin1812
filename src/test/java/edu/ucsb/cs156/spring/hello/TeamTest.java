package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_true() {
        Team teamA = new Team( "equal-team");
        assertTrue(teamA.equals(teamA));
    }

    @Test
    public void same_attributes_returns_true() {
        // T T
        Team teamA = new Team( "equal-team");
        Team teamB = new Team( "equal-team");
        assertTrue(teamA.equals(teamB));
    }

    @Test
    public void equals_different_class_returns_false() {
        assertTrue(!(team.equals(5)));
    }

    @Test
    public void equals_different_attributes_returns_false() {
        Team teamA = new Team( "almostequal-team");
        Team teamB = new Team( "almostequal-team");
        teamB.addMember("javin");
        teamA.addMember("maya");
        // T F
        assertTrue(!(teamA.equals(teamB)));
        // F F
        teamA.setName("random-team");
        assertTrue(!(teamA.equals(teamB)));
        // F T
        teamA = new Team("random-team");
        teamB = new Team("superrandom-team");
        assertTrue(!(teamA.equals(teamB)));
    }

}
