package com.github.odininon.puzzlesolver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by odin on 12/31/2015.
 */
public class Board {
    int width;
    int height;
    List<Square> squares;

    public Board(int height, int width) {
        this(height, width, new ArrayList<>());
    }

    public Board(int height, int width, List<Square> squares) {
        this.height = height;
        this.width = width;

        List<Square> squareList = new ArrayList<>();

        if (squares.isEmpty()) {
            for (int i = 1; i <= width; i++) {
                for (int j = 1; j <= height; j++) {
                    squares.add(new Square(i, j));
                }
            }
        }

        for (Square square : squares) {
            squareList.add(new Square(square.getX(), square.getY(), square.isFilled()));
        }

        this.squares = squareList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Square square : squares) {
            sb.append(square.toString()).append("\n");
        }

        return sb.toString();
    }

    public Board toggleColumn(int column) {
        Board board = Board.copyBoard(this);
        toggleSquares(board, (Square square) -> square.getX() == column);
        return board;
    }

    public static Board copyBoard(Board board) {
        return new Board(board.height, board.width, board.squares);
    }

    public Board toggleRow(int row) {
        Board board = copyBoard(this);
        toggleSquares(board, (Square square) -> square.getY() == row);
        return board;
    }


    public Board toggleDiagonal() {
        Board board = copyBoard(this);
        toggleSquares(board, (Square square) -> square.getX() == square.getY());
        return board;
    }

    public Board toggleSquare(int x, int y) {
        Board board = copyBoard(this);
        toggleSquares(board, (Square square) -> square.getX() == x && square.getY() == y);
        return board;
    }

    public void draw() {
        squares.stream().sorted((a, b) -> {
            if (a.getY() > b.getY()) {
                return -1;
            }
            return 1;
        }).forEach((s) -> {
            s.draw();
            if (s.getX() == this.width) {
                System.out.println();
            }
        });

        System.out.println("Points: " + Board.grade(this));
    }

    private static void toggleSquares(Board board, Predicate<Square> predicate) {
        board.squares.stream().filter(predicate).forEach(Square::toggle);
    }

    public static int grade(Board board) {
        return board.squares.stream().map((s) -> (s.isFilled()) ? 10 : 0).reduce(0, Integer::sum);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
