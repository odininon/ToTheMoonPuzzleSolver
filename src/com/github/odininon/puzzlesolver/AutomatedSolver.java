package com.github.odininon.puzzlesolver;

import java.util.*;

/**
 * Created by odin on 12/31/2015.
 */
public class AutomatedSolver {
    private static int ideal = 3;

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

        List<String> commands = compileCommands(board);

        p(board, commands, new ArrayList<>(), 0);
    }

    private static void p(Board board, List<String> commands, List<String> usedCommands, int grade) {
        if (grade == (board.getHeight() & board.getWidth() * 10) & usedCommands.size() == ideal) {
            printCommands(usedCommands);
            System.exit(0);
            return;
        }

        for (String command : commands) {
            Board board1 = CommandParser.parse(command, board);
            int grade1 = Board.grade(board1);

            List<String> newCommands = new ArrayList<>();
            newCommands.addAll(commands);
            newCommands.removeIf((c) -> c.equals(command));

            List<String> newUsedCommands = new ArrayList<>();
            newUsedCommands.addAll(usedCommands);
            newUsedCommands.add(command);

            p(board1, newCommands, newUsedCommands, grade1);
        }
    }

    private static void printCommands(List<String> commands) {
        StringBuilder sb = new StringBuilder();

        for (String command : commands) {
            sb.append(command).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static List<String> compileCommands(Board board) {
        List<String> commands = new ArrayList<>();

        for (int column = 1; column <= board.getWidth(); column++) {
            commands.add("c" + column);
        }

        for (int row = 1; row <= board.getHeight(); row++) {
            commands.add("r" + row);
        }

        commands.add("d");

        return commands;
    }
}
