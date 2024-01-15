package com.example.springbatch20240111;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@SpringBatchTest
@ActiveProfiles("test")
public class BatchTest {
    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils;
    @Autowired
    private JobLauncherTestUtils hello2JobLauncherTestUtils;
    @Autowired
    private JobLauncherTestUtils hello3JobLauncherTestUtils;

    @DisplayName("helloJob")
    @Test
    public void t1() throws Exception {
        helloJobLauncherTestUtils.launchJob();
    }

    @DisplayName("hello2Job")
    @Test
    public void t2() throws Exception {
        hello2JobLauncherTestUtils.launchJob();
    }
    @DisplayName("hello3Job")
    @Test
    public void t3() throws Exception {
        hello3JobLauncherTestUtils.launchJob();
    }
}