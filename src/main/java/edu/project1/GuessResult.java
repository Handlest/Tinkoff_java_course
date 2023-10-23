package edu.project1;

sealed interface GuessResult {
    char[] state();
    int attempt();
    int maxAttempts();
    @NotNull String message();

    record Defeat(...) implements GuessResult {}
    record Win(...) implements GuessResult {}
    record SuccessfulGuess(...) implements GuessResult {}
    record FailedGuess(...) implements GuessResult {}
}
