package game;

import graphics.Sprite;

import java.util.LinkedList;

public final class Animation extends Component {
    private final LinkedList<Double> FRAME_TIMES;
    private final LinkedList<Sprite> SPRITES;
    private final LinkedList<Sprite> SPRITES_REVERSE;
    private double currentFrameTimeLeft;
    private double totalTime;
    private double totalTimeLeft;
    private int currentFrameIndex;
    private final boolean DOES_LOOP;

    public Animation(boolean doesLoop) {
        FRAME_TIMES = new LinkedList<>();
        SPRITES = new LinkedList<>();
        SPRITES_REVERSE = new LinkedList<>();
        currentFrameTimeLeft = 0;
        totalTime = 0;
        totalTimeLeft = 0;
        currentFrameIndex = 0;
        DOES_LOOP = doesLoop;
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }

    //add frame and corresponding time and update all attributes accordingly
    public void addFrame(double frameTime, Sprite sprite) {
        totalTime += frameTime;
        totalTimeLeft = totalTime;
        FRAME_TIMES.add(frameTime);
        SPRITES.add(sprite);
        SPRITES_REVERSE.add(new Sprite(sprite.getIMAGE(), sprite.getSAMPLE_X2(), sprite.getSAMPLE_Y1(), sprite.getSAMPLE_X1(), sprite.getSAMPLE_Y2()));
        currentFrameTimeLeft = FRAME_TIMES.getFirst();
        assert FRAME_TIMES.size() == SPRITES.size() : "You always need to add a frame time and a sprite.";
    }



    //get the current sprite based on the elapsed time
    //TODO: separate currentSprite and update
    public Sprite currentSprite(double deltaTime) {
        assert !SPRITES.isEmpty() || !FRAME_TIMES.isEmpty() : "An animation needs to have at least one frame.";

        //return the first frame if only frame is present to save time
        if (FRAME_TIMES.size() == 1 && SPRITES.size() == 1) {
            return SPRITES.getFirst();
        }

        //update time attributes
        totalTimeLeft -= deltaTime;
        currentFrameTimeLeft -= deltaTime;

        //return the correct frame based on time attributes
        if (totalTimeLeft <= 0) {
            totalTimeLeft = totalTime;
            currentFrameTimeLeft = FRAME_TIMES.getFirst();
            currentFrameIndex = 0;
            if (DOES_LOOP) {
                reset();
                return SPRITES.getFirst();
            }
            else
                reset();
            return SPRITES.getLast();
        }

        //update frame index based on time attributes
        if (currentFrameTimeLeft <= 0) {
            currentFrameIndex++;
            currentFrameTimeLeft = FRAME_TIMES.get(currentFrameIndex);
        }

        return SPRITES.get(currentFrameIndex);
    }

    //reset animation to be played again
    private void reset() {
        totalTimeLeft = totalTime;
        currentFrameTimeLeft = FRAME_TIMES.getFirst();
        currentFrameIndex = 0;
    }
}