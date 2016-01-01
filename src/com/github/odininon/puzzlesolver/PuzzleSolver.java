package com.github.odininon.puzzlesolver;

import java.util.Scanner;

/**
 * Created by odin on 12/31/2015.
 */
public class PuzzleSolver {

    public static void main(String[] args) {
        Board board = new Board(5, 5)
                .toggleSquare(1, 1)
                .toggleSquare(2, 1)
                .toggleSquare(4, 1)

                .toggleSquare(1, 2)
                .toggleSquare(2, 2)
                .toggleSquare(4, 2)

                .toggleSquare(1, 3)
                .toggleSquare(2, 3)
                .toggleSquare(4, 3)

                .toggleSquare(1, 5)
                .toggleSquare(2, 5)
                .toggleSquare(4, 5)

                .toggleSquare(3, 4)
                .toggleSquare(5, 4);

        Scanner in = new Scanner(System.in);

        while(true) {
            board.draw();

            System.out.println();
            String command = in.nextLine();

            if (command.equals("q")) {
                break;
            }

            board = CommandParser.parse(command, board);
        }

        in.close();
    }
}
