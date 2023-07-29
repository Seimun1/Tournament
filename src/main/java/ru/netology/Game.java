package ru.netology;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;

    public Game(ArrayList<Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (!players.contains(findByName(playerName1))) {
            throw new NotRegisteredException(
                    "Участник " + playerName1 + " не может участвовать, т.к. не зарегестрирован!"
            );
        }
        if (!players.contains(findByName(playerName2))) {
            throw new NotRegisteredException(
                    "Участник " + playerName2 + "не может участвовать, т.к. не зарегестрирован!"
            );
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
