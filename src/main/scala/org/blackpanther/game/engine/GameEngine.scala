package org.blackpanther.game
package engine

import strategy._
import java.lang.Runnable

/**
 * @author MACHIZAUD Andréa
 * @version 8/26/11
 */
object GameEngine extends Runnable {

  class GameState(
    val running : Boolean = false,
    val over : Boolean = false
  )

  val update : UpdateStrategy = UpdateStrategyProvider.Default
  val render : RenderStrategy = RenderStrategyProvider.Buffered
  val repaint : PainterStrategy = PainterStrategyProvider.Default
  val sleep : TimerStrategy = TimerStrategyProvider.Default

  @volatile var gameState = new GameState()

  @Override
  def run() {

    gameState = new GameState(
      running = true,
      over = false
    )

    while(gameState.running) {

      println("\n Engine iteration : ")

      update(gameState)

      ui.GamePanel.scene = render(gameState)

      repaint(gameState)

      sleep(gameState)

    }

    println("Engine stopped")

  }

}
