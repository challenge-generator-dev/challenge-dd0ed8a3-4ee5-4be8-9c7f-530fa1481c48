package core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LoadTestParameters {
    private final String testId;
    private final String targetUrl;
    private final int threadCount;
    private final int rampUpPeriodSeconds;
    private final int durationSeconds;
    private final List<String> headers;
    private final String requestBody;
    private final int expectedResponseCode;

    public static class LoadTestParametersBuilder {
        public LoadTestParameters build() {
            if (testId == null || testId.isBlank()) {
                throw new IllegalArgumentException("Test ID must not be null or empty");
            }
            if (targetUrl == null || targetUrl.isBlank()) {
                throw new IllegalArgumentException("Target URL must not be null or empty");
            }
            if (threadCount <= 0) {
                throw new IllegalArgumentException("Thread count must be positive");
            }
            if (rampUpPeriodSeconds <= 0) {
                throw new IllegalArgumentException("Ramp-up period must be positive");
            }
            if (durationSeconds <= 0) {
                throw new IllegalArgumentException("Duration must be positive");
            }
            return new LoadTestParameters(testId, targetUrl, threadCount, rampUpPeriodSeconds,
                    durationSeconds, headers, requestBody, expectedResponseCode);
        }
    }
}