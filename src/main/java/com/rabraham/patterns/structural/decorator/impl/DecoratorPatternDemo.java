package com.rabraham.patterns.structural.decorator.impl;

import com.rabraham.patterns.structural.decorator.Shape;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        log.info("Circle with normal border");
        circle.draw();

        log.info("\nCircle of red border");
        redCircle.draw();

        log.info("\nRectangle of red border");
        redRectangle.draw();
    }
}
