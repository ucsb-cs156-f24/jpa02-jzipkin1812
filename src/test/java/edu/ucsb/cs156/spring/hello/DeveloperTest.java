package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Javin", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("jzipkin1812", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-12", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Javin"),"Team should contain Javin");
        assertTrue(t.getMembers().contains("Sarvesh"),"Team should contain Sarvesh");
        assertTrue(t.getMembers().contains("Abby"),"Team should contain Abby");
        assertTrue(t.getMembers().contains("Maya"),"Team should contain Maya");
        assertTrue(t.getMembers().contains("Yixuan"),"Team should contain Yixuan");
        assertTrue(t.getMembers().contains("Yungong"),"Team should contain Yungong");

    }



    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
