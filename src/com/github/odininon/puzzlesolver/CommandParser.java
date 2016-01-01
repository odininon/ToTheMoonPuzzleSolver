package com.github.odininon.puzzlesolver;

/**
 * Created by odin on 12/31/2015.
 */
public class CommandParser {
    public static Board parse(String command, Board board) {
        Board newBoard = null;

        if (command.startsWith("c")) {
            newBoard = board.toggleColumn(Integer.decode(String.valueOf(command.charAt(1))));
        }

        if (command.startsWith("r")) {
            newBoard = board.toggleRow(Integer.decode(String.valueOf(command.charAt(1))));
        }

        if (command.startsWith("d")) {
            newBoard = board.toggleDiagonal();
        }

        return newBoard;
    }
}
