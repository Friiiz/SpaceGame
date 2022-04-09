package graphics;

import java.awt.image.BufferedImage;

public class Sprite {
    private final int SAMPLE_X1;
    private final int SAMPLE_Y1;
    private final int SAMPLE_X2;
    private final int SAMPLE_Y2;
    private transient final BufferedImage IMAGE;

    public Sprite(BufferedImage image, int sampleX1, int sampleY1, int sampleX2, int sampleY2) {
        IMAGE = image;
        SAMPLE_X1 = sampleX1;
        SAMPLE_Y1 = sampleY1;
        SAMPLE_X2 = sampleX2;
        SAMPLE_Y2 = sampleY2;
    }

    public Sprite(BufferedImage image) {
        IMAGE = image;
        SAMPLE_X1 = 0;
        SAMPLE_Y1 = 0;
        assert IMAGE != null;
        SAMPLE_X2 = IMAGE.getWidth();
        SAMPLE_Y2 = IMAGE.getHeight();
    }

    public int getSAMPLE_X1() {
        return SAMPLE_X1;
    }

    public int getSAMPLE_Y1() {
        return SAMPLE_Y1;
    }

    public int getSAMPLE_X2() {
        return SAMPLE_X2;
    }

    public int getSAMPLE_Y2() {
        return SAMPLE_Y2;
    }

    public BufferedImage getIMAGE() {
        return IMAGE;
    }
}
