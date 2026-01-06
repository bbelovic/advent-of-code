package net.bbelovic.adventofcode.year2025;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class RunNodeInDockerInJavaTest {
    @Container
    GenericContainer container = new GenericContainer(
            new ImageFromDockerfile()
                    .withFileFromClasspath("Dockerfile", ""));

    @Test
    void testBuildFromDockerFile() {
        Assertions.assertThat(container.isRunning()).isTrue();

    }

}
