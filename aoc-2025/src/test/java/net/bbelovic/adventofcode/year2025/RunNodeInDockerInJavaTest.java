package net.bbelovic.adventofcode.year2025;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class RunNodeInDockerInJavaTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunNodeInDockerInJavaTest.class);

    @Container
    GenericContainer container = new GenericContainer(
            new ImageFromDockerfile()
                    .withFileFromClasspath("Dockerfile", "Dockerfile")
                    .withFileFromClasspath("package.json", "ts/package.json")
                    .withFileFromClasspath("tsconfig.json", "ts/tsconfig.json")

    );

    @Test
    void testBuildFromDockerFile() {
        Slf4jLogConsumer slf4jLogConsumer = new Slf4jLogConsumer(LOGGER).withSeparateOutputStreams();
        container.followOutput(slf4jLogConsumer);

        Assertions.assertThat(container.isRunning()).isTrue();

    }

}
