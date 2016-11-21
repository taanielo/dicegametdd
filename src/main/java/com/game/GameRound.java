package com.game;

import com.game.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRound {
    private List<Player> players;
    private List<Result> results;

    public GameRound(List<Player> players) {
        this.players = new ArrayList<>(players);
        results = new ArrayList<>();
    }

    public void roll() {
        if (!results.isEmpty()) {
            throw new IllegalStateException("Gameround already played!");
        }
        players.forEach(player -> results.add(new Result(player, player.roll())));
    }

    public List<Result> getResults() {
        return results;
    }

    public Result getWinner() {
        return results
                .stream()
                .max(Result::compareTo).get();
    }

    @Override
    public String toString() {
        return results
                .stream()
                .sorted(Result::compareTo)
                .map(result -> result.getPlayer().getName() + " rolled " + result.getRoll())
                .collect(Collectors.joining("\n"));
    }

    public static class Result implements Comparable<Result> {

        private Player player;
        private int roll;

        public Result(Player player, int roll) {
            this.player = player;
            this.roll = roll;
        }

        public int getRoll() {
            return roll;
        }

        public Player getPlayer() {
            return player;
        }

        @Override
        public int compareTo(Result o) {
            return Integer.compare(roll, o.getRoll());
        }
    }
}
