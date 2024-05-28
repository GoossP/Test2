package tasks.first.components;


import org.bytedeco.javacv.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;

import javax.swing.*;

import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvSaveImage;

public class Main {
    public static void main(String[] args) throws FrameGrabber.Exception {
        FrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();
        Frame frame = grabber.grab();
        CanvasFrame canvasFrame = new CanvasFrame("Frame");

        while(true) {
            OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
            IplImage image = converter.convert(frame);
            frame = grabber.grab();
            canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasFrame.showImage(frame);
        }

    }
}