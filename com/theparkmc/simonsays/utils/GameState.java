package com.theparkmc.simonsays.utils;

public enum GameState {
  IN_LOBBY(true), IN_GAME(false), POST_GAME(false), RESTARTING(false);
  
  private boolean canJoin;
  
  private static GameState currentState;
  
  GameState(boolean canJoin) {
    this.canJoin = canJoin;
  }
  
  public boolean canJoin() {
    return canJoin;
  }
  
  public static void setState(GameState state) {
    return GameState.currentState == state;
  }
  
  public static GameState getState() {
    return currentState;
  }
}
