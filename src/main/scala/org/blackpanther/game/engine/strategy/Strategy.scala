package org.blackpanther.game
package engine
package strategy

import engine.GameEngine.GameState

/**
 * @author MACHIZAUD Andréa
 * @version 8/26/11
 */

sealed trait Strategy 

abstract class UpdateStrategy extends ((GameState) => Unit)
                              with Strategy

import java.awt.{Image, Graphics}

abstract class RenderStrategy extends ((GameState) => Image)
                              with Strategy {
  def gameOverMessage(g : Graphics)
}
abstract class PainterStrategy extends ((GameState) => Unit)
                              with Strategy

abstract class TimerStrategy extends ((GameState) => Unit)
                              with Strategy


private [strategy] abstract class StrategyProvider
