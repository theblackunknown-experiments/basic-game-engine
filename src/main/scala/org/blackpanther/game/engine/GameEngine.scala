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

  val updater : UpdateStrategy = UpdateStrategyProvider(UpdateStrategyProvider.Default)
  val renderer : RenderStrategy = RenderStrategyProvider(RenderStrategyProvider.Default)
  val painter : PainterStrategy = PainterStrategyProvider(PainterStrategyProvider.Default)
  val timer : TimerStrategy = TimerStrategyProvider(TimerStrategyProvider.Default)

  @volatile var gameState = new GameState()

  def run : Unit = {

    gameState = new GameState(
      running = true,
      over = false
    )

    while(gameState.running) {

      updater.update(gameState)

      renderer.render(gameState)

      painter.repaint(gameState)

      timer.sleep(gameState)

    }

    println("Engine stopped")

  }

}
