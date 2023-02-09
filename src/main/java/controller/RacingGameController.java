package controller;

import domain.Car;
import domain.Cars;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import java.io.IOException;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {
        RacingGame racingGame = gameInitialize();
        play(racingGame);
        findWinners(racingGame);
    }

    private RacingGame gameInitialize() throws IOException {
        List<String> carNames = inputView.readCarNames();
        int count = inputView.readCount();
        return new RacingGame(new RandomNumberGenerator(), Cars.from(carNames), count);
    }

    private void play(final RacingGame racingGame) {
        outputView.printResultMessage();
        while (racingGame.isPlayable()) {
            List<Car> cars = racingGame.play();
            outputView.printPosition(cars);
        }
    }

    private void findWinners(final RacingGame racingGame) {
        List<String> winners = racingGame.findWinners();
        outputView.printWinnersMessage(winners);
    }
}
