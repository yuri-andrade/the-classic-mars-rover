package br.pucrs.gcs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RoverTest {


    @Test
    void getPosFinal() {
        Rover robertinho = new Rover("1 2 N");
        robertinho.moveRover("LMLMLMLMM");
        assertNotNull(robertinho.getPosFinal());
    }

    @Test
    void moveRover() {
        Rover robertinho = new Rover("1 2 N");
        robertinho.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", robertinho.getPosFinal());
    }

    @Test
    void moveRoverCase2() {
        Rover robertinho = new Rover("3 3 E");
        robertinho.moveRover("MMRMMRMRRM");
        assertEquals("5 1 E", robertinho.getPosFinal());
    }
}