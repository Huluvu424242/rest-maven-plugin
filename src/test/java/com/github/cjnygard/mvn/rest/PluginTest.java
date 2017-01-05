package com.github.cjnygard.mvn.rest;

import com.github.cjnygard.mvn.rest.Plugin;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;

import org.junit.Rule;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;

public class PluginTest {
    @Rule
    public MojoTestRule rule = new MojoTestRule();

    /**
     * @throws Exception if any
     */
    @Test
    public void testSomething()
            throws Exception {
        final File pom = new File("src/test/resources/unit/rest-project/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        //rule.executeMojo(new File("src/test/resources/unit/rest-project/"), "rest-request");
        final Mojo myMojo = rule.lookupConfiguredMojo(new File("src/test/resources/unit/rest-project/"),"rest-request");
        assertNotNull( myMojo );

        myMojo.execute();
    }

    /**
     * Do not need the MojoRule.
     */
    @WithoutMojo
    @Test
    public void testSomethingWhichDoesNotNeedTheMojoAndProbablyShouldBeExtractedIntoANewClassOfItsOwn() {
        //TODO
    }

}

