package game;

import util.InputHandler;

public final class PlayerController extends Component {

    InputHandler inputHandler;

    public PlayerController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    protected void update(double deltaTime) {
        super.update(deltaTime);
    }
}
