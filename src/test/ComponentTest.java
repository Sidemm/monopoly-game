package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ComponentTest{

        @Rule
        public TemporaryFolder folder = new TemporaryFolder();

        @Test
        public void filesShouldBeCreated() throws IOException {
            File createdFile = folder.newFile("game_saved_state.json");
            assertTrue(createdFile.exists());
        }

}
