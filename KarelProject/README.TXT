A harder task
=============

Adjust Example01 so that the robot makes a diagonal line of four beepers.

How it's done:

First start the robot at the corner of 1st and 1st, facing north, carrying 4 beepers

        Robot karel = new Robot(1, 1, North, 4);  


Second, make the robot carry out the following set of commands three times.

        karel.putBeeper();
        karel.move();  
        karel.turnLeft(); 
        karel.turnLeft(); 
        karel.turnLeft(); 
        karel.move();
        karel.turnLeft();

then place the last beeper and move out of the way:

        karel.putBeeper();
        karel.move();  

